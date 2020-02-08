package br.com.otta.payment.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.otta.payment.bill.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
