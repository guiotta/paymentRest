package br.com.otta.payment.bill.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otta.payment.bill.model.BillData;
import br.com.otta.payment.bill.model.BillInformation;
import br.com.otta.payment.bill.service.BillService;
import io.swagger.v3.oas.annotations.Operation;

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

    @Operation(description = "Adiciona uma conta no sistema.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillInformation> createBill(@Valid @RequestBody BillData billData) {
        return ResponseEntity.ok(billService.createBill(billData));
    }

    @Operation(description = "Lista todas as contas que estão salvas no sistema.")
    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<BillInformation>> listAllBills() {
        return ResponseEntity.ok(billService.listAllBills());
    }
}
