package com.Digital.Digital.Infrastructure.Request.ProductsRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffRouterRequest {
    private Long tariffId;
    private Long routerId;

}
