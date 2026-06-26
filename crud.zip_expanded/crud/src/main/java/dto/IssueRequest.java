package dto;

import lombok.Data;

@Data
public class IssueRequest {
	private Long studentId;
	private Long bookId;
	private Integer durationDays; // Default to 14 days if not specified
}
