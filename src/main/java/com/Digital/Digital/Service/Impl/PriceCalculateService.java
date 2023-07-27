package com.Digital.Digital.Service.Impl;

import com.Digital.Digital.Entity.PriceEntity;
import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Repository.PriceEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculateService {

    @Autowired
    private PriceEntityRepo priceEntityRepo;

    public PriceEntity savePrice(PriceEntity priceEntity) {
        int calc = priceEntity.getPrice() - priceEntity.getDiscount();
        priceEntity.setCalculatedPrice(calc);
        return priceEntityRepo.save(priceEntity);
    }
}
