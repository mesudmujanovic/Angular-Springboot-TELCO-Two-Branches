package com.Digital.Digital.Controllers.ProductsController;


import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.PriceDtoMapper;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.PriceRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.PriceResponse;
import com.Digital.Digital.Service.ProductsService.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @RequestMapping("/saveTariff")
    private ResponseEntity<PriceResponse> saveTariff(@RequestBody PriceRequest priceRequest){
        PriceDto priceDto = PriceDto.requestToDto(priceRequest);
        PriceDto savePrice = priceService.savePrice(priceDto);
        return ResponseEntity.ok( savePrice.dtoToResponse() );
    }
}
