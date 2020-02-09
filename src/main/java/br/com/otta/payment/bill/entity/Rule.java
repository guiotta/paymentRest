package br.com.otta.payment.bill.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para mapear a table 'rule'.
 * 
 * @author Guilherme
 *
 */
@Entity
@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "initial_day")
    private Long initialDay;
    @Column(name = "final_day")
    private Long finalDay;

    public Rule() {
        // Do nothing.
    }

    public Rule(Long id, Long initialDay, Long finalDay) {
        this.id = id;
        this.initialDay = initialDay;
        this.finalDay = finalDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInitialDay() {
        return initialDay;
    }

    public void setInitialDay(Long initialDay) {
        this.initialDay = initialDay;
    }

    public Long getFinalDay() {
        return finalDay;
    }

    public void setFinalDay(Long finalDay) {
        this.finalDay = finalDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalDay, id, initialDay);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) obj;
        return Objects.equals(finalDay, other.finalDay) && Objects.equals(id, other.id)
                && Objects.equals(initialDay, other.initialDay);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rule [id=");
        builder.append(id);
        builder.append(", initialDay=");
        builder.append(initialDay);
        builder.append(", finalDay=");
        builder.append(finalDay);
        builder.append("]");
        return builder.toString();
    }
}
