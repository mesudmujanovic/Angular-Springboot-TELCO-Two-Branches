package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Intergration.DtoMapper;

import java.util.stream.Collectors;

public enum TariffDtoMapper implements DtoMapper<TariffDto, Tariff> {
    INSTANCE;

    @Override
    public TariffDto apply(Tariff tariff) {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(tariff.getId());
        tariffDto.setName(tariff.getName());
        tariffDto.setSpeed(tariff.getSpeed());
        tariffDto.setPriceList(tariff.getPriceList().stream().map(prices -> PriceDtoMapper.INSTANCE.apply(prices)).collect(Collectors.toList()));
        return tariffDto;
    }
}
