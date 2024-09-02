package com.example.chacasanova.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import jakarta.persistence.Column;

@Entity
@Table(name = "gift")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name="img_link", nullable = false, length = 1000)
    private String imgLink;

    @Column(name="title", length = 255)
    private String title;

    @Column(name="description", length = 500)
    private String description;

    @Column(name="example_link", nullable = false, length = 1000)
    private String exampleLink;

    @Column(name="presenter", length = 255)
    private String presenter;

    @Column(name="phone", unique = true, length=255)
    private String phone;

    
}
