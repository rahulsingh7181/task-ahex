package com.rahul.controllers;

import com.rahul.dto.MagicalProduct;
import com.rahul.entities.Product;
import com.rahul.sevices.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/api/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){
        return productServices.saveProduct(product);
    }

    @GetMapping("/{productId}")
    public MagicalProduct getProductById(@PathVariable("productId") Long productId){
        return productServices.getProductById(productId);
    }

    @GetMapping("/allProducts/{pageNo}/{pageSize}")
    public List<MagicalProduct> getAllProduct(@PathVariable("pageNo") Integer pageNo,
                                              @PathVariable("pageSize") Integer pageSize){
        return productServices.getAllProducts(pageNo, pageSize);
    }
}
