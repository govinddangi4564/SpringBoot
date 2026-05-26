package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String name;
	private int age;
	private LocalDate dob;

	@Column(unique = true)
	private int patientId;
	private String specialist;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String email;
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
