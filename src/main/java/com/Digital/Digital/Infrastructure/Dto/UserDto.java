package com.Digital.Digital.Infrastructure.Dto;

import com.Digital.Digital.Infrastructure.Request.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;

    private String password;

    public static UserDto fromRequest(SignupRequest request){
        UserDto userDTO = new UserDto();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        return userDTO;
    }
}