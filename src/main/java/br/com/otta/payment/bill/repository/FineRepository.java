package br.com.otta.payment.bill.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.otta.payment.bill.entity.Fine;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {

    @Query("SELECT f FROM Fine f WHERE ?1 BETWEEN f.rule.initialDay AND f.rule.finalDay")
    Collection<Fine> findByLateDaysRange(long lateDays);
}
