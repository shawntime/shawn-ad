package com.shawntime.ad.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shawntime.ad.exception.AdException;
import com.shawntime.ad.util.IntegerExtensions;
import com.shawntime.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mashaohua
 * @date 2022/10/28 13:56
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    private static CommonResponse commonResponse = new CommonResponse(500, "程序未知异常");

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public CommonResponse operateExp(Throwable ex, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 1L);
        httpServletResponse.addHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setStatus(500);
        return commonResponse;
    }

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, AdException ex) {
        return CommonResponse.error(IntegerExtensions.getIntValue(ex.getErrorCode(), -1),
                "business error",
                ex.getMessage());
    }

}
