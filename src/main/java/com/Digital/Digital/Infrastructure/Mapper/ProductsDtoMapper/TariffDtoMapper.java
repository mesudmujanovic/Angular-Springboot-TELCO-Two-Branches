package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Intergration.DtoMapper;

import java.util.stream.Collectors;

public enum TariffDtoMapper implements DtoMapper<TariffDto, Tariff> {
    INSTANCE;

    @Override
    public TariffDto apply(Tariff price) {
        TariffDto priceDto = new TariffDto();
        priceDto.setId(price.getId());
        priceDto.setName(price.getName());
        priceDto.setSpeed(price.getSpeed());
        priceDto.setPriceList(price.getPriceList().stream().map(prices -> PriceDtoMapper.INSTANCE.apply(prices)).collect(Collectors.toList()));
        return priceDto;
    }
}
