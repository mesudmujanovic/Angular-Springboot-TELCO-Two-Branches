package com.Digital.Digital.Infrastructure.Dto.Products;

import com.Digital.Digital.Infrastructure.Request.ProductsRequest.PriceRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.PriceResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    private Long id;
    private String price;
    private Integer contractDuration;
    private Boolean oneTime;
    private String name;
    private Integer discount;

    private Long tariffId;

    public static PriceDto requestToDto (PriceRequest priceRequest){
        PriceDto priceDto = new PriceDto();
        priceDto.setName(priceRequest.getName());
        priceDto.setPrice(priceRequest.getPrice());
        priceDto.setDiscount(priceRequest.getDiscount());
        priceDto.setOneTime(priceRequest.getOneTime());
        priceDto.setContractDuration(priceRequest.getContractDuration());
        return priceDto;
    }

    public PriceResponse dtoToResponse(){
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setId(this.getId());
        priceResponse.setDiscount(this.getDiscount());
        priceResponse.setOneTime(this.getOneTime());
        priceResponse.setName(this.getName());
        priceResponse.setContractDuration(this.getContractDuration());
        priceResponse.setPrice(this.getPrice());
        priceResponse.setTariffId(this.getTariffId());
        return priceResponse;
    }
}
