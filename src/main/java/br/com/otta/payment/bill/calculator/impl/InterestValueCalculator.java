package br.com.otta.payment.bill.calculator.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.calculator.api.CalculatorApi;
import br.com.otta.payment.bill.calculator.api.CalculatorModel;

/**
 * {@link CalculatorApi} para obter o valor dos juros que devem ser acrescidos ao valor da conta.
 * @author Guilherme
 *
 */
@Component
public class InterestValueCalculator implements CalculatorApi {
    Logger logger = LoggerFactory.getLogger(InterestValueCalculator.class);

    @Override
    public BigDecimal execute(CalculatorModel model) {
        BigDecimal percentage = model.getInterest().divide(BigDecimal.valueOf(CalculatorApi.A_HUNDRED_PER_CENT));
        BigDecimal interestValue = model.getOriginalValue()
                .multiply(percentage)
                .multiply(BigDecimal.valueOf(model.getLateDays()));

        logger.debug("Calculated interest {} for model {}.", interestValue, model);
        return interestValue;
    }

}
