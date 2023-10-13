package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Payment;

import java.util.List;

public interface PaymentService {

    //Enregistrer un paiement
    String savePayment(Payment payment);

    //Afficher tous les paiement
    List<Payment> getAllPayment();

    //Afficher un paiement par son id
    Payment getPayment(String id);

    //MAJ des donnees d'un paiement
    String updatePayment(String id, Payment payment);

    //Suppression de tous les paiement
    void deletePayment();

    //Suppression d'un paiement par id
    void deletePaymentByid(String id);
}
