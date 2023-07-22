package com.Digital.Digital.Controllers.ProductsController;

import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TariffController {

    @Autowired
    private TariffService priceService;

    @PostMapping("/savePrice")
    private ResponseEntity<TariffResponse> savePrice (@RequestBody TariffRequest priceRequest){
        TariffDto priceDto = TariffDto.requestToDto(priceRequest);
        TariffDto savePrice = priceService.savePrice(priceDto);
        return ResponseEntity.ok( savePrice.dtoToResponse() );
    }

}
