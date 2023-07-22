package com.Digital.Digital.Infrastructure.Dto.Products;

import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffDto {
    private Long id;

    private String name;

    private String speed;

    public static TariffDto requestToDto  (TariffRequest priceRequest){
        TariffDto priceDto = new TariffDto();
        priceDto.setName(priceRequest.getName());
        priceDto.setSpeed(priceRequest.getSpeed());
        return priceDto;
    }

                      //optional PriceDto priceDto
    public TariffResponse dtoToResponse (){
        TariffResponse priceResponse = new TariffResponse();
        priceResponse.setId(this.getId());
        priceResponse.setSpeed(this.getSpeed());
        priceResponse.setName(this.getName());
        return priceResponse;
    }
}
