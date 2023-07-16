package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum AddressMapper implements DtoMapper<Address, AddressDto> {
    INSTANCE;
    @Override
    public Address apply(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setName(addressDto.getName());
        return address;
    }
}
