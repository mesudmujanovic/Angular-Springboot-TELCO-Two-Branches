package com.Digital.Digital.Controllers;

import com.Digital.Digital.Entity.Calculator;
import com.Digital.Digital.Infrastructure.Dto.CalculatorDto;
import com.Digital.Digital.Infrastructure.Request.CalculatorRequest;
import com.Digital.Digital.Infrastructure.Response.CalculatorResponse;
import com.Digital.Digital.Service.CalculatorService;
import com.Digital.Digital.Service.Impl.CalculatorImpl;
import com.Digital.Digital.Service.ProductsService.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

        @PostMapping("/calculate")
        public ResponseEntity<CalculatorResponse> calculatePrice(@RequestBody CalculatorRequest calculatorRequest) {
            CalculatorDto calculatorDto = CalculatorDto.requestToDto(calculatorRequest);
            CalculatorDto saveCalc = calculatorService.getCalculator(calculatorDto);
            return ResponseEntity.ok( saveCalc.dtoToResponse() );
        }

}
