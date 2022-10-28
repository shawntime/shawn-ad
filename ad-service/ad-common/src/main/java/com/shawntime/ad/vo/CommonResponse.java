package com.shawntime.ad.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mashaohua
 * @date 2022/10/27 20:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(T data) {
        this.data = data;
    }

    public static <T> CommonResponse success(T data) {
        return new CommonResponse(data);
    }

    public static CommonResponse success() {
        return new CommonResponse();
    }

    public static CommonResponse error(int code, String message) {
        return new CommonResponse(code, message);
    }

    public static <T> CommonResponse error(int code, String message, T data) {
        return new CommonResponse(code, message, data);
    }
}
