package com.ymmihw.springframework;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    @Cacheable(value = "itemCache")
    public Item getItemForId(String id) {
        log.info("call from ItemService");
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Item saveOrUpdate(String id) {
        Optional<Item> op = itemRepository.findById(id);
        Item item;
        if (op.isPresent()) {
            item = op.get();
            item.setDescription("" + Instant.now());
        } else {
            item = new Item();
            item.setId(id);
            item.setDescription("" + Instant.now());
        }

        return itemRepository.save(item);
    }
}
