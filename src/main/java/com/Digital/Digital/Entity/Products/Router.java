package com.Digital.Digital.Entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
