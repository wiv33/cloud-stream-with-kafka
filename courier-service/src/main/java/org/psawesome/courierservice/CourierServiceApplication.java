package org.psawesome.courierservice;

import lombok.extern.slf4j.Slf4j;
import org.psawesome.courierservice.dto.ProductDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class CourierServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourierServiceApplication.class, args);
  }

  @StreamListener(Sink.INPUT)
  public void orderDispatched(List<ProductDto> products) {
    products.forEach(productDto -> log.info("Order dispatched to your mailing address : {}", productDto));
  }
}
