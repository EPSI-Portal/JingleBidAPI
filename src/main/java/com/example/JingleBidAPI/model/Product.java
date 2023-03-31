package com.example.JingleBidAPI.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column(name="_condition")
    private String condition;

    @Column(name = "image")
    private String image;

    @Column(name = "shortDesc")
    private String shortDesc;
    @Column(name = "longDesc")
    private String longDesc;
    @Column(name = "price")
    private float price;
    @Column(name = "createdAt")
    private String createdAt;

}
