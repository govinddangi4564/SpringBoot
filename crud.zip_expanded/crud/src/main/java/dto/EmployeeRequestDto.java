package dto;

import lombok.Data;

@Data
public class EmployeeRequestDto {
	private String name;
	private String email;
	private Double salary;
}
