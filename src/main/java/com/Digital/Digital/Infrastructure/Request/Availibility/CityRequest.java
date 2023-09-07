package com.Digital.Digital.Infrastructure.Request.Availibility;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import lombok.Data;

import java.util.List;

@Data
public class CityRequest {
    private String name;

    private List<AddressDto> addressDtoList;
}
