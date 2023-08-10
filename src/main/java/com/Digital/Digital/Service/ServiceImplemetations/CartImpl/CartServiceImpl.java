package com.Digital.Digital.Service.ServiceImplemetations.CartImpl;

import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.RouterDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffDtoMapper;
import com.Digital.Digital.Repository.ProductsRepository.RouterRepository;
import com.Digital.Digital.Repository.ProductsRepository.TariffRepository;
import com.Digital.Digital.Service.CartService.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    TariffRepository tariffRepository;

    @Autowired
    RouterRepository routerRepository;

    @Override
    public TariffDto getTariffId(Long tariffId) {
        Tariff tariff = tariffRepository.findById(tariffId).orElse(null);
        return TariffDtoMapper.INSTANCE.apply(tariff);
    }

    @Override
    public RouterDto getRouterId(Long routerId) {
        Router router = routerRepository.findById(routerId).orElse(null);
        return RouterDtoMapper.INSTANCE.apply(router);
    }
}
