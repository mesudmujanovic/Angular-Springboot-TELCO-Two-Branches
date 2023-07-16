package com.Digital.Digital.Controllers.AvailibilityConroller;


import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.CityRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.CityResponse;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/saveCity")
    public ResponseEntity<CityResponse> saveCity(@RequestBody CityRequest cityRequest){
        CityDto cityDto = CityDto.requestToDto(cityRequest);
        CityDto saveCity = cityService.createCity(cityDto);
        return ResponseEntity.ok( saveCity.dtoToResponse(saveCity) );
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<CityResponse> getCityId( @PathVariable Long cityId ){
        CityDto cityDto = cityService.getCityId(cityId);
        return ResponseEntity.ok( cityDto.dtoToResponse(cityDto) );
    }

    @GetMapping("/getAllCity")
    public ResponseEntity<List<CityResponse>> getAllCity(){
        List<CityDto> cityDtos = cityService.getAllCity();
        return ResponseEntity.ok( cityDtos.stream().map( cityDto-> cityDto.dtoToResponse(cityDto)).collect(Collectors.toList()));
    }

}
