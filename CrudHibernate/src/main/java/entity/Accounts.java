package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(min = 3, max = 20, message = "Invalid name")
	private String name;

	@Size(min = 5, max = 20, message = "Invalid account number")
	@Column(unique = true, nullable = false)
	private String accNumber;

	@Min(0)
	private double Balance;

	public Accounts(@NotBlank @Size(min = 3, max = 20, message = "Invalid name") String name,
			@Size(min = 5, max = 20, message = "Invalid account number") String accNumber, @Min(0) double Balance) {
		super();
		this.name = name;
		this.accNumber = accNumber;
		this.Balance = Balance;
	}

}
