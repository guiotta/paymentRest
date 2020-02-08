package br.com.otta.payment.bill.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe para representar a tabela 'fine'.
 *
 * @author Guilherme
 *
 */
@Entity
@Table(name = "fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "percentage")
    private Integer percentage;
    @Column(name = "interest")
    private BigDecimal interest;
    @OneToOne
    @JoinColumn(name = "id_rule", referencedColumnName = "id")
    private Rule rule;
    @OneToMany(mappedBy = "fine", fetch = FetchType.LAZY)
    private Set<Bill> bills;

    public Fine() {
        // Do nothing.
    }

    public Fine(Long id, Integer percentage, BigDecimal interest, Rule rule, Set<Bill> bills) {
        this.id = id;
        this.percentage = percentage;
        this.interest = interest;
        this.rule = rule;
        this.bills = bills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bills, id, interest, percentage, rule);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fine)) {
            return false;
        }
        Fine other = (Fine) obj;
        return Objects.equals(bills, other.bills) && Objects.equals(id, other.id)
                && Objects.equals(interest, other.interest) && Objects.equals(percentage, other.percentage)
                && Objects.equals(rule, other.rule);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Fine [id=");
        builder.append(id);
        builder.append(", percentage=");
        builder.append(percentage);
        builder.append(", interest=");
        builder.append(interest);
        builder.append(", rule=");
        builder.append(rule);
        builder.append(", bills=");
        builder.append(bills);
        builder.append("]");
        return builder.toString();
    }
}
