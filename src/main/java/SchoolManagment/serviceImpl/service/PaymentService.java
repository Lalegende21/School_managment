package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Payment;

import java.util.List;

public interface PaymentService {

    //Save payment
    String savePayment(Payment payment);

    //Read all payments
    List<Payment> getAllPayment();

    //Read payment by id
    Payment getPayment(String id);

    //Update payment
    String updatePayment(String id, Payment payment);

    //Delete all payments
    void deletePayment();

    //Delete payment by id
    void deletePaymentById(String id);
}
