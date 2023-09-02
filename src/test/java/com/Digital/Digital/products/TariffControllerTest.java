package com.Digital.Digital.products;
import com.Digital.Digital.Controllers.ProductsController.TariffController;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import com.Digital.Digital.Service.ProductsService.TariffService;
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
public class TariffControllerTest {
    @InjectMocks
    private TariffController tariffController;

    @Mock
    private TariffService tariffService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testSaveTariff() {
        List<PriceDto> priceList = Arrays.asList(
                new PriceDto(1L, "100", 12, false, "price100", 10, 1L),
                new PriceDto(2L, "200", 0, true, "price200", 20, 2L)
        );

        TariffRequest tariffRequest = new TariffRequest();
        tariffRequest.setName("Tariff 1");
        tariffRequest.setSpeed("100 Mbps");
        tariffRequest.setPriceList(priceList);

        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(1L);
        tariffDto.setName("Tariff 1");
        tariffDto.setSpeed("100 Mbps");
        tariffDto.setPriceList(priceList);

        when(tariffService.saveTariff(any())).thenReturn(tariffDto);

        ResponseEntity<TariffResponse> responseEntity = tariffController.saveTariff(tariffRequest);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        TariffResponse tariffResponse = responseEntity.getBody();
        assertThat(tariffResponse).isNotNull();
        assertThat(tariffResponse.getId()).isEqualTo(1L);
        assertThat(tariffResponse.getName()).isEqualTo("Tariff 1");
        assertThat(tariffResponse.getSpeed()).isEqualTo("100 Mbps");
        assertThat(tariffResponse.getPriceList()).isEqualTo(priceList);
        verify(tariffService, times(1)).saveTariff(any());
    }
}
