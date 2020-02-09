package br.com.otta.payment.bill.calculator.factory;

import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.calculator.api.CalculatorModel;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.model.BillData;

/**
 * Componente com a responsabilidade de construir um {@link CalculatorModel}.
 * 
 * @author Guilherme
 *
 */
@Component
public class CalculatorModelFactory {

    public CalculatorModel create(BillData billData, Fine fine, long lateDays) {
        return new CalculatorModel(billData.getOriginalValue(), lateDays, fine.getPercentage(), fine.getInterest());
    }

}
