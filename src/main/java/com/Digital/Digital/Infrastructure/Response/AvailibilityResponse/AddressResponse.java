package com.Digital.Digital.Infrastructure.Response.AvailibilityResponse;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import lombok.Data;

import java.util.List;

@Data
public class AddressResponse {

    private Long id;

    private String name;

    private List<NumberDto> numberDtoList;

}
