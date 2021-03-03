package me.cchu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.cchu.springcloud.entities.CommonResult;
import me.cchu.springcloud.entities.Payment;
import me.cchu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
