package SchoolManagment.controller;

import SchoolManagment.dto.PaymentDTO;
import SchoolManagment.entity.Payment;
import SchoolManagment.model.PaymentMapper;
import SchoolManagment.serviceImpl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentServiceImpl paymentService, PaymentMapper paymentMapper) {

        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.mapDTOToPayment(paymentDTO);
        this.paymentService.savePayment(payment);
        log.info("Paiement enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<PaymentDTO> getAllPayment() {
        List<Payment> paymentDTOS = this.paymentService.getAllPayment();
        return paymentDTOS.stream()
                .map(payment -> paymentMapper.mapPaymentToDto(payment))
                .collect(Collectors.toList());
//        return this.paymentService.getAllPayment();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public PaymentDTO getPayment(@PathVariable String id) {
        Payment payment = this.paymentService.getPayment(id);

        PaymentDTO paymentDTO = paymentMapper.mapPaymentToDto(payment);
        return paymentDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updatePayment(@PathVariable String id, @RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.mapDTOToPayment(paymentDTO);
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
    public void deletePayment(@PathVariable String id) {
        this.paymentService.deletePaymentByid(id);
        log.info("Paiement supprime avec succes !");
    }
}
