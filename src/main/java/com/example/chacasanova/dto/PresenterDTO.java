package com.example.chacasanova.dto;


import jakarta.validation.constraints.NotBlank;

public record PresenterDTO(
   
    @NotBlank(message = "phone is requuired")
    String phone,
    @NotBlank(message = "presenter is required")
    String presenter
) {
}
