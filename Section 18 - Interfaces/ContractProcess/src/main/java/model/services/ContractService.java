package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        for(int i=1; i<=months; i++){
            LocalDate currentDate = contract.getDate().plusMonths(i);
            double amount = contract.getTotalValue() / months;
            amount = onlinePaymentService.paymentFee(amount);
            amount = onlinePaymentService.interest(amount,i);


            contract.addInstallment(new Installment(currentDate,amount));

        }
    }
}
