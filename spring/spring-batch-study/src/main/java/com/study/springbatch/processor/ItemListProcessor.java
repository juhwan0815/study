package com.study.springbatch.processor;

import com.study.springbatch.domain.Sale;
import com.study.springbatch.domain.Tax;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ItemListProcessor implements ItemProcessor<Sale, List<Tax>> {

    @Override
    public List<Tax> process(Sale item) throws Exception {
        return Arrays.asList(
                new Tax(item.getAmount(), item.getOwnerNo()),
                new Tax((long) (item.getAmount() / 1.1), item.getOwnerNo()),
                new Tax(item.getAmount() / 11, item.getOwnerNo()));
    }
}
