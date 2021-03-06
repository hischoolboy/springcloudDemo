package me.cchu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import me.cchu.springcloud.entities.CommonResult;
import me.cchu.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global handlerException", new Payment(2020L, "serial0003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义2,global handlerException", new Payment(2020L, "serial0003"));
    }
}
