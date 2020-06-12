package org.psawesome.discountservice;

import lombok.extern.slf4j.Slf4j;
import org.psawesome.discountservice.dto.ProductDto;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * package: org.psawesome.discountservice
 * author: PS
 * DATE: 2020-06-13 토요일 00:46
 */
@Component
@Slf4j
public class DiscountProcessor {

  @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
  public List<ProductDto> addDiscountToProduct(List<ProductDto> productDtoList) {
    ArrayList<ProductDto> productDtos = new ArrayList<>();
    productDtoList.forEach(productDto -> {
      if (productDto.getPrice() > 8000) {
        productDtos.add(calculatePrice(productDto, 10));
      } else if (productDto.getPrice() > 5000) {
        productDtos.add(calculatePrice(productDto, 5));
      }
    });
    return productDtos;
  }

  private ProductDto calculatePrice(ProductDto productDto, int percentage) {
    double actualPrice = productDto.getPrice();
    double discount = actualPrice * percentage / 100;
    productDto.setPrice(actualPrice - discount);
    log.info("product actual price is {}, after discount total price is {}",
            actualPrice, productDto.getPrice());
    return productDto;
  }
}
