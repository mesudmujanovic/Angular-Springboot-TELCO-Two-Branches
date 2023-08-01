package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum RouterDtoMapper implements DtoMapper<RouterDto, Router> {
    INSTANCE;

    @Override
    public RouterDto apply(Router router) {
        RouterDto routerDto = new RouterDto();
        routerDto.setId(router.getId());
        routerDto.setDescription(router.getDescription());
        routerDto.setPrice(router.getPrice());
        return routerDto;
    }
}
