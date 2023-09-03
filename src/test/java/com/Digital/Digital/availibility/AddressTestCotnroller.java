package com.Digital.Digital.availibility;

import com.Digital.Digital.Controllers.AvailibilityConroller.AddressController;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.AddressRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.AddressResponse;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class AddressTestCotnroller {

    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    };

    @Test
    public  void testSaveAddress(){
        Long cityId = 1L;
        List<NumberDto> listNumber = Arrays.asList(
                new NumberDto( 1L,"21" ),
                new NumberDto(2L, "22")
        );

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setId(1L);
        addressRequest.setName("address");
        addressRequest.setNumberDtoList(listNumber);

        AddressDto addressDto = new AddressDto();
        addressDto.setId(1L);
        addressDto.setName("address");
        addressDto.setNumberDtoList(listNumber);

        when(addressService.saveAddress(addressDto,cityId)).thenReturn(addressDto);
        ResponseEntity<AddressResponse> addressResponseRE = addressController.saveAddress(addressRequest,cityId);
        AddressResponse addressResponse = addressResponseRE.getBody();

        assertThat(addressResponse).isNotNull();
        assertThat(addressResponse.getId()).isEqualTo(addressDto.getId());
        assertThat(addressResponse.getName()).isEqualTo(addressDto.getName());
        assertThat(addressResponse.getNumberDtoList()).isEqualTo(addressDto.getNumberDtoList());
    };
}
