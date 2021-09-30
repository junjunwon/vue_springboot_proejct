package com.vportal.vportal.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResult<T> {
    
    @NonNull
    private T data;
    private String message;

    public ApiResult(T data){
        this.data = data;
    }

    @Builder
    public ApiResult(T data, String message){
        this.data = data;
        this.message = message;
    }
}
