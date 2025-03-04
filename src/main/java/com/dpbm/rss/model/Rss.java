package com.dpbm.rss.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Rss {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="url", nullable = false)
    private String url;

    @Column(name="alias", nullable = false)
    private String alias;

    @Column(name="favorite", nullable = false)
    private Boolean favorite;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Publisher.class)
    @JoinColumn(name="from", referencedColumnName = "id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinTable(name="rsss_posts", joinColumns = @JoinColumn(name="rss_id"))
    private Set<Post> posts;
}
