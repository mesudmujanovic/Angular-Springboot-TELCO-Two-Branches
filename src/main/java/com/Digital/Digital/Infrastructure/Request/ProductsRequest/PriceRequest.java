package com.Digital.Digital.Infrastructure.Request.ProductsRequest;

import com.Digital.Digital.Infrastructure.Dto.Products.PriceDto;
import lombok.Data;

import java.util.List;

@Data
public class PriceRequest {

    private String price;
    private Integer contractDuration;
    private Boolean oneTime;
    private String name;
    private Integer discount;

}
