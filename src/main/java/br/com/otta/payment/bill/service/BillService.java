package br.com.otta.payment.bill.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * Classe de Serviço apresentando os comportamentos necessários para a funcionalidades de contas a pagar.
 * 
 * @author Guilherme
 *
 */
@Service
public class BillService {
    private final BillLateDaysExtractor lateDaysExtractor;
    private final BillRepository billRepository;
    private final FineManager fineManager;
    private final CorrectedValueCalculator calculator;
    private final BillInformationMapper mapper;
    private final BillFactory billFactory;
    private final CalculatorModelFactory calculatorModelFactory;

    @Autowired
    public BillService(BillLateDaysExtractor lateDaysExtractor, BillRepository billRepository, FineManager fineManager,
            CorrectedValueCalculator calculator, BillInformationMapper mapper, BillFactory billFactory,
            CalculatorModelFactory calculatorModelFactory) {
        this.lateDaysExtractor = lateDaysExtractor;
        this.billRepository = billRepository;
        this.fineManager = fineManager;
        this.calculator = calculator;
        this.mapper = mapper;
        this.billFactory = billFactory;
        this.calculatorModelFactory = calculatorModelFactory;
    }

    public BillInformation createBill(BillData billData) {
        long daysBetween = lateDaysExtractor.extract(billData);
        Fine fine = fineManager.getFine(daysBetween);
        CalculatorModel model = calculatorModelFactory.create(billData, fine, daysBetween);
        BigDecimal updatedValue = calculator.execute(model);
        Bill bill = billFactory.create(billData, updatedValue, daysBetween, fine);
        bill = billRepository.save(bill);

        return mapper.map(bill);
    }

    public Collection<BillInformation> listAllBills() {
        Collection<BillInformation> billsInformation = billRepository.findAll().stream().map(bill -> mapper.map(bill))
                .collect(Collectors.toList());

        return billsInformation;
    }
}
