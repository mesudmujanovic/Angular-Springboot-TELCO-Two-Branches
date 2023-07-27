package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Intergration.DtoMapper;

import java.util.stream.Collectors;

public enum TariffMapper implements DtoMapper<Tariff, TariffDto> {
    INSTANCE;

    @Override
    public Tariff apply(TariffDto priceDto) {
        Tariff price = new Tariff();
        price.setId(priceDto.getId());
        price.setName(priceDto.getName());
        price.setSpeed(priceDto.getSpeed());
        price.setPriceList(priceDto.getPriceList().stream().map(prices-> PriceMapper.INSTANCE.apply(prices)).collect(Collectors.toList()));
        return price;
    }
}
