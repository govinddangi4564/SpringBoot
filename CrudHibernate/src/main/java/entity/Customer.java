package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(min = 3, max = 30, message = "Invalid name")
	private String name;

	@Min(3)
	@Max(70)
	private int age;
	private Food food;

	@Min(100)
	@Max(5000)
	private double amount;
	
	@PastOrPresent
	private LocalDateTime orderTime;

	@Pattern(regexp = "^[0-9]{10}", message = "Invalid Phone Number")
	private String phone;

	public Customer(@NotBlank @Size(min = 3, max = 30, message = "Invalid name") String name, @Min(3) @Max(70) int age,
			Food food, @Min(100) @Max(5000) double amount, LocalDateTime orderTime,
			@Pattern(regexp = "^[0-9]{10}", message = "Invalid Phone Number") String phone) {
		super();
		this.name = name;
		this.age = age;
		this.food = food;
		this.amount = amount;
		this.orderTime = orderTime;
		this.phone = phone;
	}

}
