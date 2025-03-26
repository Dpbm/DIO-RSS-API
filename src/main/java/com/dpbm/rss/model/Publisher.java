package com.dpbm.rss.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Nullable
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
