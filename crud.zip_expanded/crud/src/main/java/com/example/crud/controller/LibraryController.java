package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.BookIssueRecord;
import com.example.crud.entity.IssueStatus;
import com.example.crud.service.LibraryService;

import dto.IssueRequest;
import dto.ReturnRequest;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/issue")
	public BookIssueRecord issueBook(@RequestBody IssueRequest request) {
		return libraryService.issueBook(request);
	}

	@PostMapping("/return")
	public BookIssueRecord returnBook(@RequestBody ReturnRequest request) {
		return libraryService.returnBook(request);
	}

	@GetMapping("/issues")
	public List<BookIssueRecord> getAllIssues() {
		return libraryService.getAllIssues();
	}

	@GetMapping("/student/{studentId}/issues")
	public List<BookIssueRecord> getIssuesByStudent(@PathVariable Long studentId) {
		return libraryService.getIssuesByStudent(studentId);
	}

	@GetMapping("/issues/status/{status}")
	public List<BookIssueRecord> getIssuesByStatus(@PathVariable IssueStatus status) {
		return libraryService.getIssuesByStatus(status);
	}

	@PostMapping("/issues/check-overdue")
	public String checkOverdue() {
		libraryService.updateOverdueRecords();
		return "Overdue statuses updated successfully";
	}
}