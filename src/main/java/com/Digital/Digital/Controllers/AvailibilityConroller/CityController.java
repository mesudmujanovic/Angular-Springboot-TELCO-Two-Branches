package com.Digital.Digital.Controllers.AvailibilityConroller;


import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.CityDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.CityRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.CityResponse;
import com.Digital.Digital.Service.AvailabilityService.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
