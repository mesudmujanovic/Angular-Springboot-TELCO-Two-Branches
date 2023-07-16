package com.Digital.Digital.Service.Impl.AvailabilityImpl;


import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.CityDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.CityMapper;
import com.Digital.Digital.Repository.AvailabilityRepository.CityRepository;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public CityDto createCity(CityDto cityDto) {
        City city = CityMapper.INSTANCE.apply(cityDto);
        City saveCity = cityRepository.save(city);
        return CityDtoMapper.INSTANCE.apply(saveCity);
    }
}
