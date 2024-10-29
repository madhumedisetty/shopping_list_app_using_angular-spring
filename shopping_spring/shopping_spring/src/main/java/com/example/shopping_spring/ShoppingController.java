package com.example.shopping_spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    private final ShoppingService service;

    public ShoppingController(ShoppingService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<ShoppingItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ShoppingItem> getItemById(@PathVariable Long id) {
        return service.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/items")
    public ShoppingItem addItem(@RequestBody ShoppingItem item) {
        return service.addItem(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ShoppingItem> updateItem(@PathVariable Long id, @RequestBody ShoppingItem item) {
        if (!service.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id);
        return ResponseEntity.ok(service.updateItem(item));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!service.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items/category/{category}")
    public List<ShoppingItem> getItemsByCategory(@PathVariable String category) {
        return service.getItemsByCategory(category);
    }

    // PATCH: Update purchased status
    @PatchMapping("/items/{id}/purchasedStatus")
    public ResponseEntity<ShoppingItem> updatePurchasedStatus(
        @PathVariable Long id,
        @RequestBody Map<String, Boolean> status) {

        boolean isPurchased = status.get("isPurchased");
        try {
            ShoppingItem updatedItem = service.updatePurchasedStatus(id, isPurchased);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
