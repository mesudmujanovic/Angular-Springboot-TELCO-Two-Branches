package com.Digital.Digital.availibility.Address;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Entity.Availibility.City;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Repository.AvailabilityRepository.AddressRepository;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl.AddressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressTest {

    private AddressServiceImpl addressService;
    private AddressRepository addressRepository;
    private CityService cityService;
    @Before
    public void setUp() {
        cityService = mock(CityService.class);
        addressRepository = mock(AddressRepository.class);
        addressService = new AddressServiceImpl(addressRepository, cityService);
    }

    @Test
    public void saveAddress(){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(1L);
        addressDto.setName("address");
        addressDto.setNumberDtoList(new ArrayList<>());

        Address address = new Address();
        address.setId(address.getId());
        address.setName("address");
        address.setNumbers(new ArrayList<>());

        City city = new City();
        city.setId(1L);
        Long cityId = city.getId();
        when(addressRepository.save(any())).thenReturn(address);
        AddressDto addressDto1 = addressService.saveAddress(addressDto, cityId);
        assertThat(addressDto1.getId()).isEqualTo(address.getId());
        assertThat(addressDto1.getName()).isEqualTo(address.getName());
        assertThat(addressDto1.getNumberDtoList()).isEqualTo(address.getNumbers());
    }
}
