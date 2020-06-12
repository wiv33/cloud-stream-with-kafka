package org.psawesome.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package: org.psawesome.service.dto
 * author: PS
 * DATE: 2020-06-13 토요일 00:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private Long id;
  private String name;
  private double price;
}
