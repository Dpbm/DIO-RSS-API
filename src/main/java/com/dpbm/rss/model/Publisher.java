package com.dpbm.rss.model;

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

    @Nullable
    private String website;
}
