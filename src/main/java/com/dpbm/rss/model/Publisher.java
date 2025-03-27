package com.dpbm.rss.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="website", nullable = false)
    private String website;

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(@Nullable String website) {
        this.website = website;
    }


}
