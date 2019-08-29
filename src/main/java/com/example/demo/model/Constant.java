package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName Constant
 * @description @Value取值的方式
 * @date 2019/8/27 19:24
 */

@Component
public class Constant {
    @Value("${com.bear}")
    private  String val;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
