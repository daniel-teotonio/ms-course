package com.mscourse.hrpayroll.services;

import com.mscourse.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Daniel", 200.0, days);
    }
}
