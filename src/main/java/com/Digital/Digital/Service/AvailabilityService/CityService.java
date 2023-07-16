package com.Digital.Digital.Service.AvailabilityService;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;

import java.util.List;

public interface CityService {

    CityDto createCity( CityDto cityDto );

    CityDto getCityId( Long cityId );

    List<CityDto> getAllCity();
}
