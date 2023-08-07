package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum PriceDtoMapper implements DtoMapper<PriceDto, Price> {
    INSTANCE;

    @Override
    public PriceDto apply(Price price) {
        PriceDto priceDto = new PriceDto();
        priceDto.setId(price.getId());
        priceDto.setName(price.getName());
        priceDto.setPrice(price.getPrice());
        priceDto.setOneTime(price.getOneTime());
        priceDto.setContractDuration(price.getContractDuration());
        priceDto.setDiscount(price.getDiscount());
        priceDto.setTariffId(price.getTariff().getId());
        return priceDto;
    }
}
