package br.com.otta.payment.bill.extractor;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import br.com.otta.payment.bill.model.BillData;

/**
 * Classe para extrair a diferença entre o dia de vencimento de uma conta e o dia do pagamento da mesma.
 *
 * @author Guilherme
 *
 */
@Component
public class BillLateDaysExtractor {

    public long extract(BillData billData) {
        return ChronoUnit.DAYS.between(billData.getDueDate(), billData.getPayday());
    }
}
