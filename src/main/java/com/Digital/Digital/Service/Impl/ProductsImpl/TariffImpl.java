package com.Digital.Digital.Service.Impl.ProductsImpl;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffMapper;
import com.Digital.Digital.Repository.ProductsRepository.TariffRepository;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffImpl implements TariffService {

    @Autowired
    private TariffRepository priceRepository;

    @Override
    public TariffDto savePrice(TariffDto tariffDto) {
       Tariff tariff = TariffMapper.INSTANCE.apply(tariffDto);
       Tariff saveTariff = priceRepository.save(tariff);
       return TariffDtoMapper.INSTANCE.apply(saveTariff);
    }
}
