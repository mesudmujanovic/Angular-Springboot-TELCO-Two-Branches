package com.Digital.Digital.Controllers.CartController;

import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.RouterResponse;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import com.Digital.Digital.Service.ProductsService.RouterService;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    TariffService tariffService;

    @Autowired
    RouterService routerService;

    @GetMapping("/saveCartTariff/{tariffId}")
    private ResponseEntity<TariffResponse> getPrice ( @PathVariable Long tariffId){
        TariffDto tariffDto = tariffService.getTariffId(tariffId);
        return ResponseEntity.ok( tariffDto.dtoToResponse());
    }

    @GetMapping("/saveCartRouter/{routerId}")
    private ResponseEntity<RouterResponse> getRouter( @PathVariable Long routerId ){
        RouterDto routerDto = routerService.getById(routerId);
        return ResponseEntity.ok( routerDto.fromDtoToResponse(routerDto) );
    }

}
