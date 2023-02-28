package com.thoa.englishTutor.dtos.response.user;

import com.thoa.englishTutor.dtos.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {
    List<UserDto> userDtoList;
}
