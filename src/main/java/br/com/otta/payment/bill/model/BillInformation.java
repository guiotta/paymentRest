package br.com.otta.payment.bill.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe de modelo para apresentar as informações sobre uma conta.
 *
 * @author Guilherme
 *
 */
public class BillInformation {
    private final String name;
    private final String originalValue;
    private final String updatedValue;
    private final Long lateDays;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final LocalDate payday;

    public BillInformation(String name, String originalValue, String updatedValue, Long lateDays,
            LocalDate payday) {
        this.name = name;
        this.originalValue = originalValue;
        this.updatedValue = updatedValue;
        this.lateDays = lateDays;
        this.payday = payday;
    }

    public String getName() {
        return name;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public String getUpdatedValue() {
        return updatedValue;
    }

    public Long getLateDays() {
        return lateDays;
    }

    public LocalDate getPayday() {
        return payday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lateDays, name, originalValue, payday, updatedValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillInformation)) {
            return false;
        }
        BillInformation other = (BillInformation) obj;
        return Objects.equals(lateDays, other.lateDays) && Objects.equals(name, other.name)
                && Objects.equals(originalValue, other.originalValue) && Objects.equals(payday, other.payday)
                && Objects.equals(updatedValue, other.updatedValue);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BillInformation [name=");
        builder.append(name);
        builder.append(", originalValue=");
        builder.append(originalValue);
        builder.append(", updatedValue=");
        builder.append(updatedValue);
        builder.append(", lateDays=");
        builder.append(lateDays);
        builder.append(", payday=");
        builder.append(payday);
        builder.append("]");
        return builder.toString();
    }
}
