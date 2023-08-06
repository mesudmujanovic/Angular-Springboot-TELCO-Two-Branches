package com.Digital.Digital.Infrastructure.Dto.Products;

import com.Digital.Digital.Infrastructure.Request.ProductsRequest.RouterRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.RouterResponse;
import lombok.Data;

@Data
public class RouterDto {
    private Long id;
    private String description;
    private Integer price;


    public static RouterDto fromRequestToDto(RouterRequest routerRequest){
        RouterDto routerDto = new RouterDto();
        routerDto.setDescription(routerRequest.getDescription());
        routerDto.setPrice(routerRequest.getPrice());
        return routerDto;
    };

    public static RouterResponse fromDtoToResponse(RouterDto routerDto){
        RouterResponse routerResponse = new RouterResponse();
        routerResponse.setId(routerDto.getId());
        routerResponse.setDescription(routerDto.getDescription());
        routerResponse.setPrice(routerDto.getPrice());
        return routerResponse;
    }
}
