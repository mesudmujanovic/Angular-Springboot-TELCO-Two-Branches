package com.Digital.Digital.Infrastructure.Response.AvailibilityResponse;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import lombok.Data;

import java.util.List;

@Data

public class CityResponse {

    private Long id;

    private String name;

    private List<AddressDto> addressDtoList;


}
