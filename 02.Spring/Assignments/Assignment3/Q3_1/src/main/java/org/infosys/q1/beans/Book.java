package org.infosys.q1.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "book3")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer isbn;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author3")
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_branch3")
    private List<LibraryBranch> libraryBranches;

    public Book(String title) {
        this.title = title;
    }
}
