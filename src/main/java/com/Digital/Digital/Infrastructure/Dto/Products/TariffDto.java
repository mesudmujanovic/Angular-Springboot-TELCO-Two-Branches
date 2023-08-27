package com.Digital.Digital.Infrastructure.Dto.Products;

import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.PriceDtoMapper;
import com.Digital.Digital.Infrastructure.Mapper.ProductsDtoMapper.PriceMapper;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffDto {
    private Long id;

    private String name;

    private String speed;

    private List<PriceDto> priceList;


    public static TariffDto requestToDto  (TariffRequest priceRequest){
        TariffDto tariffDto = new TariffDto();
        tariffDto.setName(priceRequest.getName());
        tariffDto.setSpeed(priceRequest.getSpeed());
        tariffDto.setPriceList(priceRequest.getPriceList().stream().map(prices-> PriceDtoMapper.INSTANCE.apply(PriceMapper.INSTANCE.apply(prices))).collect(Collectors.toList()));
        return tariffDto;
    }

    public TariffResponse dtoToResponse (){
        TariffResponse priceResponse = new TariffResponse();
        priceResponse.setId(this.getId());
        priceResponse.setSpeed(this.getSpeed());
        priceResponse.setName(this.getName());
        priceResponse.setPriceList(this.getPriceList());
        return priceResponse;
    }
}
