package com.challenge.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import aws.model.Table1;
import com.challenge.backend.entities.*;

@Repository
public interface Table1Repository extends CrudRepository<Table1, Long> {
/*
    Optional<Table1> findById(Long table1Id);

    List<Table1> findByTable1Id(Long table1Id);
*/
}
