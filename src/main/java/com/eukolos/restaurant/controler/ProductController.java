package com.eukolos.restaurant.controler;


import com.eukolos.restaurant.dto.ProductCreateRequest;
import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        return productService.createProduct(productCreateRequest);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }



}
