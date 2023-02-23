package com.thoa.englishTutor.dtos.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckEmailIfExistResponse {
    private boolean existed;
}
