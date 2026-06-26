package com.example.crud.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.entity.Book;
import com.example.crud.entity.BookIssueRecord;
import com.example.crud.entity.IssueStatus;
import com.example.crud.entity.Student;
import com.example.crud.repository.BookIssueRepository;
import com.example.crud.repository.BookRepository;
import com.example.crud.repository.StudentRepository;

import dto.IssueRequest;
import dto.ReturnRequest;

@Service
public class LibraryService {

	@Autowired
	private BookIssueRepository issueRepo;

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Transactional
	public BookIssueRecord issueBook(IssueRequest request) {
		Student student = studentRepo.findById(request.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student not found with ID: " + request.getStudentId()));

		Book book = bookRepo.findById(request.getBookId())
				.orElseThrow(() -> new RuntimeException("Book not found with ID: " + request.getBookId()));

		// Check if student already has this book issued and not returned
		issueRepo.findByStudentIdAndBookIdAndReturnDateIsNull(student.getId(), book.getId()).ifPresent(record -> {
			throw new RuntimeException("Student already has active issue record for this book.");
		});

		// Check if book is available
		if (book.getAvailableCopies() <= 0) {
			throw new RuntimeException("No available copies of this book left to issue.");
		}

		// Decrement available copies
		book.setAvailableCopies(book.getAvailableCopies() - 1);
		bookRepo.save(book);

		// Create issue record
		BookIssueRecord record = new BookIssueRecord();
		record.setStudent(student);
		record.setBook(book);
		record.setIssueDate(LocalDate.now());

		int days = request.getDurationDays() != null ? request.getDurationDays() : 14;
		record.setDueDate(LocalDate.now().plusDays(days));
		record.setStatus(IssueStatus.ISSUED);

		return issueRepo.save(record);
	}

	@Transactional
	public BookIssueRecord returnBook(ReturnRequest request) {
		Book book = bookRepo.findById(request.getBookId())
				.orElseThrow(() -> new RuntimeException("Book not fount with ID: " + request.getBookId()));

		Student student = studentRepo.findById(request.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student not found with ID: " + request.getStudentId()));

		// Find active issue record
		BookIssueRecord record = issueRepo.findByStudentIdAndBookIdAndReturnDateIsNull(student.getId(), book.getId())
				.orElseThrow(() -> new RuntimeException(
						"No active issue record found for student " + student.getId() + " and book " + book.getId()));

		// Update Record
		record.setReturnDate(LocalDate.now());
		record.setStatus(IssueStatus.RETURNED);
		issueRepo.save(record);

		// Increment available copies
		book.setAvailableCopies(book.getAvailableCopies() + 1);
		bookRepo.save(book);

		return record;
	}

	@Transactional
	public void updateOverdueRecords() {
		List<BookIssueRecord> activeIssues = issueRepo.findByStatus(IssueStatus.ISSUED);
		LocalDate today = LocalDate.now();
		for (BookIssueRecord record : activeIssues) {
			if (record.getDueDate().isBefore(today)) {
				record.setStatus(IssueStatus.OVERDUE);
				issueRepo.save(record);
			}
		}
	}

	public List<BookIssueRecord> getAllIssues() {
		return issueRepo.findAll();
	}

	public List<BookIssueRecord> getIssuesByStudent(Long studentId) {
		return issueRepo.findByStudentId(studentId);
	}

	public List<BookIssueRecord> getIssuesByStatus(IssueStatus status) {
		return issueRepo.findByStatus(status);
	}
}
