package com.Digital.Digital.Service.ProductsService;

import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;

public interface PriceService {

    public PriceDto savePrice( PriceDto priceDto, String name );

    public PriceDto getPriceId( Long priceId );

}
