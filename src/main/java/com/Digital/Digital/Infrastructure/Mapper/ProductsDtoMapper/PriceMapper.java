package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum PriceMapper implements DtoMapper<Price, PriceDto> {
    INSTANCE;

    @Override
    public Price apply(PriceDto priceDto) {
        Price price = new Price();
        price.setId(priceDto.getId());
        price.setPrice(priceDto.getPrice());
        price.setName(priceDto.getName());
        price.setOneTime(priceDto.getOneTime());
        price.setContractDuration(priceDto.getContractDuration());
        price.setDiscount(priceDto.getDiscount());
        return price;
    }
}
