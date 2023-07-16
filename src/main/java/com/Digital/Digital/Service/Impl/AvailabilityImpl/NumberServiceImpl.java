package com.Digital.Digital.Service.Impl.AvailabilityImpl;


import com.Digital.Digital.Entity.Availibility.Number;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.NumberMapper;
import com.Digital.Digital.Repository.AvailabilityRepository.NumberRepository;
import com.Digital.Digital.Service.AvailabilityService.NumberService;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

    private final NumberRepository numberRepository;


    public NumberServiceImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public NumberDto saveNumber(NumberDto numberDto) {
        Number number = NumberMapper.INSTANCE.apply(numberDto);
        Number saveNumber = numberRepository.save(number);
        return NumberDtoMapper.INSTANCE.apply(number);
    }
}
