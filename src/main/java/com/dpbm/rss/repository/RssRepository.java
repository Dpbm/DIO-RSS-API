package com.dpbm.rss.repository;

import com.dpbm.rss.model.Rss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RssRepository extends CrudRepository<Rss, String> {

    List<Rss> findAllByPublisherId(String publisherId);

}
