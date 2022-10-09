package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.ProductCreateRequest;
import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.dto.ProductDtoConverter;
import com.eukolos.restaurant.dto.ProductOrderRequest;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository repository, ProductDtoConverter productDtoConverter) {
        this.repository = repository;
        this.productDtoConverter = productDtoConverter;
    }

    public ProductDto createProduct (ProductCreateRequest productCreateRequest){
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .price(productCreateRequest.getPrice())
                .build();
        Product response = repository.save(product);

        return productDtoConverter.convert(response);
    }

    public ProductDto orderProduct (ProductOrderRequest productOrderRequest){
        Product mainProduct = repository.findById(productOrderRequest.getId()).orElse(null);
        Product product = Product.builder()
                .name(mainProduct.getName())
                .price(mainProduct.getPrice())
                .amount(mainProduct.getAmount())
                .build();
        Product response = repository.save(product);

        return productDtoConverter.convert(response);
    }
}
