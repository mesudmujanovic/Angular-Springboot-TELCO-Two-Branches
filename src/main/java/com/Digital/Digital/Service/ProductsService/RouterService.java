package com.Digital.Digital.Service.ProductsService;

import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;

import java.util.List;

public interface RouterService {

     public RouterDto saveRouter(RouterDto routerDto);

     public List<RouterDto> getAllRouter();
}
