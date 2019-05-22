package com.ssh.control.interceptor;

import com.ssh.error.DefaultError;
import com.ssh.error.exception.BaseBusinessException;
import com.ssh.error.exception.BaseResponse;
import com.ssh.error.vo.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ouyangyufeng on 2019/2/2.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({BaseBusinessException.class})
    @ResponseBody
    public ErrorInfo<String> businessException(HttpServletRequest request, BaseBusinessException e) {
        LOGGER.error("GlobalExceptionHandler BaseBusinessException info :", e);
        ErrorInfo r = new ErrorInfo();
        r.setStatus(BaseResponse.Status.FAILED);
        r.setErrorCode(e.getError().getErrorCode());
        r.setErrorMessage(e.getError().getErrorMessage());
        r.setExtMessage(e.getExtMessage());
        return r;
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorInfo<String> exception(HttpServletRequest request, Exception e) {
        LOGGER.error("GlobalExceptionHandler Exception info :", e);
        ErrorInfo r = new ErrorInfo();
        r.setStatus(BaseResponse.Status.FAILED);
        r.setErrorCode(DefaultError.SYSTEM_INTERNAL_ERROR.getErrorCode());
        r.setErrorMessage(e.getMessage());
        r.setExtMessage((String)null);
        return r;
    }
}
