package com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl;


import com.Digital.Digital.Entity.Availibility.Number;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.AddressMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberMapper;
import com.Digital.Digital.Repository.AvailabilityRepository.NumberRepository;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import com.Digital.Digital.Service.AvailabilityService.NumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumberServiceImpl implements NumberService {

    private final NumberRepository numberRepository;

    private final AddressService addressService;


    public NumberServiceImpl(NumberRepository numberRepository, AddressService addressService) {
        this.numberRepository = numberRepository;
        this.addressService = addressService;
    }

    @Override
    public NumberDto saveNumber(NumberDto numberDto, Long addressId) {
        Number number = NumberMapper.INSTANCE.apply(numberDto);
        number.setAddress(AddressMapper.INSTANCE.apply( addressService.getAddressId(addressId) ));
        Number saveNumber = numberRepository.save(number);
        return NumberDtoMapper.INSTANCE.apply(number);
    }

    @Override
    public NumberDto getNumberId(Long numberId) {
        Number number = numberRepository.findById(numberId).orElse(null);
        return NumberDtoMapper.INSTANCE.apply(number);
    }

    @Override
    public List<NumberDto> getAllNumbers() {
        List<Number> numbers = numberRepository.findAll();
        return  numbers.stream().map( numberses -> NumberDtoMapper.INSTANCE.apply(numberses)).collect(Collectors.toList());
    }
}
