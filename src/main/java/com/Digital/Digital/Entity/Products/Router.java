package com.Digital.Digital.Entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Router {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String description;
    private Integer price;
}
