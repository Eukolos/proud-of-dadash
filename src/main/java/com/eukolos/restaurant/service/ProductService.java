package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.request.ProductCreateRequest;
import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.dto.converter.ProductDtoConverter;
import com.eukolos.restaurant.dto.request.ProductOrderRequest;
import com.eukolos.restaurant.exception.NotFoundException;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductDtoConverter productDtoConverter;

    public ProductDto createProduct (ProductCreateRequest productCreateRequest){
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .price(productCreateRequest.getPrice())
                .uniquee(true)
                .build();
        Product response = repository.save(product);

        return productDtoConverter.convert(response);
    }

    public List<ProductDto> getAllProduct() {
        /*
        https://vladmihalcea.com/spring-data-findall-anti-pattern/
        List<Product> productList = repository.findAll();
         */
        List<Product> productList = repository.findAllByUniquee(true);

        return productDtoConverter.convertAll(productList);
    }

    public Product orderProduct (ProductOrderRequest productOrderRequest){
        Product mainProduct = repository.findById(productOrderRequest.getId())
                .orElseThrow(() -> new NotFoundException("no product with this id:" + productOrderRequest.getId() + " was found"));
        Product product = Product.builder()
                .name(mainProduct.getName())
                .price(mainProduct.getPrice())
                .amount(productOrderRequest.getAmount())
                .build();

        return repository.save(product);
    }
}
