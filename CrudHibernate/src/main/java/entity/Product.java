package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", indexes = { @Index(name = "idx_brand_name", columnList = "brand, name") })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String brand;
	@Column(nullable = false, unique = true)
	private String category;
	private Double price;

	public Product(String name, String brand, String category, Double price) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

}
