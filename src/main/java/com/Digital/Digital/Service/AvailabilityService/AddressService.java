package com.Digital.Digital.Service.AvailabilityService;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto saveAddress( AddressDto addressDto, Long cityId );

    AddressDto getAddressId( Long addressId );

    List<AddressDto> getAllAddress();
}
