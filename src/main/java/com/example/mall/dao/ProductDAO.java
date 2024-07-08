package com.example.mall.dao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ProductDAO {
    @NotNull(message = "{mall.products.create.errors.name_is_null}")
    @Size(min = 3, max = 50, message = "{mall.products.create.errors.name_size_is_invalid}")
    private String name;
    @NotNull(message = "{mall.products.create.errors.price_is_null}")
    private Integer price;

}
