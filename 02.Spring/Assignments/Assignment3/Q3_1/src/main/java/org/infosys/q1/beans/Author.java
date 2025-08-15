package org.infosys.q1.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = "books")
@Table(name = "author3")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authorName;

    @ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(String authorName) {
        this.authorName = authorName;
    }
    public Author(Integer id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }


}
