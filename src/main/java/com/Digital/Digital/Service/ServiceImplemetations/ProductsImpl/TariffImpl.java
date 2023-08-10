package com.Digital.Digital.Service.ServiceImplemetations.ProductsImpl;

import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.TariffMapper;
import com.Digital.Digital.Repository.ProductsRepository.TariffRepository;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TariffImpl implements TariffService {

    @Autowired
    private TariffRepository tariffRepository;

    @Override
    public TariffDto savePrice(TariffDto tariffDto) {
       Tariff tariff = TariffMapper.INSTANCE.apply(tariffDto);
       Tariff saveTariff = tariffRepository.save(tariff);
       return TariffDtoMapper.INSTANCE.apply(saveTariff);
    }

    @Override
    public TariffDto getTariffId(Long tariffId) {
        Tariff tariff = tariffRepository.findById(tariffId).orElse(null);
        return TariffDtoMapper.INSTANCE.apply(tariff);
    }

    @Override
    public TariffDto getByName(String name) {
        Tariff tariff = tariffRepository.findByName(name);
        return TariffDtoMapper.INSTANCE.apply(tariff);
    }

    @Override
    public List<TariffDto> getAll() {
        List<Tariff> tariffList = tariffRepository.findAll();
        return tariffList.stream().map( tariffs -> TariffDtoMapper.INSTANCE.apply(tariffs)).collect(Collectors.toList());
    }


}
