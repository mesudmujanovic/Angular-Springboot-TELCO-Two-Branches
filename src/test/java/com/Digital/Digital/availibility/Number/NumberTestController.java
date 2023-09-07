package com.Digital.Digital.availibility.Number;

import com.Digital.Digital.Controllers.AvailibilityConroller.NumberController;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.NumberRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.NumberResponse;
import com.Digital.Digital.Service.AvailabilityService.NumberService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class NumberTestController {

    @InjectMocks
    NumberController numberController;

    @Mock
    NumberService numberService;

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    }

   @Test
    public  void testSaveNumber(){
        Long addresId = 1L;
        NumberRequest numberRequest = new NumberRequest();
        numberRequest.setNum("22");

       NumberDto numberDto = new NumberDto();
       numberDto.setNum("22");
       numberDto.setId(1L);

       when(numberService.saveNumber(numberDto, addresId)).thenReturn(numberDto);
       ResponseEntity<NumberResponse> numberResponseResponseEntity = numberController.saveNumber(numberRequest, addresId);
       NumberResponse numberResponse = numberResponseResponseEntity.getBody();
       assertThat(numberResponse.getId()).isEqualTo(numberDto.getId());
       assertThat(numberResponse.getNum()).isEqualTo(numberDto.getNum());
       verify(numberService, Mockito.times(1)).saveNumber(numberDto,addresId);
   }

}
