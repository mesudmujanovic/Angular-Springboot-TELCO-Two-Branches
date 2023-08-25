package com.Digital.Digital.Entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany( mappedBy = "tariff", fetch = FetchType.LAZY)
    private List<Price> priceList;

}
