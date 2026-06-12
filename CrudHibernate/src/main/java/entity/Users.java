package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Orders> orders;

//	@Transient
//	private double totalAmount;

	public double getTotalAmount() {
		return orders.stream().mapToDouble(a -> a.getPrice() * a.getQuantity()).sum();
	}
}
