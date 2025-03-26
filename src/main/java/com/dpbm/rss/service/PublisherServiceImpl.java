package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.PublisherNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.model.Publisher;
import com.dpbm.rss.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class PublisherServiceImpl implements PublisherService{
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher savePublisher(Publisher publisher) throws  InsertWithId{
        if(publisher.getId() != null){
            throw new InsertWithId();
        }

        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisher(String id) throws PublisherNotFound {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if(publisher.isEmpty()){
            throw new PublisherNotFound();
        }

        return publisher.get();
    }

    @Override
    public List<Publisher> getPublishers() {
        Iterable<Publisher> publishersIter = publisherRepository.findAll();
        return StreamSupport.stream(publishersIter.spliterator(), false).toList();
    }


    @Override
    public void deletePublisher(String id){
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) throws UpdateWithoutId{
        if(publisher.getId() == null || publisher.getId().isEmpty()){
            throw new UpdateWithoutId();
        }
        return publisherRepository.save(publisher);
    }
}
