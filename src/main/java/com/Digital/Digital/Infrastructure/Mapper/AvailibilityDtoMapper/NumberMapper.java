package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.Number;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum NumberMapper implements DtoMapper<Number, NumberDto> {
    INSTANCE;

    @Override
    public Number apply(NumberDto numberDto) {
        Number number = new Number();
        number.setId(numberDto.getId());
        number.setNum(numberDto.getNum());
        return number;
    }
}
