package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private Long id;
	private String name;
	private int age;

	@Column(nullable = false, unique = true)
	private String rollno;

	public Student(String name, int age, String rollno) {
		super();
		this.name = name;
		this.age = age;
		this.rollno = rollno;
	}
	
	
}
