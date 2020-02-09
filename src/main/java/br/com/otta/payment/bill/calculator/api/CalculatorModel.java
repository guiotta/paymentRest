package br.com.otta.payment.bill.calculator.api;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe de modelo para ser utilizada pela funcionalidade de calculadora.
 * 
 * @author Guilherme
 *
 */
public class CalculatorModel {
    private final BigDecimal originalValue;
    private final long lateDays;
    private final int percentage;
    private final BigDecimal interest;

    public CalculatorModel(BigDecimal originalValue, long lateDays, int percentage, BigDecimal interest) {
        this.originalValue = originalValue;
        this.lateDays = lateDays;
        this.percentage = percentage;
        this.interest = interest;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public long getLateDays() {
        return lateDays;
    }

    public int getPercentage() {
        return percentage;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(interest, lateDays, originalValue, percentage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalculatorModel)) {
            return false;
        }
        CalculatorModel other = (CalculatorModel) obj;
        return Objects.equals(interest, other.interest) && lateDays == other.lateDays
                && Objects.equals(originalValue, other.originalValue) && percentage == other.percentage;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CalculatorModel [originalValue=");
        builder.append(originalValue);
        builder.append(", lateDays=");
        builder.append(lateDays);
        builder.append(", percentage=");
        builder.append(percentage);
        builder.append(", interest=");
        builder.append(interest);
        builder.append("]");
        return builder.toString();
    }

}
