package com.oskarro.comparator.gateway;

import com.oskarro.comparator.model.Item;
import com.oskarro.comparator.repository.ItemRepository;
import com.oskarro.comparator.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/item")
public class ItemGateway {

    ItemService itemService;
    ItemRepository itemRepository;

    public ItemGateway(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<Iterable<Item>> getAll() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{itemId}")
    public ResponseEntity<Item> findById(@PathVariable final String itemId) throws Exception {
        Item item = itemService
                .findById(itemId)
                .orElseThrow(Exception::new);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        if (item.getHash().isEmpty()) {
            item.setHash(UUID.randomUUID().toString());
        }
        Item save = itemService.save(item);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{itemId}")
    public void delete(@PathVariable final String itemId) {
        itemService.deleteById(itemId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public ResponseEntity<Iterable<Item>> getItemsByProductId(@RequestParam final String productId) {
        return new ResponseEntity<>(itemService.getAllByProductId(productId), HttpStatus.OK);
    }


}
