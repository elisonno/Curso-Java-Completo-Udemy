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
        double basicInstallment = contract.getTotalValue() / months;
        for(int i=1; i<=months; i++){
            LocalDate currentDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicInstallment,i);
            double paymentFee = onlinePaymentService.paymentFee(basicInstallment + interest);
            double currentInstallment = basicInstallment + paymentFee + interest;

            contract.getInstallment().add(new Installment(currentDate,currentInstallment));

        }
    }
}
