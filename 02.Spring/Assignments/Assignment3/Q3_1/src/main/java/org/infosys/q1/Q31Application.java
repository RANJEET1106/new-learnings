package org.infosys.q1;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.beans.LibraryBranch;
import org.infosys.q1.beans.Publisher;
import org.infosys.q1.service.AuthorService;
import org.infosys.q1.service.BookService;
import org.infosys.q1.service.LibraryBranchService;
import org.infosys.q1.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Q31Application implements CommandLineRunner {
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    LibraryBranchService libraryBranchService;
    @Autowired
    private BookService bookService;


    public static void main(String[] args) {
        SpringApplication.run(Q31Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean flag=true;
        Scanner scanner=new Scanner(System.in);
        String authourName, publisherName, branchName, bookName;

        List<Author> authors;
        List<Book> books;
        List<Publisher> publishers;
        List<LibraryBranch> libraryBranches;

        Author author;
        Publisher publisher;
        LibraryBranch libraryBranch;
        Book book;

        int id,number;

        while(flag){
            System.out.println("Enter 1 to add Author");
            System.out.println("Enter 2 to add Publisher");
            System.out.println("Enter 3 to add LibraryBranch");
            System.out.println("Enter 4 to add Book");

            System.out.println("Enter 5 to view all Author");
            System.out.println("Enter 6 to view all Publisher");
            System.out.println("Enter 7 to view all LibraryBranch");
            System.out.println("Enter 8 to view all Book");

            System.out.println("Enter 9 to update Author");
            System.out.println("Enter 10 to update Publisher");
            System.out.println("Enter 11 to update LibraryBranch");
            System.out.println("Enter 12 to update Book branches");

            System.out.println("Enter 13 to remove Author");
            System.out.println("Enter 14 to remove Publisher");
            System.out.println("Enter 15 to remove LibraryBranch");
            System.out.println("Enter 16 to remove Book ");



            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter Author Name");
                    authourName=scanner.next();
                    author=new Author(authourName);
                    authorService.addAuthor(author);
                    break;

                case 2:
                    System.out.println("Enter Publisher Name");
                    publisherName=scanner.next();
                    publisher=new Publisher(publisherName);
                    publisherService.addPublisher(publisher);
                    break;

                case 3:
                    System.out.println("Enter LibraryBranch Name");
                    branchName=scanner.next();
                    libraryBranch=new LibraryBranch(branchName);
                    libraryBranchService.addLibraryBranch(libraryBranch);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("Enter Book Name");
                    bookName=scanner.nextLine();
                    book=new Book(bookName);

                    System.out.println("Enter the publisher id");
                    id=scanner.nextInt();
                    publisher = publisherService.getPublisherById(id);

                    System.out.println("Enter number of authors");
                    number=scanner.nextInt();
                    authors=new ArrayList<Author>();
                    for (int i=0;i<number;i++){
                        System.out.println("Enter Author id");
                        id=scanner.nextInt();
                        author= authorService.getAuthorById(id);
                        authors.add(author);
                    }

                    System.out.println("Enter number of branches");
                    number=scanner.nextInt();
                    libraryBranches =new ArrayList<LibraryBranch>();
                    for (int i=0;i<number;i++){
                        System.out.println("Enter Branch id");
                        id=scanner.nextInt();
                        libraryBranch=libraryBranchService.getLibraryBranchById(id);
                        libraryBranches.add(libraryBranch);
                    }

                    bookService.addBook(book,publisher,authors,libraryBranches);
                    break;

                case 5:
                    authors=authorService.getAuthors();
                    authors.forEach(author1 ->  System.out.println(author1.toString()));
                    break;

                case 6:
                    publishers=publisherService.getPublishers();
                    publishers.forEach(publisher1 ->  System.out.println(publisher1.toString()));
                    break;

                case 7:
                    libraryBranches=libraryBranchService.getLibraryBranches();
                    libraryBranches.forEach(libraryBranch1 ->  System.out.println(libraryBranch1.toString()));
                    break;

                case 8:
                    books=bookService.getBooks();
                    books.forEach(book1 ->  System.out.println(book1.toString()));
                    break;

                case 9:
                    System.out.println("Enter Author id to update");
                    id=scanner.nextInt();
                    System.out.println("Enter new name of Author");
                    authourName=scanner.next();
                    author= new Author(id,authourName);
                    authorService.updateAuthor(author);
                    break;

                case 10:
                    System.out.println("Enter Publisher id to update");
                    id=scanner.nextInt();
                    System.out.println("Enter new name of Publisher");
                    publisherName=scanner.next();
                    publisher=new Publisher(id,publisherName);
                    publisherService.updatePublisher(publisher);
                    break;

                case 11:
                    System.out.println("Enter Branch id to update");
                    id=scanner.nextInt();
                    System.out.println("Enter new name of LibraryBranch");
                    branchName=scanner.next();
                    libraryBranch=new LibraryBranch(id,branchName);
                    libraryBranchService.updateLibraryBranch(libraryBranch);
                    break;

                case 12:
                    System.out.println("Enter Book id to update");
                    id=scanner.nextInt();
                    book= bookService.getBookById(id);

                    System.out.println("Enter number of branches");
                    number=scanner.nextInt();
                    libraryBranches =new ArrayList<LibraryBranch>();
                    for (int i=0;i<number;i++){
                        System.out.println("Enter Branch id");
                        id=scanner.nextInt();
                        libraryBranch=libraryBranchService.getLibraryBranchById(id);
                        libraryBranches.add(libraryBranch);
                    }

                    book.setLibraryBranches(libraryBranches);
                    bookService.updateBook(book);
                    break;

                case 13:
                    System.out.println("Enter Author id to remove");
                    id=scanner.nextInt();
                    authorService.deleteAuthor(id);
                    break;

                case 14:
                    System.out.println("Enter publisher id to remove");
                    id=scanner.nextInt();
                    publisherService.deletePublisher(id);
                    break;

                case 15:
                    System.out.println("Enter branch id to remove");
                    id=scanner.nextInt();
                    libraryBranchService.deleteLibraryBranch(id);
                    break;

                case 16:
                    System.out.println("Enter Book id to remove");
                    id=scanner.nextInt();
                    bookService.deleteBook(id);
                    break;
            }
        }
    }
}
