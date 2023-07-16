package com.Digital.Digital.Controllers.AvailibilityConroller;


import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.NumberRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.NumberResponse;
import com.Digital.Digital.Service.AvailabilityService.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/saveNumber")
    private ResponseEntity<NumberResponse> saveNumber(@RequestBody NumberRequest numberRequest){
        NumberDto numberDto = NumberDto.fromRequestToDto(numberRequest);
        NumberDto saveNumber = numberService.saveNumber(numberDto);
        return ResponseEntity.ok( saveNumber.dtoToResponse() );
    }
}
