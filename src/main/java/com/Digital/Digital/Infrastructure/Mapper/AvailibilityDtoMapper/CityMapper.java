package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum CityMapper implements DtoMapper<City, CityDto> {
    INSTANCE;

    @Override
    public City  apply(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        return city;
    }
}
