package org.infosys.q1.service;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.beans.LibraryBranch;
import org.infosys.q1.repo.BookRepo;
import org.infosys.q1.repo.LibraryBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryBranchService implements LibraryBranchServiceInterface{
    @Autowired
    private LibraryBranchRepo libraryBranchRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void addLibraryBranch(LibraryBranch libraryBranch) {
        libraryBranchRepo.save(libraryBranch);
    }

    @Override
    public List<LibraryBranch> getLibraryBranches() {
        return libraryBranchRepo.findAll();
    }

    @Override
    public LibraryBranch getLibraryBranchById(Integer id) {
        return libraryBranchRepo.findById(id).get();
    }

    @Override
    public void updateLibraryBranch(LibraryBranch libraryBranch) {
        int id = libraryBranchRepo.save(libraryBranch).getId();
        Optional<LibraryBranch> libraryBranchOptional = libraryBranchRepo.findById(id);
        if(libraryBranchOptional.isPresent()){
            libraryBranchRepo.save(libraryBranch);
        }
        else {
            System.out.println("LibraryBranch not found");
        }
    }

    @Override
    public void deleteLibraryBranch(Integer id) {
        Optional<LibraryBranch> optionalLibraryBranch=libraryBranchRepo.findById(id);
        if (optionalLibraryBranch.isEmpty()) {
            System.out.println("Library Branch not found with id: " + id);
            return;
        }
        LibraryBranch libraryBranch=optionalLibraryBranch.get();
        List<Book> books=libraryBranch.getBooks();
        for(Book book:books){
            book.getLibraryBranches().remove(libraryBranch);
            bookRepo.save(book);
        }
        libraryBranchRepo.deleteById(id);
    }
}
