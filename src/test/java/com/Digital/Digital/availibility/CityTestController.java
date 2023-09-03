package com.Digital.Digital.availibility;

import com.Digital.Digital.Controllers.AvailibilityConroller.CityController;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.CityRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.CityResponse;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CityTestController {

    @InjectMocks
     CityController cityController;

    @Mock
    public CityService cityService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCity(){

        List<NumberDto> numberDtoList = Arrays.asList(
                new NumberDto(1L, "1"));

        List<AddressDto> addressDtoList = Arrays.asList(
                new AddressDto(1L, "Address", numberDtoList  )
        );

        CityRequest cityRequest = new CityRequest();
        cityRequest.setName("city");
        cityRequest.setAddressDtoList(addressDtoList);

        CityDto cityDto = new CityDto();
        cityDto.setId(1L);
        cityDto.setName("city");
        cityDto.setAddressDtoList(addressDtoList);

        when(cityService.createCity(any())).thenReturn(cityDto);
        ResponseEntity<CityResponse> cityResponseRE = cityController.saveCity(cityRequest);
        CityResponse cityResponse = cityResponseRE.getBody();
        assertThat(cityResponse).isNotNull();
        assertThat(cityResponse.getId()).isEqualTo(cityDto.getId());
        assertThat(cityResponse.getName()).isEqualTo(cityDto.getName());
        assertThat(cityResponse.getAddressDtoList()).isEqualTo(cityDto.getAddressDtoList());
        verify(cityService, times(1)).createCity(any());
    }
}
