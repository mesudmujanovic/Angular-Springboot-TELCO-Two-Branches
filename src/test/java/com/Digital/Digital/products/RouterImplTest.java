package com.Digital.Digital.products;
import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Repository.ProductsRepository.RouterRepository;
import com.Digital.Digital.Service.ServiceImplemetations.ProductsImpl.RouterImpl;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;
public class RouterImplTest {

    private RouterRepository routerRepository;
    private RouterImpl routerService;

    @Before
    public void setUp() {
        routerRepository = mock(RouterRepository.class);
        routerService = new RouterImpl(routerRepository);
    }

    @Test
    public void testSaveRouter() {
        RouterDto routerDto = new RouterDto();
        routerDto.setDescription("Test Router");
        routerDto.setPrice(100);

        Router router = new Router();
        router.setId(1L);
        router.setDescription("Test Router");
        router.setPrice(100);

        when(routerRepository.save(any())).thenReturn(router);
        RouterDto result = routerService.saveRouter(routerDto);
        verify(routerRepository, times(1)).save(any());
        assertThat(result.getId()).isEqualTo(router.getId());
        assertThat(result.getDescription()).isEqualTo(result.getDescription());
        assertThat(result.getPrice()).isEqualTo(router.getPrice());
    }

    @Test
    public void testGetAllRouter() {
        List<Router> routers = new ArrayList<>();
        Router router1 = new Router();
        router1.setId(1L);
        router1.setDescription("Router 1");
        router1.setPrice(100);

        Router router2 = new Router();
        router2.setId(2L);
        router2.setDescription("Router 2");
        router2.setPrice(200);

        routers.add(router1);
        routers.add(router2);
        when(routerRepository.findAll()).thenReturn(routers);
        List<RouterDto> result = routerService.getAllRouter();
        verify(routerRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals(router1.getId(), result.get(0).getId());
        assertEquals(router2.getId(), result.get(1).getId());
    }

    @Test
    public void testGetById() {
        Long routerId = 1L;
        Router router = new Router();
        router.setId(routerId);
        router.setDescription("Test Router");
        router.setPrice(100);

        when(routerRepository.findById(routerId)).thenReturn(Optional.of(router));
        RouterDto result = routerService.getById(routerId);
        verify(routerRepository, times(1)).findById(routerId);
        assertEquals(router.getId(), result.getId());
        assertEquals(router.getDescription(), result.getDescription());
        assertEquals(router.getPrice(), result.getPrice());
    }
}