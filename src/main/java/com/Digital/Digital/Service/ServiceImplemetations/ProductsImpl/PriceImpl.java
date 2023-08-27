package com.Digital.Digital.Service.ServiceImplemetations.ProductsImpl;

import com.Digital.Digital.Entity.Products.Price;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.PriceDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.PriceMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffMapper;
import com.Digital.Digital.Repository.ProductsRepository.PriceRepository;
import com.Digital.Digital.Service.ProductsService.PriceService;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceImpl implements PriceService {


    private PriceRepository priceRepository;

    private TariffService tariffService;


    public PriceImpl(PriceRepository priceRepository, TariffService tariffService) {
        this.priceRepository = priceRepository;
        this.tariffService = tariffService;
    }





    @Override
    public PriceDto savePrice(PriceDto priceDto, String name) {
        Price price = PriceMapper.INSTANCE.apply(priceDto);
        price.setTariff(TariffMapper.INSTANCE.apply(tariffService.getByName(name)));
        Price savePrice = priceRepository.save(price);
        return PriceDtoMapper.INSTANCE.apply(savePrice);
    }


    @Override
    public PriceDto getPriceId(Long priceId) {
        Price price = priceRepository.findById(priceId).orElse(null);
        return PriceDtoMapper.INSTANCE.apply(price);
    }
}
