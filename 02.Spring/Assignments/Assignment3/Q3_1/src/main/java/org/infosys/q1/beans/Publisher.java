package org.infosys.q1.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = "books")
@Table(name="publisher3")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String publisherName;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    public Publisher(Integer id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }
}
