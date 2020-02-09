package br.com.otta.payment.bill.calculator.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.calculator.api.CalculatorModel;

/**
 * Testes da classe {@link FineValueCalculator}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class FineValueCalculatorTest {
    private static final int PERCENTAGE = 5;
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.valueOf(100l);

    @InjectMocks
    private FineValueCalculator calculator;

    @Mock
    private CalculatorModel model;

    @Test
    public void shouldCorrectlyCalculateFineValue() {
        // given
        BigDecimal expectedValue = BigDecimal.valueOf(5);
        given(model.getPercentage()).willReturn(PERCENTAGE);
        given(model.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        // when
        BigDecimal actualValue = calculator.execute(model);
        // then
        assertThat(actualValue, comparesEqualTo(expectedValue));
    }

}
