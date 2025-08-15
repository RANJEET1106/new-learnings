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
@Table(name="library_branch3")
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String branchName;

    @ManyToMany(mappedBy ="libraryBranches", fetch = FetchType.EAGER)
    private List<Book> books;

    public LibraryBranch(String branchName) {
        this.branchName = branchName;
    }

    public LibraryBranch(Integer id, String branchName) {
        this.id = id;
        this.branchName = branchName;
    }
}
