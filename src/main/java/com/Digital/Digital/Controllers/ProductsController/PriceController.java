package com.Digital.Digital.Controllers.ProductsController;


import com.Digital.Digital.Entity.Calculator;
import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.PriceRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.PriceResponse;
import com.Digital.Digital.Service.Impl.CalculatorImpl;
import com.Digital.Digital.Service.ProductsService.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private CalculatorImpl priceCalculateService;


    @PostMapping("/saveTariff/tariffName/{name}")
    private ResponseEntity<PriceResponse> saveTariff(@RequestBody PriceRequest priceRequest,
                                                     @PathVariable String name){
        PriceDto priceDto = PriceDto.requestToDto(priceRequest);
        PriceDto savePrice = priceService.savePrice(priceDto,name);
        return ResponseEntity.ok( savePrice.dtoToResponse() );
    }
}
