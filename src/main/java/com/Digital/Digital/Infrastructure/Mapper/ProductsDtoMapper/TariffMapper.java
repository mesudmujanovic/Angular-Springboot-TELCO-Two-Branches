package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Intergration.DtoMapper;

import java.util.stream.Collectors;

public enum TariffMapper implements DtoMapper<Tariff, TariffDto> {
    INSTANCE;

    @Override
    public Tariff apply(TariffDto tariffDto) {
        Tariff tariff = new Tariff();
        tariff.setId(tariffDto.getId());
        tariff.setName(tariffDto.getName());
        tariff.setSpeed(tariffDto.getSpeed());
        tariff.setPriceList(tariffDto.getPriceList().stream().map(prices-> PriceMapper.INSTANCE.apply(prices)).collect(Collectors.toList()));
        return tariff;
    }
}
