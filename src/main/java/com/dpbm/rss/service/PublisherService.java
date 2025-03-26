package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.PublisherNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.model.Publisher;

import java.util.List;


public interface PublisherService {

        Publisher savePublisher(Publisher publisher)  throws InsertWithId;
        Publisher getPublisher(String id) throws PublisherNotFound;
        List<Publisher> getPublishers();
        void deletePublisher(String id);
        Publisher updatePublisher(Publisher publisher)  throws UpdateWithoutId;


}
