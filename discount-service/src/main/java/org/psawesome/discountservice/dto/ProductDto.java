package org.psawesome.discountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package: org.psawesome.discountservice.dto
 * author: PS
 * DATE: 2020-06-13 토요일 00:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private Long id;
  private String name;
  private double price;
}
