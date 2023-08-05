package com.Digital.Digital.Infrastructure.Dto.Products;


import com.Digital.Digital.Entity.Products.Router;
import com.Digital.Digital.Entity.Products.Tariff;
import com.Digital.Digital.Entity.Products.TariffRouter;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.TariffRouterRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.TariffRouterRespose;
import lombok.Data;

@Data
public class TariffRouterDto {


    public Long id;

    private Long tariffId;
    private Long routerId;

    public static TariffRouterDto dtoToEntiry(TariffRouterRequest tariffRouterRequest){
        TariffRouterDto tariffRouterDto = new TariffRouterDto();
        tariffRouterDto.setTariffId(tariffRouterRequest.getTariffId());
        tariffRouterDto.setRouterId(tariffRouterRequest.getRouterId());
        return tariffRouterDto;
    }




}
