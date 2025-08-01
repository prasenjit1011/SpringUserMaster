// dto/ProductDTO.java
package com.example.m_paridarshan.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 21, message = "Price must be greater than 20")
    private double price;
}
