package entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, max = 30, message = "Invalid Book name")
	private String name;

	@Min(100)
	private double price;

	@PastOrPresent
	private LocalDate publishDate;
	private Topic topic;

	@Min(100)
	@Max(1000)
	private int copies;

	@Size(min = 3, max = 30, message = "Invalid Author name")
	private String authorName;

	public Books(@Size(min = 3, max = 30, message = "Invalid Book name") String name, @Min(100) double price,
			Topic topic, @Min(100) @Max(1000) int copies,
			@Size(min = 3, max = 30, message = "Invalid Author name") String authorName) {
		super();
		this.name = name;
		this.price = price;
		this.topic = topic;
		this.copies = copies;
		this.authorName = authorName;
	}

}
