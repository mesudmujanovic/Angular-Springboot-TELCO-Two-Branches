package com.Digital.Digital.Infrastructure.Dto.AvailibilityDto;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberMapper;
import com.Digital.Digital.Infrastructure.Request.Availibility.AddressRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String name;

    private List<NumberDto> numberDtoList;



    public static AddressDto addressRequestToDto(AddressRequest addressRequest){
        AddressDto addressDto = new AddressDto();
        addressDto.setName(addressRequest.getName());
        addressDto.setNumberDtoList(addressRequest.getNumberDtoList().stream().map( numbers -> NumberDtoMapper.INSTANCE.apply(NumberMapper.INSTANCE.apply(numbers))).collect(Collectors.toList()));
        return addressDto;
    }

    public static AddressResponse dtoToResponse( AddressDto addressDto ) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressDto.getId());
        addressResponse.setName(addressDto.getName());
        addressResponse.setNumberDtoList(addressDto.getNumberDtoList());
        return addressResponse;
    }

}
