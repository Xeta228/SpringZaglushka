package com.baron.zaglushka.model;

import lombok.Data;

@Data
public class ResponseDto {
    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private String balance;
    private String maxLimit;
}
