package com.Digital.Digital.products.Router;

import com.Digital.Digital.Controllers.ProductsController.RouterController;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.RouterRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.RouterResponse;
import com.Digital.Digital.Service.ProductsService.RouterService;
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

public class RouterControllerTest {

     @InjectMocks
    private RouterController routerController;

     @Mock
    private RouterService routerService;

     @Before
    public void setUp(){
         MockitoAnnotations.initMocks(this);
     }

    @Test
    public void testSaveRouter() {
        RouterRequest routerRequest = new RouterRequest();
        routerRequest.setDescription("Test Router");
        routerRequest.setPrice(100);

        RouterDto routerDto = new RouterDto();
        routerDto.setId(1L);
        routerDto.setDescription("Test Router");
        routerDto.setPrice(100);

        when(routerService.saveRouter(any())).thenReturn(routerDto);
        ResponseEntity<RouterResponse> responseEntity = routerController.saveRouters(routerRequest);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getId()).isEqualTo(routerDto.getId());
        assertThat(responseEntity.getBody().getDescription()).isEqualTo(routerDto.getDescription());
        assertThat(responseEntity.getBody().getPrice()).isEqualTo(routerDto.getPrice());

        verify(routerService, times(1)).saveRouter(any());
    }

    @Test
    public  void testGetAllRouters(){
        List<RouterDto> routerDtos = Arrays.asList(
                new RouterDto(1L, "Router 1", 100),
                new RouterDto(2L, "Router 2", 200)
        );

        when(routerService.getAllRouter()).thenReturn(routerDtos);
        ResponseEntity<List<RouterResponse>> responseEntity = routerController.getAllRouter();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        List<RouterResponse> routerResponses = responseEntity.getBody();
        assertThat(routerResponses).isNotNull();
        assertThat(routerResponses.size()).isEqualTo(2);

        RouterResponse routerResponse1 = routerResponses.get(0);
        assertThat(routerResponse1.getId()).isEqualTo(1L);
        assertThat(routerResponse1.getDescription()).isEqualTo("Router 1");
        assertThat(routerResponse1.getPrice()).isEqualTo(100);

        RouterResponse routerResponse2 = routerResponses.get(1);
        assertThat(routerResponse2.getId()).isEqualTo(2L);
        assertThat(routerResponse2.getDescription()).isEqualTo("Router 2");
        assertThat(routerResponse2.getPrice()).isEqualTo(200);

        verify(routerService, times(1)).getAllRouter();

    }

}
