/*
 *  @ Daniel Gil
 */

 package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

  private OnlinePaymentService onlinePaymentService;

  public ContractService(OnlinePaymentService onlinePaymentService) {
    this.onlinePaymentService = onlinePaymentService;
  }

  // Method que vai processar os dados do contrato, 
  //de maneira a receber o contrato e o numero de messes 
  // para fazer a contagem dos Instalments(prestações)
  // regra de Negocio
  public void processContract(Contract contract, Integer months) {

    double basicQuota = contract.getTotalValue() / months;

    for (int i = 1; i <= months; i++) {
      LocalDate dueDate = contract.getDate().plusMonths(i);

      double interest = onlinePaymentService.interest(basicQuota, i);
      double fee = onlinePaymentService.paymentFee(basicQuota + interest);
      double quota = basicQuota + interest + fee;

      contract.getInstallment().add(new Installment(dueDate, quota));
    }
  }
}