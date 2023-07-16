package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum AddressDtoMapper implements DtoMapper<AddressDto, Address> {
    INSTANCE;

    @Override
    public AddressDto apply(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setName(address.getName());
        return addressDto;
    }
}
