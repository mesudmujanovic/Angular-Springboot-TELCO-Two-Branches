package com.Digital.Digital.Controllers.ProductsController;

import com.Digital.Digital.Infrastructure.Dto.Products.TariffDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import com.Digital.Digital.Service.ProductsService.TariffService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @PostMapping("/saveTariff")
    private ResponseEntity<TariffResponse> savePrice (@RequestBody TariffRequest priceRequest){
        TariffDto tariffDto = TariffDto.requestToDto(priceRequest);
        TariffDto saveTariff = tariffService.savePrice(tariffDto);
        return ResponseEntity.ok( saveTariff.dtoToResponse() );
    }

    @GetMapping("/getByName/{name}")
    private ResponseEntity<TariffResponse> getByName(@PathVariable String name){
        TariffDto saveTariff = tariffService.getByName(name);
        return ResponseEntity.ok( saveTariff.dtoToResponse() );
    }

    @GetMapping("/getAllTariffs")
    private ResponseEntity<List<TariffResponse>> getAllTariffs(){
        List<TariffDto> tariffDtos = tariffService.getAll();
        return ResponseEntity.ok( tariffDtos.stream().map( tariffs -> tariffs.dtoToResponse() ).collect(Collectors.toList()));
    }

}
