package com.ibk.spring.cloud.msvc.balances.msvcbalances.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseUser {
    private String message;
    private  boolean success;
    private HttpStatus status;
    private Object data;
}