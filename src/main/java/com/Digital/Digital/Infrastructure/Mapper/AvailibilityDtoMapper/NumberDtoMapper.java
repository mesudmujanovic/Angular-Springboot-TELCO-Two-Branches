package com.Digital.Digital.Infrastructure.Mapper.AvailibilityDtoMapper;

import com.Digital.Digital.Entity.Availibility.Number;
import com.Digital.Digital.Infrastructure.Dto.AvailibilityDto.NumberDto;
import com.Digital.Digital.Intergration.DtoMapper;

public enum NumberDtoMapper implements DtoMapper<NumberDtoMapper, Number> {
    INSTANCE;

    @Override
    public NumberDto apply(Number number) {
        NumberDto numberDto = new NumberDto();
        numberDto.setId(number.getId());
        numberDto.setNum(number.getNum());
        return numberDto;
    }
}
