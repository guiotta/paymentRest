package br.com.otta.payment.bill.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para mapear a tabela 'bill'.
 * 
 * @author Guilherme
 *
 */
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "updated_value")
    private BigDecimal updatedValue;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "payday")
    private LocalDate payday;
    @Column(name = "late_days")
    private Long lateDays;
    @ManyToOne
    @JoinColumn(name = "id_fine", nullable = false)
    private Fine fine;

    public Bill() {
        // Do nothing.
    }

    public Bill(Long id, String name, BigDecimal value, BigDecimal updatedValue, LocalDate dueDate, LocalDate payday,
            Long lateDays, Fine fine) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.updatedValue = updatedValue;
        this.dueDate = dueDate;
        this.payday = payday;
        this.lateDays = lateDays;
        this.fine = fine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getUpdatedValue() {
        return updatedValue;
    }

    public void setUpdatedValue(BigDecimal updatedValue) {
        this.updatedValue = updatedValue;
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

    public Long getLateDays() {
        return lateDays;
    }

    public void setLateDays(Long lateDays) {
        this.lateDays = lateDays;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dueDate, fine, id, lateDays, name, payday, updatedValue, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) obj;
        return Objects.equals(dueDate, other.dueDate) && Objects.equals(fine, other.fine)
                && Objects.equals(id, other.id) && Objects.equals(lateDays, other.lateDays)
                && Objects.equals(name, other.name) && Objects.equals(payday, other.payday)
                && Objects.equals(updatedValue, other.updatedValue) && Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bill [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", value=");
        builder.append(value);
        builder.append(", updatedValue=");
        builder.append(updatedValue);
        builder.append(", dueDate=");
        builder.append(dueDate);
        builder.append(", payday=");
        builder.append(payday);
        builder.append(", lateDays=");
        builder.append(lateDays);
        builder.append(", fine=");
        builder.append(fine);
        builder.append("]");
        return builder.toString();
    }
}
