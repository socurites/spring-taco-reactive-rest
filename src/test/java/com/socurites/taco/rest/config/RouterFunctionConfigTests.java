package com.socurites.taco.rest.config;

import com.socurites.taco.rest.model.Ingredient;
import com.socurites.taco.rest.model.Taco;
import com.socurites.taco.rest.repository.TacoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class RouterFunctionConfigTests {
  private static final String URI_TACO_PREFIX = "/rest/taco";
  
  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void shouldReturnRecentTacos() {
    webTestClient.get()
      .uri(URI_TACO_PREFIX + "/design")
      .exchange()
      .expectStatus().isOk();
  }
}
