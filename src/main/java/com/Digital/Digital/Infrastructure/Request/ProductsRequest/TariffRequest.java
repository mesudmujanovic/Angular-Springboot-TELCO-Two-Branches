package com.Digital.Digital.Infrastructure.Request.ProductsRequest;

import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import lombok.Data;

import java.util.List;

@Data
public class TariffRequest {

    private String name;

    private String speed;

    private List<PriceDto> priceList;

}


