package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Intergration.DtoMapper;

import java.util.stream.Collectors;

public enum CityDtoMapper implements DtoMapper<CityDto, City> {
    INSTANCE;

    @Override
    public CityDto apply(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setAddressDtoList(city.getAddressList().stream().map( adresses -> AddressDtoMapper.INSTANCE.apply(adresses)).collect(Collectors.toList()));
        return cityDto;
    }
}
