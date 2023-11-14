package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface invoiceRepository extends JpaRepository<invoice,Long>{

    @Query(value = "select * from invoice order by date",nativeQuery = true)
    public List<invoice> getAllBydate ();

    @Query(value = "SELECT totalttc, SUM(totalttc) OVER (ORDER BY id) AS somme_cumulative FROM invoice", nativeQuery = true)
    public List<Object[]> getSumTotalTtc();
}

