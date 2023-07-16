package com.Digital.Digital.Infrastructure.Dto.AvailibilityDto;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Request.Availibility.AddressRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.AddressResponse;
import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    private String name;

    public static AddressDto addressRequestToDto(AddressRequest addressRequest){
        AddressDto addressDto = new AddressDto();
        addressDto.setName(addressRequest.getName());
        return addressDto;
    }

    public static AddressResponse dtoToResponse( AddressDto addressDto ) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressDto.getId());
        addressResponse.setName(addressDto.getName());
        return addressResponse;
    }

}
