package com.Digital.Digital.Repository.ProductsRepository;

import com.Digital.Digital.Entity.Products.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
