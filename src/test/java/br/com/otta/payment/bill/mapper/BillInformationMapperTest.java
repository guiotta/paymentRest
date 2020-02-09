package br.com.otta.payment.bill.mapper;

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
import br.com.otta.payment.bill.model.BillInformation;

/**
 * Testes unitários do componente {@link BillInformationMapper}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class BillInformationMapperTest {
    private static final BigDecimal ORIGINAL_VALUE = BigDecimal.valueOf(15l);
    private static final BigDecimal UPDATED_VALUE = BigDecimal.valueOf(20l);
    private static final String NAME = "name";
    private static final LocalDate PAYDAY = LocalDate.of(2020, 1, 20);
    private static final long LATE_DAYS = 10l;
    private static final String EXPECTED_ORIGINAL_VALUE = "R$ 15,00";
    private static final String EXPECTED_UPDATED_VALUE = "R$ 20,00";

    @InjectMocks
    private BillInformationMapper mapper;

    @Mock
    private Bill bill;

    @BeforeEach
    protected void setUp() {
        given(bill.getName()).willReturn(NAME);
        given(bill.getValue()).willReturn(ORIGINAL_VALUE);
        given(bill.getUpdatedValue()).willReturn(UPDATED_VALUE);
        given(bill.getPayday()).willReturn(PAYDAY);
        given(bill.getLateDays()).willReturn(LATE_DAYS);
    }

    @Test
    public void shouldCorrectlyMapBillToBillInformation() {
        // given
        BillInformation expectedValue = new BillInformation(NAME, EXPECTED_ORIGINAL_VALUE, EXPECTED_UPDATED_VALUE,
                LATE_DAYS, PAYDAY);
        // when
        BillInformation actualValue = mapper.map(bill);
        // then
        assertEquals(expectedValue, actualValue);
    }

}
