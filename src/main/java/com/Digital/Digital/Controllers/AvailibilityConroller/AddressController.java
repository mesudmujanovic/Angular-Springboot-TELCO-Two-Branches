package com.Digital.Digital.Controllers.AvailibilityConroller;


import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.AddressRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.AddressResponse;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@CrossOrigin("*")

public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/saveAddress/city/{cityId}")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest,
                                                        @PathVariable Long cityId) {
        AddressDto addressDto = AddressDto.addressRequestToDto(addressRequest);
        AddressDto saveAddress = addressService.saveAddress(addressDto, cityId);
        return ResponseEntity.ok( AddressDto.dtoToResponse(saveAddress) );
    }

    @GetMapping("/allAddress")
    private ResponseEntity<List<AddressResponse>> getAllCity(){
        List<AddressDto> addressDtoList = addressService.getAllAddress();
        return ResponseEntity.ok( addressDtoList.stream().map(AddressDto::dtoToResponse).collect(Collectors.toList()));
    }
}
