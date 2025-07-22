package com.example.salonmanager.response;

import com.example.salonmanager.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private Integer cartItemId;
    private Integer id;
    private String name;
    private String image;
    private BigDecimal price;
    private Integer haircutTime;
    private Category.CategoryType categoryType;
}
