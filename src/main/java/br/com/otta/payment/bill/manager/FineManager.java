package br.com.otta.payment.bill.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.repository.FineRepository;

/**
 * Classe para controlar o comportamento para a aquisição de uma instância de {@link Fine}, válida para uma conta.
 *
 * @author Guilherme
 *
 */
@Component
public class FineManager {
    private static final String NOT_FIND_FINE_ERROR_MESSAGE = "Could not find any Fine for %s days late.";

    private final FineRepository fineRepository;

    @Autowired
    public FineManager(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    public Fine getFine(long lateDays) {
        Collection<Fine> finesByRange = fineRepository.findByLateDaysRange(lateDays);
        Fine fine = finesByRange.stream().findFirst()
                .orElseThrow(()->new IllegalArgumentException(String.format(NOT_FIND_FINE_ERROR_MESSAGE, lateDays)));

        return fine;
    }

}
