package org.infosys.q1.service;

import org.infosys.q1.beans.Publisher;

import java.util.List;

public interface PublisherServiceInterface {
    public void addPublisher(Publisher publisher);
    public List<Publisher> getPublishers();
    public Publisher getPublisherById(Integer id);
    public void updatePublisher(Publisher publisher);
    public void deletePublisher(Integer id);
}
