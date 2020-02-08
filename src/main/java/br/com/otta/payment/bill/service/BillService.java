package br.com.otta.payment.bill.service;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otta.payment.bill.extractor.BillLateDaysExtractor;
import br.com.otta.payment.bill.model.BillData;

/**
 * Classe de Serviço apresentando os comportamentos necessários para a funcionalidades de contas a pagar.
 * 
 * @author Guilherme
 *
 */
@Service
public class BillService {
    private final BillLateDaysExtractor lateDaysExtractor;

    @Autowired
    public BillService(BillLateDaysExtractor lateDaysExtractor) {
        this.lateDaysExtractor = lateDaysExtractor;
    }

    public void createBill(BillData billData) {
        long daysBetween = lateDaysExtractor.extract(billData);

        System.out.println(daysBetween);
    }
}
