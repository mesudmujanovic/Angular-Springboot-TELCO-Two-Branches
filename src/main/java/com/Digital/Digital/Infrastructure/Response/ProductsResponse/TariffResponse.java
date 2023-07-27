package com.Digital.Digital.Infrastructure.Response.ProductsResponse;

import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import lombok.Data;

import java.util.List;

@Data
public class TariffResponse {

    private Long id;

    private String name;

    private String speed;

    private List<PriceDto> priceList;
}
