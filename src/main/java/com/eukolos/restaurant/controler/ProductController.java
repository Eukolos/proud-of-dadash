package com.eukolos.restaurant.controler;


import com.eukolos.restaurant.dto.ProductCreateRequest;
import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        return new ResponseEntity<>(productService.createProduct(productCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }



}
