package br.com.otta.payment.bill.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.entity.Bill;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.model.BillData;

/**
 * Testes unitários do componente {@link BillFactory}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class BillFactoryTest {
    private static final String NAME = "name";
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.valueOf(100l);
    private static final BigDecimal UPDATED_VALUE = BigDecimal.valueOf(150l);
    private static final long LATE_DAYS = 20l;
    private static final LocalDate DUE_DATE = LocalDate.of(2020, 1, 1);
    private static final LocalDate PAYDAY = LocalDate.of(2020, 1, 2);

    @InjectMocks
    private BillFactory factory;

    @Mock
    private BillData billData;
    @Mock
    private Fine fine;

    @BeforeEach
    protected void setUp() {
        given(billData.getName()).willReturn(NAME);
        given(billData.getOriginalValue()).willReturn(ORIGINAL_VALUE);
        given(billData.getDueDate()).willReturn(DUE_DATE);
        given(billData.getPayday()).willReturn(PAYDAY);
    }

    @Test
    public void shouldCorrectlyCreateBill() {
        // given
        Bill expectedValue = new Bill(null, NAME, ORIGINAL_VALUE, UPDATED_VALUE, DUE_DATE, PAYDAY, LATE_DAYS, fine);
        // when
        Bill actualValue = factory.create(billData, UPDATED_VALUE, LATE_DAYS, fine);
        // then
        assertEquals(expectedValue, actualValue);
    }

}
