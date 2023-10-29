package com.capstone.collectionprocesshandling.service;
import com.capstone.collectionprocesshandling.model.PaymentPlanEntity;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.PaymentPlanRepo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentPlanService {

    private final PaymentPlanRepo paymentPlanRepository;

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    public PaymentPlanService(PaymentPlanRepo paymentPlanRepository) {
        this.paymentPlanRepository = paymentPlanRepository;
    }

    public PaymentPlanEntity addCustomerToPaymentPlan(int customerId, int paidAmount, int dueAmount) {
        PaymentPlanEntity paymentPlan = new PaymentPlanEntity();
        paymentPlan.setDueamount(dueAmount);
        paymentPlan.setPaidmaount(paidAmount);
        paymentPlan.setDuedate(LocalDate.now().plusDays(30));
        paymentPlan.setCustomer(customerRepo.findById(customerId));
        return paymentPlanRepository.save(paymentPlan);
    }
}