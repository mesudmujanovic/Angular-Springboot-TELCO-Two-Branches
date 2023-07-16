package com.Digital.Digital.Controllers.AvailibilityConroller;

import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.NumberRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.NumberResponse;
import com.Digital.Digital.Service.AvailabilityService.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/saveNumber/address/{addressId}")
    private ResponseEntity<NumberResponse> saveNumber(@RequestBody NumberRequest numberRequest,
                                                      @PathVariable Long addressId){
        NumberDto numberDto = NumberDto.fromRequestToDto(numberRequest);
        NumberDto saveNumber = numberService.saveNumber(numberDto, addressId);
        return ResponseEntity.ok( saveNumber.dtoToResponse() );
    }

    @GetMapping("/getAllNumbers")
    private ResponseEntity<List<NumberResponse>> getAllNumbers(){
        List<NumberDto> numberDtos = numberService.getAllNumbers();
        return ResponseEntity.ok( numberDtos.stream().map(numberses -> numberses.dtoToResponse()).collect(Collectors.toList()));
    }
}
