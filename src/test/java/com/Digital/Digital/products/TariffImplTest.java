package com.Digital.Digital.products;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Repository.ProductsRepository.TariffRepository;
import com.Digital.Digital.Service.ServiceImplemetations.ProductsImpl.TariffImpl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TariffImplTest {

    private TariffRepository tariffRepository;

    private TariffImpl tariffImpl;

    @Before
    public  void setUp(){
        tariffRepository = mock(TariffRepository.class);
        tariffImpl = new TariffImpl(tariffRepository);
    };

    @Test
    public  void testSaveTariff(){

        TariffDto tariffDto = new TariffDto();
        tariffDto.setName("Tariff");
        tariffDto.setPriceList(new ArrayList<>());
        tariffDto.setSpeed("222");

        Tariff tariff = new Tariff();
        tariff.setId(1L);
        tariff.setPriceList(new ArrayList<>());
        tariff.setName("Tariff");
        tariff.setSpeed("222");

   when(tariffRepository.save(any())).thenReturn(tariff);
   TariffDto tariffDto1 = tariffImpl.savePrice(tariffDto);
   verify(tariffRepository, times(1)).save(any());
   assertThat(tariffDto1.getId()).isEqualTo(tariffDto1.getId());
    }
}
