package SchoolManagment.serviceImpl;

import SchoolManagment.exception.PaymentException;
import SchoolManagment.entity.Payment;
import SchoolManagment.repository.PaymentRepo;
import SchoolManagment.serviceImpl.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public String savePayment(Payment payment) {
        payment.setCreate_at(LocalDateTime.now());
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

        if (paymentUpdated.getId().equals(payment.getId())) {
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
