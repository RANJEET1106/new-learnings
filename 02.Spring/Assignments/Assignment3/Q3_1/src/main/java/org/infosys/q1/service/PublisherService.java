package org.infosys.q1.service;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.beans.Publisher;
import org.infosys.q1.repo.BookRepo;
import org.infosys.q1.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceInterface{
    @Autowired
    PublisherRepo publisherRepo;
    @Autowired
    BookRepo bookRepo;

    @Override
    public void addPublisher(Publisher publisher) {
        publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher getPublisherById(Integer id) {
        return publisherRepo.findById(id).get();
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        int id = publisher.getId();
        Optional<Publisher> optional = publisherRepo.findById(id);
        if(optional.isPresent()){
            publisherRepo.save(publisher);
        }
        else {
            System.out.println("publisher not found");
        }
    }

    @Override
    public void deletePublisher(Integer id) {
        publisherRepo.deleteById(id);
    }
}
