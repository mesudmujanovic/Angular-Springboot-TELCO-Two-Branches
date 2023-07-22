package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum TariffDtoMapper implements DtoMapper<TariffDto, Tariff> {
    INSTANCE;

    @Override
    public TariffDto apply(Tariff price) {
        TariffDto priceDto = new TariffDto();
        priceDto.setId(price.getId());
        priceDto.setName(price.getName());
        priceDto.setSpeed(price.getSpeed());
        return priceDto;
    }
}
