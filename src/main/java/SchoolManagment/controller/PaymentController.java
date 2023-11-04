package SchoolManagment.controller;

import SchoolManagment.dto.PaymentDTO;
import SchoolManagment.entity.Payment;
import SchoolManagment.model.PaymentMapper;
import SchoolManagment.serviceImpl.PaymentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    private final PaymentMapper paymentMapper;


    //Method to save payment
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.mapDTOToPayment(paymentDTO);
        this.paymentService.savePayment(payment);
        return "Payment register successfully!";
    }



    //Method to read all payments
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<PaymentDTO> getAllPayment() {
        List<Payment> paymentDTOS = this.paymentService.getAllPayment();
        return paymentDTOS.stream()
                .map(payment -> paymentMapper.mapPaymentToDto(payment))
                .collect(Collectors.toList());
//        return this.paymentService.getAllPayment();
    }



    //Method to read payments by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public PaymentDTO getPayment(@PathVariable String id) {
        Payment payment = this.paymentService.getPayment(id);

        PaymentDTO paymentDTO = paymentMapper.mapPaymentToDto(payment);
        return paymentDTO;
    }



    //Methode to update payment
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updatePayment(@PathVariable String id, @RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.mapDTOToPayment(paymentDTO);
        this.paymentService.updatePayment(id, payment);
        return "Update complete successfully!";
    }



    //Method to delete all payments
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllPayment() {
        this.paymentService.deletePayment();
        return "All payments delete successfully!";
    }


    //Method to delete payment by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deletePayment(@PathVariable String id) {
        this.paymentService.deletePaymentById(id);
        return "Payment delete successfully!";
    }
}
