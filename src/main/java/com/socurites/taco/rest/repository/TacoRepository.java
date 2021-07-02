package com.socurites.taco.rest.repository;

import com.socurites.taco.rest.model.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {
//	Taco save(Taco taco);
}
