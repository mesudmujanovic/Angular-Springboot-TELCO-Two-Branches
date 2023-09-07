package com.Digital.Digital.Infrastructure.Dto.AvailibilityDto;


import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.AddressDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.AddressMapper;
import com.Digital.Digital.Infrastructure.Request.Availibility.CityRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.CityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private List<AddressDto> addressDtoList;


    public static CityDto requestToDto(CityRequest cityRequest){
        CityDto cityDto = new CityDto();
        cityDto.setName(cityRequest.getName());
        cityDto.setAddressDtoList(cityRequest.getAddressDtoList().stream().map( addresses -> AddressDtoMapper.INSTANCE.apply(AddressMapper.INSTANCE.apply(addresses))).collect(Collectors.toList()));
        return cityDto;
    }

    public CityResponse dtoToResponse(CityDto cityDto) {
        CityResponse cityResponse = new CityResponse();
        cityResponse.setId(cityDto.getId());
        cityResponse.setName(cityDto.getName());
        cityResponse.setAddressDtoList(cityDto.getAddressDtoList());
        return cityResponse;
    }


}
