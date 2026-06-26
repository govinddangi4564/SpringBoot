package com.example.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entity.BookIssueRecord;
import com.example.crud.entity.IssueStatus;

public interface BookIssueRepository extends JpaRepository<BookIssueRecord, Long>{
	List<BookIssueRecord> findByStudentId(Long studentId);
	List<BookIssueRecord> findByBookId(Long bookId);
	
	// Find active issue record for a student and a book (where returnDate is null)
    Optional<BookIssueRecord> findByStudentIdAndBookIdAndReturnDateIsNull(Long studentId, Long bookId);
    
    List<BookIssueRecord> findByStatus(IssueStatus status);
}
