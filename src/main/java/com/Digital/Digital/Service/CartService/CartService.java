package com.Digital.Digital.Service.CartService;

import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;

public interface CartService {

    public TariffDto getTariffId( Long tariffId );

    public RouterDto getRouterId ( Long routerId );

}
