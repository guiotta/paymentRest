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
 * Testes unitário do componente {@link InterestValueCalculator}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class InterestValueCalculatorTest {
    private static final BigDecimal INTEREST = BigDecimal.valueOf(1l);
    private static final Long DAYS = Long.valueOf(3l);
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.valueOf(200l);

    @InjectMocks
    private InterestValueCalculator calculator;

    @Mock
    private CalculatorModel model;

    @Test
    public void shouldCorrectlyCalculateInterest() throws Exception {
        // given
        BigDecimal expectedValue = BigDecimal.valueOf(6);
        given(model.getInterest()).willReturn(INTEREST);
        given(model.getLateDays()).willReturn(DAYS);
        given(model.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        // when
        BigDecimal actualValue = calculator.execute(model);
        // then
        assertThat(actualValue, comparesEqualTo(expectedValue));
    }

}
