package com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper;

import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum RouterMapper implements DtoMapper<Router, RouterDto> {
    INSTANCE;

    @Override
    public Router apply(RouterDto routerDto) {
        Router router = new Router();
        router.setId(routerDto.getId());
        router.setPrice(routerDto.getPrice());
        router.setDescription(routerDto.getDescription());
        return router;
    }
}
