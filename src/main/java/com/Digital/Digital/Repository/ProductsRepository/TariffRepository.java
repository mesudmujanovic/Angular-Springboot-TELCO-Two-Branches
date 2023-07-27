package com.Digital.Digital.Repository.ProductsRepository;

import com.Digital.Digital.Entity.Products.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {

    public Tariff findByName (String name);
}
