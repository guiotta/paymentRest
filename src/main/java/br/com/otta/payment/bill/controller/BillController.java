package br.com.otta.payment.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otta.payment.bill.model.BillData;
import br.com.otta.payment.bill.service.BillService;

/**
 * Classe para controlar o acesso aos recursos da aplicação por HTTP.
 *
 * @author Guilherme
 *
 */
@RestController
@RequestMapping("bill")
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBill(@RequestBody BillData billData) {
        billService.createBill(billData);
    }
}
