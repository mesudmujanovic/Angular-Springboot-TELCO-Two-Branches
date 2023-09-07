package com.Digital.Digital.availibility.City;

import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Repository.AvailabilityRepository.CityRepository;
import com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl.CityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;


public class CityTest {

    private CityRepository cityRepository;

    private CityServiceImpl cityService;

    @Before
    public  void setUp(){
        cityRepository = mock(CityRepository.class);
        cityService = new CityServiceImpl(cityRepository);
    }

    @Test
    public void saveCity(){
        CityDto cityDto = new CityDto();
        cityDto.setId(1L);
        cityDto.setName("Novi Pazar");
        cityDto.setAddressDtoList(new ArrayList<>());

        City city = new City();
        city.setId(1l);
        city.setName("Novi Pazar");
        city.setAddressList(new ArrayList<>());

        when(cityRepository.save(any())).thenReturn(city);
        CityDto cityDto1 = cityService.createCity(cityDto);
        assertThat(cityDto1.getId()).isEqualTo(city.getId());
        assertThat(cityDto1.getName()).isEqualTo(city.getName());
        assertThat(cityDto1.getAddressDtoList()).isEqualTo(city.getAddressList());
    }

    @Test
    public  void getAllRoutersTest(){
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setId(1L);
        city.setName("Novi Pazar");
        city.setAddressList(new ArrayList<>());

        City city1 = new City();
        city1.setId(2L);
        city1.setName("Sarajevo");
        city1.setAddressList(new ArrayList<>());

        cityList.add(city);
        cityList.add(city1);

        when(cityRepository.findAll()).thenReturn(cityList);
        List<CityDto> cityDtos = cityService.getAllCity();
        verify(cityRepository, times(1)).findAll();
        assertEquals(2, cityDtos.size());
        assertEquals(city.getId(), cityDtos.get(0).getId());
        assertEquals(city1.getId(),  cityDtos.get(1).getId());
    }

    @Test
    public void testGetById() {
        Long cityId = 1L;
        City city = new City();
        city.setId(cityId);
        city.setName("NoviPazar");
        city.setAddressList(new ArrayList<>());

        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));
        CityDto cityDto = cityService.getCityId(cityId);
        verify(cityRepository, times(1)).findById(cityId);
        assertThat(city.getId()).isEqualTo(cityDto.getId());
        assertThat(city.getName()).isEqualTo(cityDto.getName());
        assertThat(city.getAddressList()).isEqualTo(cityDto.getAddressDtoList());
    }

}
