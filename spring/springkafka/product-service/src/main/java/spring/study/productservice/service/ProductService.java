package spring.study.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.study.productservice.domain.Product;
import spring.study.productservice.kafka.message.OrderCancelMessage;
import spring.study.productservice.kafka.message.OrderCreateMessage;
import spring.study.productservice.kafka.message.OrderCreateResultMessage;
import spring.study.productservice.kafka.message.ProductStockChangeResult;
import spring.study.productservice.kafka.sender.KafkaOrderCreateResultMessageSender;
import spring.study.productservice.model.ProductResponse;
import spring.study.productservice.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaOrderCreateResultMessageSender kafkaOrderCreateResultMessageSender;

    @PostConstruct
    public void init(){
        productRepository.save(Product.createProduct("라면",100,1000));
        productRepository.save(Product.createProduct("햄버거",100,5000));
        productRepository.save(Product.createProduct("치킨",100,10000));
    }

    @Transactional
    public void changeStock(OrderCreateMessage orderCreateMessage){

        OrderCreateResultMessage orderCreateResultMessage = null;

        try {
            Product findProduct = productRepository.findById(orderCreateMessage.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException());
            findProduct.minusStock(orderCreateMessage.getCount());

            orderCreateResultMessage = OrderCreateResultMessage
                            .createResultMessage(orderCreateMessage,
                                                 ProductStockChangeResult.SUCCESS);

        }catch(Exception ex){
            orderCreateResultMessage = OrderCreateResultMessage
                    .createResultMessage(orderCreateMessage,
                                        ProductStockChangeResult.FAIL);
        }

        kafkaOrderCreateResultMessageSender.send(orderCreateResultMessage);
    }

    @Transactional
    public void plusStock(OrderCancelMessage orderCancelMessage){
        Product findProduct = productRepository.findById(orderCancelMessage.getProductId())
                .orElseThrow(() -> new IllegalStateException());

        findProduct.plusStock(orderCancelMessage.getCount());
    }

    public List<ProductResponse> findProducts() {
        List<Product> findProducts = productRepository.findAll();

        return findProducts.stream()
                .map(product -> ProductResponse.from(product))
                .collect(Collectors.toList());
    }


}
