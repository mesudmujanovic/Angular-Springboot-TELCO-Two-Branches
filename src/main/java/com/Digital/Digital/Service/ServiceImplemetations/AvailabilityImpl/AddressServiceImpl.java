package com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.*;
import com.Digital.Digital.Repository.AvailabilityRepository.AddressRepository;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;


    @Autowired
    private CityService cityService;


    @Override
    public AddressDto saveAddress(AddressDto addressDto, Long cityId) {
        Address address = AddressMapper.INSTANCE.apply(addressDto);
        address.setCity(CityMapper.INSTANCE.apply( cityService.getCityId(cityId) ));
        Address saveAddress = addressRepository.save(address);
        return AddressDtoMapper.INSTANCE.apply(saveAddress);
    }

    @Override
    public AddressDto getAddressId(Long addressId) {
        Address address = addressRepository.findById(addressId).orElse(null);
        return AddressDtoMapper.INSTANCE.apply(address);

    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map( addresses -> AddressDtoMapper.INSTANCE.apply(addresses) ).collect(Collectors.toList());
    }


}
