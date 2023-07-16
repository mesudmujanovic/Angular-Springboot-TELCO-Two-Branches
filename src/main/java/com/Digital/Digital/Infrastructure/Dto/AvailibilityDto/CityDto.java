package com.Digital.Digital.Infrastructure.Dto.AvailibilityDto;


import com.Digital.Digital.Infrastructure.Request.Availibility.CityRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.CityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;

    public CityResponse dtoToResponse(CityDto cityDto) {
        CityResponse cityResponse = new CityResponse();
        cityResponse.setId(cityDto.getId());
        cityResponse.setName(cityDto.getName());
        return cityResponse;
    }

    public static CityDto requestToDto(CityRequest cityRequest){
        CityDto cityDto = new CityDto();
        cityDto.setName(cityRequest.getName());
        return cityDto;
    }




}
