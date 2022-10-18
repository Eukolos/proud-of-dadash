package com.eukolos.restaurant.controler;


import com.eukolos.restaurant.dto.ProductCreateRequest;
import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        return productService.createProduct(productCreateRequest);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }



}
