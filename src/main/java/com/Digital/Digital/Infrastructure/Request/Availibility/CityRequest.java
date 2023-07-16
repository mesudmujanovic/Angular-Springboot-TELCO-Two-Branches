package com.Digital.Digital.Infrastructure.Request.Availibility;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import lombok.Data;

import java.util.List;

@Data
public class CityRequest {
    private String name;

    private List<AddressDto> addressDtoList;
}
