package br.com.otta.payment.bill.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.repository.FineRepository;

/**
 * Testes unitários do componente {@link FineManager}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class FineManagerTest {
    private static final long LATE_DAYS = 15l;

    @Mock
    private FineRepository fineRepository;
    @InjectMocks
    private FineManager fineManager;

    @Mock
    private Fine fine;

    @BeforeEach
    protected void setUp() {
    }

    @Test
    public void shouldCorrectlyGetFineFromDatabase() {
        // given
        given(fineRepository.findByLateDaysRange(LATE_DAYS)).willReturn(Lists.list(fine));
        // when
        Fine actualValue = fineManager.getFine(LATE_DAYS);
        // then
        assertEquals(fine, actualValue);
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryDontFindAnyFineForLateDays() {
        // given
        String expetedMessage = "Could not find any Fine for 15 days late.";
        given(fineRepository.findByLateDaysRange(LATE_DAYS)).willReturn(Lists.emptyList());
        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fineManager.getFine(LATE_DAYS);
        });
        // then
        assertEquals(expetedMessage, exception.getMessage());
    }

}
