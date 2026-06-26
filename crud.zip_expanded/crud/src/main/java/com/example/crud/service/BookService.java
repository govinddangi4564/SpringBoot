package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Book;
import com.example.crud.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	public Book getBookById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
	}

	public Book createBook(Book book) {
		if (book.getTotalCopies() != null) {
			book.setAvailableCopies(book.getTotalCopies());
		} else {
			book.setTotalCopies(1);
			book.setAvailableCopies(1);
		}
		return repo.save(book);
	}

	public Book updateBook(Long id, Book bookDetails) {
		return repo.findById(id).map(book -> {
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setIsbn(bookDetails.getIsbn());

			// Adjust available copies if total copies changed
			if (bookDetails.getTotalCopies() != null) {
				int diff = bookDetails.getTotalCopies() - book.getTotalCopies();
				book.setTotalCopies(bookDetails.getTotalCopies());
				book.setAvailableCopies(Math.max(0, book.getAvailableCopies() + diff));
			}
			return repo.save(book);
		}).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
	}

	public void deleteBook(Long id) {
		repo.deleteById(id);
	}

	public List<Book> searchBooks(String query) {
		return repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbnContainingIgnoreCase(query, query,
				query);
	}

}

