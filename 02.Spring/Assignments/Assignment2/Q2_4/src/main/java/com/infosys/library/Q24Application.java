package com.infosys.library;

import com.infosys.library.beans.Book;
import com.infosys.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Q24Application implements CommandLineRunner {

	@Autowired
	LibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(Q24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String bookIsbn,bookTitle,bookAuthor,bookGenre;
		Integer bookPublishYear;
		Boolean bookAvaliable;
		Book book;
		List<Book> books;

		System.out.println("Enter 1 to add a new book");
		System.out.println("Enter 2 to get book by ISBN");
		System.out.println("Enter 3 to Update Book");
		System.out.println("Enter 4 to Delete Book");
		System.out.println("Enter 5 to get book by Author");
		System.out.println("Enter 6 to get book by Genre");
		System.out.println("Enter 7 to get book published after year");

		Integer operation=scanner.nextInt();
		scanner.nextLine();
		switch (operation) {
			case 1:
				System.out.println("Enter ISBN :");
				bookIsbn = scanner.nextLine();
				System.out.println("Enter Title :");
				bookTitle = scanner.nextLine();
				System.out.println("Enter Author :");
				bookAuthor = scanner.nextLine();
				System.out.println("Enter Genre :");
				bookGenre = scanner.nextLine();
				System.out.println("Enter Publish Year :");
				bookPublishYear = scanner.nextInt();
				System.out.println("Enter Avaliable :");
				bookAvaliable = scanner.nextBoolean();

				book=new Book(bookIsbn, bookTitle, bookAuthor, bookPublishYear, bookGenre, bookAvaliable);
				libraryService.addBook(book);
				break;

			case 2:
				System.out.println("Enter ISBN :");
				bookIsbn = scanner.nextLine();
				book=  libraryService.getBooksByIsbn(bookIsbn);
				System.out.println(book.toString());
				break;

			case 3:
				System.out.println("Enter ISBN :");
				bookIsbn = scanner.nextLine();
				System.out.println("Enter Title :");
				bookTitle = scanner.nextLine();
				System.out.println("Enter Author :");
				bookAuthor = scanner.nextLine();
				System.out.println("Enter Genre :");
				bookGenre = scanner.nextLine();
				System.out.println("Enter Publish Year :");
				bookPublishYear = scanner.nextInt();
				System.out.println("Enter Avaliable :");
				bookAvaliable = scanner.nextBoolean();

				book=new Book(bookIsbn, bookTitle, bookAuthor, bookPublishYear, bookGenre, bookAvaliable);
				libraryService.updateBook(book);
				break;

			case 4:
				System.out.println("Enter ISBN :");
				bookIsbn = scanner.nextLine();
				libraryService.deleteBook(bookIsbn);
				break;

			case 5:
				System.out.println("Enter Author :");
				bookAuthor = scanner.nextLine();
				books=libraryService.getBooksByAuthor(bookAuthor);
				books.forEach(book1 -> System.out.println(book1.toString()));
				break;

			case 6:
				System.out.println("Enter Genre :");
				bookGenre = scanner.nextLine();
				books=libraryService.getBooksByGenre(bookGenre);
				books.forEach(book1 -> System.out.println(book1.toString()));
				break;

			case 7:
				System.out.println("Enter Publish Year :");
				bookPublishYear = scanner.nextInt();
				books=libraryService.getBooksPublishedAfterYear(bookPublishYear);
				books.forEach(book1 -> System.out.println(book1.toString()));
				break;

		}
	}
}
