package com.ssh.error.vo;


import com.ssh.error.exception.BaseResponse;

/**
 * Created by ouyangyufeng on 2019/2/2.
 */
public class ErrorInfo<T> {
    public BaseResponse.Status status;
    private String errorCode;
    private String errorMessage;
    private String extMessage;

    public ErrorInfo() {
    }

    public BaseResponse.Status getStatus() {
        return this.status;
    }

    public void setStatus(BaseResponse.Status status) {
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }
}

