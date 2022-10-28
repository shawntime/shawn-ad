package com.shawntime.ad.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mashaohua
 * @date 2022/10/27 20:13
 */
@Data
@NoArgsConstructor
public class AdException extends RuntimeException {

    private int errorCode;

    public AdException(String message) {
        super(message);
    }

    public AdException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
