package com.andios.tourism.dto.response;

import lombok.Data;
@Data
public class UserResp {
    private Integer id;
    private String token;
    private String username;
    private String password;
    private Integer checkID;
}
