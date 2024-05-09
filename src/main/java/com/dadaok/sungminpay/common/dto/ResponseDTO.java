package com.dadaok.sungminpay.common.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDTO<T> {
    private String msg;
    private T body;

    @Builder
    public ResponseDTO(String msg, T body) {
        this.msg = msg;
        this.body = body;
    }
}
