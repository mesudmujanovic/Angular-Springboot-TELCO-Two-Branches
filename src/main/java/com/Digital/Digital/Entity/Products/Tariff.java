package com.Digital.Digital.Entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Tariff {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String speed;

}
