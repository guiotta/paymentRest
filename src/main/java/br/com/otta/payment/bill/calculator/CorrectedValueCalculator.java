package br.com.otta.payment.bill.calculator;

import java.math.BigDecimal;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.calculator.api.CalculatorApi;
import br.com.otta.payment.bill.calculator.api.CalculatorModel;

/**
 * Componente para realizar o cálculo do valor da conta atualizado.
 *
 * @author Guilherme
 *
 */
@Component
public class CorrectedValueCalculator {
    Logger logger = LoggerFactory.getLogger(CorrectedValueCalculator.class);

    private final Collection<CalculatorApi> calculators;

    @Autowired
    public CorrectedValueCalculator(Collection<CalculatorApi> calculators) {
        this.calculators = calculators;
    }

    public BigDecimal execute(CalculatorModel model) {
        BigDecimal valueToAdd = calculators.stream()
                .map(calculator -> calculator.execute(model))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        logger.debug("Adding value {}, to original {}.", valueToAdd, model.getOriginalValue());
        return model.getOriginalValue().add(valueToAdd);
    }

}
