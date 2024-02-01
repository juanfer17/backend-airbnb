package com.flypass.prueba.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "rentalProperties")
@Data
public class RentalPropertiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ubication;
    private Boolean availability;
    private String imgUrl;
    private BigDecimal price;

}