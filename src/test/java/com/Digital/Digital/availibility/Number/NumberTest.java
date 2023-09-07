package com.Digital.Digital.availibility.Number;

import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Entity.Availibility.Number;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Repository.AvailabilityRepository.NumberRepository;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import com.Digital.Digital.Service.ServiceImplemetations.AvailabilityImpl.NumberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;



public class NumberTest {

    @Mock
    private NumberRepository numberRepository;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private NumberServiceImpl numberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNumber() {

        Number number = new Number();
        number.setId(1L);
        number.setNum("1");
        number.setAddress(new Address());

        NumberDto numberDto = new NumberDto();
        numberDto.setId(1L);
        numberDto.setNum("1");
        Long addresId = 1L;
        when(numberRepository.save(any())).thenReturn(number);
        NumberDto numberDto1 = numberService.saveNumber(numberDto,addresId);

    }
}
