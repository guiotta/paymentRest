package br.com.otta.payment.bill.calculator.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.calculator.api.CalculatorApi;
import br.com.otta.payment.bill.calculator.api.CalculatorModel;

/**
 * {@link CalculatorApi} para obter o valor da multa que deve ser acrescido ao valor da conta.
 *
 * @author Guilherme
 *
 */
@Component
public class FineValueCalculator implements CalculatorApi {
    Logger logger = LoggerFactory.getLogger(FineValueCalculator.class);

    @Override
    public BigDecimal execute(CalculatorModel model) {
        BigDecimal percente = BigDecimal.valueOf(model.getPercentage())
                .divide(BigDecimal.valueOf(CalculatorApi.A_HUNDRED_PER_CENT));
        BigDecimal fineValue = model.getOriginalValue().multiply(percente);

        logger.debug("Calculated fine {} for model {}.", fineValue, model);
        return fineValue;
    }

}
