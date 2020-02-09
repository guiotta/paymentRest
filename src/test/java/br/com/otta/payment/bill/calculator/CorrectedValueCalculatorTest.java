package br.com.otta.payment.bill.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.calculator.api.CalculatorModel;
import br.com.otta.payment.bill.calculator.impl.FineValueCalculator;
import br.com.otta.payment.bill.calculator.impl.InterestValueCalculator;

/**
 * Testes unitários do componente {@link CorrectedValueCalculator}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class CorrectedValueCalculatorTest {
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.valueOf(100l);
    private static final BigDecimal VALUE_5 = BigDecimal.valueOf(5l);
    private static final BigDecimal VALUE_10 = BigDecimal.valueOf(10l);

    @Mock
    private FineValueCalculator fineValueCalculator;
    @Mock
    private InterestValueCalculator interestValueCalculator;
    private CorrectedValueCalculator correctedValueCalculator;

    @Mock
    private CalculatorModel model;

    @BeforeEach
    protected void setUp() {
    }

    @Test
    public void shouldCorrectlyCalculateUpdatedValue() {
        // given
        correctedValueCalculator = new CorrectedValueCalculator(
                Lists.list(fineValueCalculator, interestValueCalculator));

        BigDecimal expectedValue = BigDecimal.valueOf(115l);
        given(interestValueCalculator.execute(model)).willReturn(VALUE_5);
        given(fineValueCalculator.execute(model)).willReturn(VALUE_10);
        given(model.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        // when
        BigDecimal actualValue = correctedValueCalculator.execute(model);
        // then
        assertThat(actualValue, comparesEqualTo(expectedValue));
    }

    @Test
    public void shouldReturnOriginalValueIfNotFoundAnyCalculator() {
        // given
        correctedValueCalculator = new CorrectedValueCalculator(Lists.emptyList());

        BigDecimal expectedValue = BigDecimal.valueOf(100l);
        given(model.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        // when
        BigDecimal actualValue = correctedValueCalculator.execute(model);
        // then
        assertThat(actualValue, comparesEqualTo(expectedValue));
    }
}
