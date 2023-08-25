package com.Digital.Digital.Infrastructure.Dto.UserDto;

import com.Digital.Digital.Infrastructure.Request.UserRequest.UserJwt.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthDto {

    private Long id;
    private String username;

    private String password;

    public static UserAuthDto fromRequest(SignupRequest request){
        UserAuthDto userDTO = new UserAuthDto();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        return userDTO;
    }
}