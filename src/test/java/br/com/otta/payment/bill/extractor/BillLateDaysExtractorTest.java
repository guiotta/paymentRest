package br.com.otta.payment.bill.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.model.BillData;

/**
 * Teste unitário do componente {@link BillLateDaysExtractor}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class BillLateDaysExtractorTest {
    private static final LocalDate DUE_DATE = LocalDate.of(2020, 1, 1);

    @InjectMocks
    private BillLateDaysExtractor extractor;

    @Mock
    BillData billData;

    @BeforeEach
    protected void setUp() {
        given(billData.getDueDate()).willReturn(DUE_DATE);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void shouldCorrectExtractLateDays(LocalDate payday, long expectedValue) {
        // given
        given(billData.getPayday()).willReturn(payday);
        // when
        long actualValue = extractor.extract(billData);
        // then
        assertEquals(expectedValue, actualValue);
    }

    private static Stream<? extends Arguments> provideData() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 1, 2), 1),
                Arguments.of(LocalDate.of(2020, 1, 5), 4),
                Arguments.of(LocalDate.of(2020, 1, 10), 9),
                Arguments.of(LocalDate.of(2020, 2, 2), 32)
                );
    }
}
