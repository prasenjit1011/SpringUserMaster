// dto/ProductDTO.java
package com.example.m_paridarshan.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 20, message = "Product name must be between 4 and 20 characters")
    private String name;

    @Min(value = 21, message = "Price must be greater than 20")
    private double price;
}