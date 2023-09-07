package com.Digital.Digital.Infrastructure.Dto.AvailibilityDto;


import com.Digital.Digital.Infrastructure.Request.Availibility.NumberRequest;
import com.Digital.Digital.Infrastructure.Response.AvailibilityResponse.NumberResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberDto {

    private Long id;

    private String num;


    public static NumberDto fromRequestToDto(NumberRequest numberRequest){
        NumberDto numberDto = new NumberDto();
        numberDto.setNum(numberRequest.getNum());
        return numberDto;
    }

    public NumberResponse dtoToResponse(){
        NumberResponse numberResponse = new NumberResponse();
        numberResponse.setId(this.getId());
        numberResponse.setNum(this.getNum());
        return numberResponse;
    }


}
