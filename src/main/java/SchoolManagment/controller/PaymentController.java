package SchoolManagment.controller;

import SchoolManagment.entity.Payment;
import SchoolManagment.serviceImpl.PaymentServiceImpl;
import SchoolManagment.serviceImpl.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "payment")
public class PaymentController {

    private PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Payment payment) {
        this.paymentService.savePayment(payment);
        log.info("Paiement enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Payment> getAllPayment() {
        return this.paymentService.getAllPayment();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Payment getPayment(@PathVariable Long id) {
        return this.paymentService.getPayment(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        this.paymentService.updatePayment(id, payment);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllPayment() {
        this.paymentService.deletePayment();
        log.info("Tous les paiements ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deletePayment(@PathVariable Long id) {
        this.paymentService.deletePaymentByid(id);
        log.info("Paiement supprime avec succes !");
    }
}
