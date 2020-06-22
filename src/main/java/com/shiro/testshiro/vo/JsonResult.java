package com.shiro.testshiro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JsonResult {

    private int state=1;

    private String message="ok";

    private Object data;

    public JsonResult(String message){
        this.message=message;
    }

    public JsonResult(Object data) {
        this.data=data;
    }
    public JsonResult(Throwable e) {
        this.state=0;//表示错误信息
        this.message=e.getMessage();//异常信息
    }


}
