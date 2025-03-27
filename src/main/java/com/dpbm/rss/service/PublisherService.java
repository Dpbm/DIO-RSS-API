package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.PublisherNotFound;
import com.dpbm.rss.exceptions.RssNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.model.Publisher;
import com.dpbm.rss.model.Rss;

import java.util.List;
import java.util.Set;


public interface PublisherService {

        Publisher savePublisher(Publisher publisher)  throws InsertWithId;
        Publisher getPublisher(String id) throws PublisherNotFound;
        List<Publisher> getPublishers();
        void deletePublisher(String id);
        Publisher updatePublisher(Publisher publisher)  throws UpdateWithoutId;

        Rss addRss(String id, Rss rss) throws UpdateWithoutId,PublisherNotFound;
        void deleteRss(String id);
        List<Rss> getRSSs(String publisherID);
        Rss getRss(String id) throws RssNotFound;
        Rss updateRss(Rss rss) throws UpdateWithoutId;
}
