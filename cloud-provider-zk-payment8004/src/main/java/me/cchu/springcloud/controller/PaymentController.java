package me.cchu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.cchu.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @GetMapping("/payment/zK")
    public CommonResult getPaymentByid() {

        return new CommonResult(200, "233333333333333333", UUID.randomUUID().toString());
    }

}
