package org.infosys.q1.service;

import org.infosys.q1.beans.LibraryBranch;

import java.util.List;

public interface LibraryBranchServiceInterface {
    public void  addLibraryBranch(LibraryBranch libraryBranch);
    public List<LibraryBranch> getLibraryBranches();
    public LibraryBranch getLibraryBranchById(Integer id);
    public void  updateLibraryBranch(LibraryBranch libraryBranch);
    public void deleteLibraryBranch(Integer id);
}
