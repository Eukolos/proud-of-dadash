package com.eukolos.restaurant.dto.converter;

import com.eukolos.restaurant.dto.ProductDto;
import com.eukolos.restaurant.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoConverter {
    public List<ProductDto> convertAll(List<Product> products) {

        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product: products) {
            productDtoList.add(convert(product));
        }
        return productDtoList;
    }

    public ProductDto convert(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .amount(product.getAmount())
                .price(product.getPrice())
                .build();
    }
}
