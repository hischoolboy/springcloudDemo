package me.cchu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.cchu.springcloud.entities.CommonResult;
import me.cchu.springcloud.entities.Payment;
import me.cchu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int rt = paymentService.create(payment);
        return new CommonResult(200, "s", rt);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "s", payment);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi i am payment zipkin server";
    }

}
