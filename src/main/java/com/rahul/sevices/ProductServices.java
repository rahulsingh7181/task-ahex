package com.rahul.sevices;

import com.rahul.dto.MagicalProduct;
import com.rahul.entities.Product;
import com.rahul.repository.ProductRepository;
import com.rahul.utils.Utility;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    // Add Product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    // Get Product By ID
    public MagicalProduct getProductById(Long productId){
        Product product = productRepository.findById(productId).get();
        MagicalProduct magicalProduct = new MagicalProduct();
        magicalProduct.setProductId(product.getProductId());
        magicalProduct.setProductCode(product.getProductCode());
        magicalProduct.setProductName(product.getProductName());
        magicalProduct.setProductPrice(product.getProductPrice());
        magicalProduct.setMagicalProduct(Utility.toCheckGivenIdIsPrimeOrNot(product.getProductId()));
        return magicalProduct;
    }

    // Get All Products with Pagination
    public List<MagicalProduct> getAllProducts(int pageNo, int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> products = (Page<Product>) productRepository.findAll(paging);
        List<MagicalProduct> list = new ArrayList<>();
        for(Product p:products){
            MagicalProduct magicalProduct = new MagicalProduct();
            magicalProduct.setProductId(p.getProductId());
            magicalProduct.setProductCode(p.getProductCode());
            magicalProduct.setProductName(p.getProductName());
            magicalProduct.setProductPrice(p.getProductPrice());
            magicalProduct.setMagicalProduct(Utility.toCheckGivenIdIsPrimeOrNot(p.getProductId()));
            list.add(magicalProduct);
        }
        return list;
    }
}
