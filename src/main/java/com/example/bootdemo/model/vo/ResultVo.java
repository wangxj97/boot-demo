package com.example.bootdemo.model.vo;

/**
 * 返回类的公共vo
 */
public class ResultVo {

    public int status;// 0成功  1失败  -1登陆超时

    public String message;

    public Object data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultVo(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultVo() {
        //默认请求成功状态
        this.status = 0;
        this.message = "请求成功";
    }

    public ResultVo(Object data) {
        //默认请求成功状态
        this.status = 0;
        this.message = "请求成功";
        this.data = data;
    }
}
