package com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl;


import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.CityDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper.CityMapper;
import com.Digital.Digital.Repository.AvailabilityRepository.CityRepository;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CityDto getCityId(Long cityId) {
        City city = cityRepository.findById(cityId).orElse(null);
        return CityDtoMapper.INSTANCE.apply(city);
    }

    @Override
    public List<CityDto> getAllCity() {
        List<City> cityList = cityRepository.findAll();
        return cityList.stream().map( citys -> CityDtoMapper.INSTANCE.apply(citys) ).collect(Collectors.toList());
    }
}
