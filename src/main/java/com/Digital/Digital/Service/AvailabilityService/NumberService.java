package com.Digital.Digital.Service.AvailabilityService;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;

import java.util.List;

public interface NumberService {

    NumberDto saveNumber( NumberDto numberDto, Long addressId );

    NumberDto getNumberId( Long numberId );

    List<NumberDto> getAllNumbers();
}
