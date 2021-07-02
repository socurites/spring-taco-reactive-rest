package com.socurites.taco.rest.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;
	
	private Date createdAt;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}
