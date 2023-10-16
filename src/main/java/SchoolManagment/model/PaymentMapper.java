package SchoolManagment.model;

import SchoolManagment.dto.PaymentDTO;
import SchoolManagment.entity.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    private final ModelMapper modelMapper = new ModelMapper();


    public PaymentDTO mapPaymentToDto(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Payment mapDTOToPayment(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, Payment.class);
    }
}
