package com.dpbm.rss.controllers;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.PublisherNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.Publisher;
import com.dpbm.rss.model.User;
import com.dpbm.rss.service.PublisherService;
import com.dpbm.rss.service.ReturnMessage;
import com.dpbm.rss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) throws InsertWithId {
        Publisher newPublisher = publisherService.savePublisher(publisher);
        return new ResponseEntity<>(newPublisher, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable("id") String id) throws PublisherNotFound {
        Publisher foundPublisher = publisherService.getPublisher(id);
        return new ResponseEntity<>(foundPublisher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getPublishers(){
        List<Publisher> publishers = publisherService.getPublishers();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReturnMessage> deletePublisher(@PathVariable("id") String id) {
        publisherService.deletePublisher(id);
        ReturnMessage message = new ReturnMessage("Deleted Publisher");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher) throws UpdateWithoutId {
        Publisher updatedPublisher = publisherService.updatePublisher(publisher);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
    }
}
