package com.Digital.Digital.Infrastructure.Request.ProductsRequest;

import lombok.Data;

@Data
public class PriceRequest {

    private String price;
    private Integer contractDuration;
    private Boolean oneTime;
    private String name;
    private Double discount;
}
