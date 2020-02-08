package br.com.otta.payment.bill.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe de modelo para representar os dados de entrada de uma conta.
 * 
 * @author Guilherme
 *
 */
public class BillData {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal originalValue;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dueDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate payday;

    public BillData() {
        // Do nothing.
    }

    public BillData(@NotNull String name, @NotNull BigDecimal originalValue, @NotNull LocalDate dueDate,
            @NotNull LocalDate payday) {
        this.name = name;
        this.originalValue = originalValue;
        this.dueDate = dueDate;
        this.payday = payday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dueDate, name, originalValue, payday);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillData)) {
            return false;
        }
        BillData other = (BillData) obj;
        return Objects.equals(dueDate, other.dueDate) && Objects.equals(name, other.name)
                && Objects.equals(originalValue, other.originalValue) && Objects.equals(payday, other.payday);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BillData [name=");
        builder.append(name);
        builder.append(", originalValue=");
        builder.append(originalValue);
        builder.append(", dueDate=");
        builder.append(dueDate);
        builder.append(", payday=");
        builder.append(payday);
        builder.append("]");
        return builder.toString();
    }
}
