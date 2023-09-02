package com.Digital.Digital.products;

import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Repository.ProductsRepository.PriceRepository;
import com.Digital.Digital.Service.ProductsService.TariffService;
import com.Digital.Digital.Service.ServiceImplemetations.ProductsImpl.PriceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class PriceImplTest {

    private PriceRepository priceRepository;

    private PriceImpl priceService;

    private TariffService tariffService;

    @Before
    public void setUp(){
        priceRepository = mock(PriceRepository.class);
        priceService = new PriceImpl(priceRepository, tariffService);
    }

    @Test
    public void priceGetById(){
      Long priceId = 1L;
      Price price = new Price();
      price.setId(priceId);
      price.setName("price");
      price.setOneTime(false);
      price.setContractDuration(12);
      price.setDiscount(10);
      price.setTariff(new Tariff());

      when(priceRepository.findById(priceId)).thenReturn(Optional.of(price));
        PriceDto priceDto = priceService.getPriceId(priceId);
        verify(priceRepository,times(1)).findById(priceId);
        assertThat(price.getId()).isEqualTo(priceDto.getId());
        assertThat(price.getPrice()).isEqualTo(priceDto.getPrice());
        assertThat(price.getContractDuration()).isEqualTo(priceDto.getContractDuration());
        assertThat(price.getName()).isEqualTo(priceDto.getName());
    }
}
