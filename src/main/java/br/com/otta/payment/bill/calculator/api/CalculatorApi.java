package br.com.otta.payment.bill.calculator.api;

import java.math.BigDecimal;

/**
 * Interface para definir o comportamento das diferentes calculadoras necessárias para atualizar o valor de uma conta.
 *
 * @author Guilherme
 *
 */
public interface CalculatorApi {
    static final int A_HUNDRED_PER_CENT = 100;

    /**
     * Método para executar um cálculo e obter um acréscimo ao valor original.
     *
     * @return {@link BigDecimal} contento o valor cálculado, que deve ser acrescido ao original.
     */
    BigDecimal execute(CalculatorModel model);
}
