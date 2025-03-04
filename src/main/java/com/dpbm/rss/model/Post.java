package com.dpbm.rss.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="url", nullable = false)
    private String url;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Rss.class)
    @JoinTable(name="rsss_posts", joinColumns = @JoinColumn(name="post_id"))
    private Set<Rss> rsss;
}
