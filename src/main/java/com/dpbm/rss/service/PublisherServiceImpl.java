package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.PublisherNotFound;
import com.dpbm.rss.exceptions.RssNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.model.Publisher;
import com.dpbm.rss.model.Rss;
import com.dpbm.rss.repository.PublisherRepository;
import com.dpbm.rss.repository.RssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private RssRepository rssRepository;

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



    @Override
    public Rss addRss(String publisherID, Rss rss) throws UpdateWithoutId,PublisherNotFound{
        if(publisherID == null){
            throw new UpdateWithoutId();
        }

        Optional<Publisher> publisher = publisherRepository.findById(publisherID);

        if(publisher.isEmpty()){
            throw new PublisherNotFound();
        }

        rss.setPublisher(publisher.get());

        return rssRepository.save(rss);
    }

    @Override
    public void deleteRss(String id){
        rssRepository.deleteById(id);
    }

    @Override
    public List<Rss> getRSSs(String publisherID){
        return rssRepository.findAllByPublisherId(publisherID);
    }

    @Override
    public Rss getRss(String id) throws RssNotFound{
        Optional<Rss> rss = rssRepository.findById(id);

        if(rss.isEmpty()){
            throw new RssNotFound();
        }

        return rss.get();
    }

    @Override
    public Rss updateRss(Rss rss) throws UpdateWithoutId{
        if(rss.getId() == null){
            throw  new UpdateWithoutId();
        }

        return rssRepository.save(rss);
    }
}
