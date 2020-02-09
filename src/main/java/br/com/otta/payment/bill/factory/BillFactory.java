package br.com.otta.payment.bill.factory;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.entity.Bill;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.model.BillData;

/**
 * Componente com a responsabilidade de criar um {@link Bill} com os dados necessários.
 *
 * @author Guilherme
 *
 */
@Component
public class BillFactory {

    public Bill create(BillData billData, BigDecimal updatedValue, long lateDays, Fine fine) {
        return new Bill(null, billData.getName(), billData.getOriginalValue(), updatedValue, billData.getDueDate(),
                billData.getPayday(), lateDays, fine);
    }

}
