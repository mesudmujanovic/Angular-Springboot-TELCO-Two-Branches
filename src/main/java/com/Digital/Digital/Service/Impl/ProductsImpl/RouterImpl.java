package com.Digital.Digital.Service.Impl.ProductsImpl;

import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.RouterDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.RouterMapper;
import com.Digital.Digital.Repository.ProductsRepository.RouterRepository;
import com.Digital.Digital.Service.ProductsService.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouterImpl implements RouterService {

    @Autowired
    RouterRepository routerRepository;

    @Override
    public RouterDto saveRouter(RouterDto routerDto) {
        Router router = routerRepository.save(RouterMapper.INSTANCE.apply(routerDto));
        return RouterDtoMapper.INSTANCE.apply(router);
    }

    @Override
    public List<RouterDto> getAllRouter() {
        List<Router> listRouters = routerRepository.findAll();
        return listRouters.stream().map( routers -> RouterDtoMapper.INSTANCE.apply(routers)).collect(Collectors.toList());
    }

    @Override
    public RouterDto getById(Long routerId) {
        Router router = routerRepository.findById( routerId ).orElse(null);
        return RouterDtoMapper.INSTANCE.apply(router);
    }
}
