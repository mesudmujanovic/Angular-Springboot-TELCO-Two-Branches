package com.Digital.Digital.Infrastructure.Response.ProductsResponse;

import lombok.Data;

@Data
public class PriceResponse {
    private Long id;
    private String price;
    private Integer contractDuration;
    private Boolean oneTime;
    private String name;
    private Integer discount;

    private Long tariffId;
}
