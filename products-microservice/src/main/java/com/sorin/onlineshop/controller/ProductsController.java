package com.sorin.onlineshop.controller;

import com.sorin.onlineshop.model.Category;
import com.sorin.onlineshop.model.Product;
import com.sorin.onlineshop.model.ProductRequest;
import com.sorin.onlineshop.repository.CategoriesRepository;
import com.sorin.onlineshop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/categories")
    public List<Category> getCategories(){

        return categoriesRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable(value = "id") Long id){
        Optional<Category> maybeCategory = categoriesRepository.findById(id);
        return maybeCategory.get();
    }

//    @GetMapping("/categories/{categoryId}/products")
//    public List<Product> getProductsForCategory(@PathVariable(value = "categoryId") Long categoryId){
//
//        return productsRepository.findByCategoryId(categoryId);
//    }

    @GetMapping("/categories/{categoryId}/products")
    public List<Product> getProductsForCategory(@PathVariable(value = "categoryId") Long categoryId){
        Optional<Category> maybeCategory = categoriesRepository.findById(categoryId);
        return maybeCategory.get().getProducts();
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoriesRepository.save(category);
    }

//    @PostMapping("/categories/{id}/products")
//    public Product createProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id){
//        Optional<Category> category = categoriesRepository.findById(id);
//        return productsRepository.save(new Product(category.get(), productRequest.getProduct(), productRequest.getPrice()));
//    }

    @PostMapping("/categories/{id}/products")
    public Product createProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id){
        Optional<Category> maybeCategory = categoriesRepository.findById(id);
        Category category = maybeCategory.get();
        Product product = productsRepository.saveAndFlush(new Product(productRequest.getProduct(), productRequest.getPrice()));
        category.getProducts().add(product);
        categoriesRepository.save(category);
        return product;
    }

}
