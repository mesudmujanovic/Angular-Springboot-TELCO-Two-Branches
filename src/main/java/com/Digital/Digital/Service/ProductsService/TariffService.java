package com.Digital.Digital.Service.ProductsService;

import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;

import java.util.List;

public interface TariffService {

    public TariffDto savePrice(TariffDto tariffDto);

    public TariffDto getTariffId( Long tariffId );

    public TariffDto getByName( String name );

    public List<TariffDto> getAll ();

}
