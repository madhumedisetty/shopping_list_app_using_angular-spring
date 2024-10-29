package com.example.shopping_spring;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {
    private final ShoppingItemRepository repository;

    public ShoppingService(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    public List<ShoppingItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<ShoppingItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public ShoppingItem addItem(ShoppingItem item) {
        return repository.save(item);
    }

    public ShoppingItem updateItem(ShoppingItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public List<ShoppingItem> getItemsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public ShoppingItem updatePurchasedStatus(Long id, boolean isPurchased) {
        Optional<ShoppingItem> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            ShoppingItem item = optionalItem.get();
            item.setPurchased(isPurchased);
            return repository.save(item);
        } else {
            throw new RuntimeException("Item not found with ID: " + id);
        }
    }
}
