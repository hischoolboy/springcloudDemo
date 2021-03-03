package me.cchu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.cchu.springcloud.entities.CommonResult;
import me.cchu.springcloud.entities.Payment;
import me.cchu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

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

}
