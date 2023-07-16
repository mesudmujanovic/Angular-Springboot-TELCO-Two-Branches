package com.Digital.Digital.Service.Impl.AvailabilityImpl;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.AddressDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.AddressMapper;
import com.Digital.Digital.Repository.AvailabilityRepository.AddressRepository;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final  AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto saveAddress(AddressDto addressDto) {
        Address address = AddressMapper.INSTANCE.apply(addressDto);
        Address saveAddress = addressRepository.save(address);
        return AddressDtoMapper.INSTANCE.apply(saveAddress);
    }
}
