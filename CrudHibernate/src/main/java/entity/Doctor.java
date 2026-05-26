package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min = 3, max = 30, message = "Invalid name")
	private String name;
	
	@Min(5)
	@Max(75)
	private int age;
	private LocalDate dob;

	private int patientId;
	private String specialist;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(unique = true, nullable = false)
	@Email(message = "Invalid email")
	private String email;
	
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "^[0-9]{10}", message = "Invalid phone number")
	private String phone;

	public Doctor(String name, int age, LocalDate dob, int patientId, String specialist, Gender gender, String email,
			String phone) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.patientId = patientId;
		this.specialist = specialist;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

}
