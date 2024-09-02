package com.example.chacasanova.dto;

import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.NotBlank;

public record GiftDTO(
  @NotBlank(message = "Image link is mandatory")
    @Pattern(regexp = "^(http|https)://.*$", message = "Image link must be a valid URL")
    String imgLink,

    @NotBlank(message = "title is mandatory")
    String title,
    String description, 

    @NotBlank(message = "Example link is mandatory")
   @Pattern(regexp = "^(http|https)://.*$", message = "Example link must be a valid URL")
    String exampleLink

) {
    
}
