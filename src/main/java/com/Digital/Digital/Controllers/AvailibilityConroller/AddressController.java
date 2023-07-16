package com.Digital.Digital.Controllers.AvailibilityConroller;


import com.Digital.Digital.Entity.Availibility.Address;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.AddressDto;
import com.Digital.Digital.Infrastructure.Request.Availibility.AddressRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.AddressResponse;
import com.Digital.Digital.Service.AvailabilityService.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin("*")

public class AddressController {

    private  final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/saveAddress")
    private ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest) {
        AddressDto addressDto = AddressDto.addressRequestToDto(addressRequest);
        AddressDto saveAddress = addressService.saveAddress(addressDto);
        return ResponseEntity.ok( AddressDto.dtoToResponse(saveAddress) );
    }
}
