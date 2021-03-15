package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId,Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model){


        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item",item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){

        itemRepository.save(item);

        // @ModelAttribute 가 넣어주기 때문에 생략가능
//        model.addAttribute("item",item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){
        // HelloData-> helloData 로 모델에 담긴다.
        // Item -> item 으로 모델에 담긴다.

        itemRepository.save(item);

        // @ModelAttribute 가 넣어주기 때문에 생략가능
//        model.addAttribute("item",item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV4(Item item){
        // HelloData-> helloData 로 모델에 담긴다.
        // Item -> item 으로 모델에 담긴다.

        itemRepository.save(item);

        // @ModelAttribute 가 넣어주기 때문에 생략가능
//        model.addAttribute("item",item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV5(Item item){

        itemRepository.save(item);

        return "redirect:/basic/items/" + item.getId();
    }


    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes){

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId",savedItem.getId());
        redirectAttributes.addAttribute("status",true);

        // redirectAttribute에 넣은 itemId가 들어간다. 나머지는 쿼리파라미터 형식으로 들어가게 된다.
        // URL 인코딩도 해결
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId,@ModelAttribute Item item){

        itemRepository.update(itemId,item);

        return "redirect:/basic/items/{itemId}";
    }

    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,20));
    }
}
