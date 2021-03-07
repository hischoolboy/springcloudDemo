package springcloud.service;

import me.cchu.springcloud.entities.CommonResult;
import me.cchu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> PaymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，----PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
