package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.PaymentException;
import SchoolManagment.entity.Payment;
import SchoolManagment.repository.PaymentRepo;
import SchoolManagment.serviceImpl.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepo paymentRepo;

    @Override
    public String savePayment(Payment payment) {
        this.paymentRepo.save(payment);
        return PaymentException.SUCCESSFUL;
    }

    @Override
    public List<Payment> getAllPayment() {
        return this.paymentRepo.findAll();
    }

    @Override
    public Payment getPayment(String id) {
        Optional<Payment> optionalPayment = this.paymentRepo.findById(id);
        return optionalPayment.orElseThrow(() -> new RuntimeException(PaymentException.DATA_NOT_FOUND));
    }

    @Override
    public String updatePayment(String id, Payment payment) {
        Payment paymentUpdated = this.getPayment(id);

        if (paymentUpdated.getId() == payment.getId()) {
            paymentUpdated.setAmount(payment.getAmount());
            this.paymentRepo.save(paymentUpdated);
            return PaymentException.SUCCESSFUL;
        }
        else {
            return PaymentException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deletePayment() {
        this.paymentRepo.deleteAll();
    }

    @Override
    public void deletePaymentByid(String id) {
        this.paymentRepo.deleteById(id);
    }
}
