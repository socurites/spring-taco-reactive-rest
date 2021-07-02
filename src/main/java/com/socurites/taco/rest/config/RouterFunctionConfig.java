package com.socurites.taco.rest.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import static reactor.core.publisher.Mono.*;

import com.socurites.taco.rest.model.Taco;
import com.socurites.taco.rest.repository.TacoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
public class RouterFunctionConfig {
  private static final String URI_TACO_PREFIX = "/rest/taco";

  private final TacoRepository tacoRepository;

  public RouterFunctionConfig(TacoRepository tacoRepository) {
    this.tacoRepository = tacoRepository;
  }


  @Bean
  public RouterFunction<?> routerFunction() {
    return route(GET(URI_TACO_PREFIX + "/design"), this::recents)
      .andRoute(POST(URI_TACO_PREFIX + "/design"), this::postTaco);
  }

  private Mono<ServerResponse> recents(ServerRequest serverRequest) {
    return ok()
      .body(tacoRepository.findAll().take(12), Taco.class);
  }

  private Mono<ServerResponse> postTaco(ServerRequest serverRequest) {
    Mono<Taco> taco = serverRequest.bodyToMono(Taco.class);
    Mono<Taco> savedTaco = tacoRepository.saveAll(taco).next();

    return ok()
      .body(savedTaco, Taco.class);
  }
}
