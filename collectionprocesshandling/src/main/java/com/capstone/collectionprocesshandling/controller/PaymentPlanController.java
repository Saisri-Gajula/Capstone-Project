package com.capstone.collectionprocesshandling.controller;
import com.capstone.collectionprocesshandling.model.PaymentPlanEntity;
import com.capstone.collectionprocesshandling.service.PaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentPlanController {

    private final PaymentPlanService paymentPlanService;

    @Autowired
    public PaymentPlanController(PaymentPlanService paymentPlanService) {
        this.paymentPlanService = paymentPlanService;
    }

    @PostMapping("/paymentplan/{customerId}/{paidAmount}/{dueAmount}")
    public PaymentPlanEntity addCustomerToPaymentPlan(
        @PathVariable int customerId,
        @PathVariable int paidAmount,
        @PathVariable int dueAmount
    ) {
        return paymentPlanService.addCustomerToPaymentPlan(customerId, paidAmount, dueAmount);
    }
}
