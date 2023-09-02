package com.Digital.Digital.Controllers.ProductsController;

import com.Digital.Digital.Infrastructure.Dto.Products.RouterDto;
import com.Digital.Digital.Infrastructure.Request.ProductsRequest.RouterRequest;
import com.Digital.Digital.Infrastructure.Response.ProductsResponse.RouterResponse;
import com.Digital.Digital.Service.ProductsService.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RouterController {

    @Autowired
    RouterService routerService;

    @PostMapping("/addRouter")
    public ResponseEntity<RouterResponse> saveRouters(@RequestBody RouterRequest routerRequest) {
        RouterDto routerDto = RouterDto.fromRequestToDto(routerRequest);
        RouterDto routerDtoSave = routerService.saveRouter(routerDto);
        return ResponseEntity.ok(RouterDto.fromDtoToResponse(routerDtoSave));
    }

    @GetMapping("/getAllRouters")
    public ResponseEntity<List<RouterResponse>> getAllRouter(){
        List<RouterDto> routerDtos = routerService.getAllRouter();
        return ResponseEntity.ok(routerDtos.stream().map( routers -> RouterDto.fromDtoToResponse(routers)).collect(Collectors.toList()));
    }
}
