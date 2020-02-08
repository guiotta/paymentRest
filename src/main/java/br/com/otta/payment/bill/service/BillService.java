package br.com.otta.payment.bill.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otta.payment.bill.entity.Bill;
import br.com.otta.payment.bill.entity.Fine;
import br.com.otta.payment.bill.extractor.BillLateDaysExtractor;
import br.com.otta.payment.bill.model.BillData;
import br.com.otta.payment.bill.repository.BillRepository;
import br.com.otta.payment.bill.repository.FineRepository;

/**
 * Classe de Serviço apresentando os comportamentos necessários para a funcionalidades de contas a pagar.
 * 
 * @author Guilherme
 *
 */
@Service
public class BillService {
    private final BillLateDaysExtractor lateDaysExtractor;
    private final FineRepository fineRepository;
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillLateDaysExtractor lateDaysExtractor, FineRepository fineRepository,
            BillRepository billRepository) {
        this.lateDaysExtractor = lateDaysExtractor;
        this.fineRepository = fineRepository;
        this.billRepository = billRepository;
    }

    public void createBill(BillData billData) {
        long daysBetween = lateDaysExtractor.extract(billData);
        Collection<Fine> finesByRange = fineRepository.findByLateDaysRange(daysBetween);
        Bill bill = new Bill(null, billData.getName(), billData.getOriginalValue(), billData.getDueDate(), billData.getPayday(), daysBetween, finesByRange.stream().findFirst().orElseThrow(()->new IllegalArgumentException()));

        billRepository.save(bill);
    }
}
