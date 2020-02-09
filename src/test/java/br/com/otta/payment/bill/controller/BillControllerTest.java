package br.com.otta.payment.bill.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import br.com.otta.payment.bill.model.BillData;
import br.com.otta.payment.bill.model.BillInformation;
import br.com.otta.payment.bill.service.BillService;

/**
 * Testes unitários do componente {@link BillController}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BillControllerTest {
    @Mock
    private BillService billService;
    @InjectMocks
    private BillController billController;

    @Mock
    private BillInformation billInformation;
    @Mock
    private BillData billData;

    @BeforeEach
    protected void setUp() {
        given(billService.createBill(billData)).willReturn(billInformation);
        given(billService.listAllBills()).willReturn(Lists.list(billInformation));
    }

    @Test
    public void shouldCorrectlyCreateBill() {
        // given
        // when
        ResponseEntity<BillInformation> actualValue = billController.createBill(billData);
        // then
        assertEquals(billInformation, actualValue.getBody());
    }

    @Test
    public void shouldCorrectlyListAllBills() {
        // given
        // when
        ResponseEntity<Collection<BillInformation>> actualValues = billController.listAllBills();
        // then
        assertThat(actualValues.getBody(), containsInAnyOrder(billInformation));
    }

}
