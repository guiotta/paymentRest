package br.com.otta.payment.bill.calculator.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.calculator.api.CalculatorModel;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.model.BillData;

/**
 * Testes unitários do componente {@link CalculatorModelFactory}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorModelFactoryTest {
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.TEN;
    private static final int PERCENTAGE = 25;
    private static final BigDecimal INTEREST = BigDecimal.ONE;
    private static final long LATE_DAYS = 5;

    @InjectMocks
    private CalculatorModelFactory factory;

    @Mock
    private BillData billData;
    @Mock
    private Fine fine;

    @BeforeEach
    protected void setUp() {
        given(billData.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        given(fine.getPercentage()).willReturn(PERCENTAGE);
        given(fine.getInterest()).willReturn(INTEREST);
    }

    @Test
    public void shouldCorrectlyCreateCalculatorModel() {
        // given
        CalculatorModel expectedValue = new CalculatorModel(ORIGINAL_VALUE, LATE_DAYS, PERCENTAGE, INTEREST);
        // when
        CalculatorModel actualValue = factory.create(billData, fine, LATE_DAYS);
        // then
        assertEquals(expectedValue, actualValue);
    }

}
