package com.chj.gr.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Model representing a MyModel to be stored in the database")
//@Data
public class MyModel {
	
	@Schema(description = "Unique identifier of the Product", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
	
	@Schema(description = "Name of the product", example = "product name", required = true, accessMode = Schema.AccessMode.READ_WRITE)
    private String name;
    
	@Schema(description = "Description of the Product", example = "product description", required = true, accessMode = Schema.AccessMode.READ_WRITE)
    private String description;
    
    @Schema(description = "Price of the product", example = "99.88", required = true, accessMode = Schema.AccessMode.READ_WRITE)
    private BigDecimal price;
    
	public MyModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MyModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
    
    
}