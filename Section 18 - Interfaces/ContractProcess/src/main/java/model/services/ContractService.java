package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        for(int i=0; i<months; i++){
            int installmentMonth = i + 1;
            Calendar currentInstallment = Calendar.getInstance();
            currentInstallment.setTime(contract.getDate());
            currentInstallment.add(Calendar.MONTH, installmentMonth);
            double amount = contract.getTotalValue() / months;
            amount = onlinePaymentService.paymentFee(amount);
            amount = onlinePaymentService.interest(amount,installmentMonth);

            contract.addInstallment(new Installment(currentInstallment.getTime(),amount));

        }
    }
}
