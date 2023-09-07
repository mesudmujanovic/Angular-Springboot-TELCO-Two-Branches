package com.Digital.Digital.Infrastructure.Request.Availibility;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import lombok.Data;

import java.util.List;

@Data
public class AddressRequest {

    private String name;

    private List<NumberDto> numberDtoList;
}
