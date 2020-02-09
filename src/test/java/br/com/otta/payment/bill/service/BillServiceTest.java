package br.com.otta.payment.bill.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
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

import br.com.otta.payment.bill.calculator.CorrectedValueCalculator;
import br.com.otta.payment.bill.calculator.api.CalculatorModel;
import br.com.otta.payment.bill.calculator.factory.CalculatorModelFactory;
import br.com.otta.payment.bill.entity.Bill;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.extractor.BillLateDaysExtractor;
import br.com.otta.payment.bill.factory.BillFactory;
import br.com.otta.payment.bill.manager.FineManager;
import br.com.otta.payment.bill.mapper.BillInformationMapper;
import br.com.otta.payment.bill.model.BillData;
import br.com.otta.payment.bill.model.BillInformation;
import br.com.otta.payment.bill.repository.BillRepository;

/**
 * Classe de testes unitários do componente {@link BillService}
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BillServiceTest {
    private static final long LATE_DAYS = 5;
    private static final BigDecimal UPDATED_VALUE = BigDecimal.valueOf(200l);

    @Mock
    private BillFactory billFactory;

    @Mock
    private BillRepository billRepository;

    @Mock
    private CorrectedValueCalculator calculator;

    @Mock
    private CalculatorModelFactory calculatorModelFactory;

    @Mock
    private FineManager fineManager;

    @Mock
    private BillLateDaysExtractor lateDaysExtractor;

    @Mock
    private BillInformationMapper mapper;
    @InjectMocks
    private BillService billService;

    @Mock
    private BillData billData;
    @Mock
    private Fine fine;
    @Mock
    private CalculatorModel calculatorModel;
    @Mock
    private Bill billA;
    @Mock
    private Bill billB;
    @Mock
    private Bill savedBill;
    @Mock
    private BillInformation billInformationA;
    @Mock
    private BillInformation billInformationB;

    @BeforeEach
    protected void setUp() {
        given(lateDaysExtractor.extract(billData)).willReturn(LATE_DAYS);
        given(fineManager.getFine(LATE_DAYS)).willReturn(fine);
        given(calculatorModelFactory.create(billData, fine, LATE_DAYS)).willReturn(calculatorModel);
        given(calculator.execute(calculatorModel)).willReturn(UPDATED_VALUE);
        given(billFactory.create(billData, UPDATED_VALUE, LATE_DAYS, fine)).willReturn(billA);
        given(billRepository.save(billA)).willReturn(savedBill);
        given(mapper.map(savedBill)).willReturn(billInformationA);
        given(mapper.map(billB)).willReturn(billInformationB);
    }

    @Test
    public void shouldCorrrectlySaveBill() {
        // given
        // when
        BillInformation actualValue = billService.createBill(billData);
        // then
        assertEquals(billInformationA, actualValue);
    }

    @Test
    public void shouldListAllBillsInDatabase() {
        // given
        given(billRepository.findAll()).willReturn(Lists.list(savedBill, billB));
        // when
        Collection<BillInformation> actualValues = billService.listAllBills();
        // then
        assertThat(actualValues, containsInAnyOrder(billInformationA, billInformationB));
    }

    @Test
    public void shouldReturnEmptyListWhenRepositoryDontFindAnyBill() {
        // given
        given(billRepository.findAll()).willReturn(Lists.emptyList());
        // when
        Collection<BillInformation> actualValues = billService.listAllBills();
        // then
        assertThat(actualValues, empty());
    }

}
