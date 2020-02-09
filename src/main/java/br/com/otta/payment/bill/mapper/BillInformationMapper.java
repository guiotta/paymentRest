package br.com.otta.payment.bill.mapper;

import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.entity.Bill;
import br.com.otta.payment.bill.model.BillInformation;

/**
 * Componente para mapear um {@link Bill} em um {@link BillInformation}.
 *
 * @author Guilherme
 *
 */
@Component
public class BillInformationMapper {
    private static final String MONEY_FORMAT = "R$ %.2f";

    public BillInformation map(Bill bill) {
        String formattedValue = String.format(MONEY_FORMAT, bill.getValue());
        String formattedUpdatedValue = String.format(MONEY_FORMAT, bill.getUpdatedValue());

        return new BillInformation(bill.getName(), formattedValue, formattedUpdatedValue, bill.getLateDays(),
                bill.getPayday());
    }
}
