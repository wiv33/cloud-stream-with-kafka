package org.psawesome.service;

import lombok.extern.slf4j.Slf4j;
import org.psawesome.service.dto.ProductDto;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

/**
 * package: org.psawesome.service
 * author: PS
 * DATE: 2020-06-13 토요일 00:37
 */
@Slf4j
@Component
@EnableBinding(Source.class)
public class ProductSource {

  @Bean
  @InboundChannelAdapter(value = OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
  public MessageSource<List<ProductDto>> getProducts() {
    List<ProductDto> products = Stream.of(new ProductDto(100L, "Hello", 8000), new ProductDto(103L, "world", 6000))
            .collect(Collectors.toList());
    log.info("products : {}", products);
    return () -> MessageBuilder.withPayload(products).build();
  }
}
