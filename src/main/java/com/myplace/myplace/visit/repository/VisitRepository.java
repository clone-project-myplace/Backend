package com.myplace.myplace.visit.repository;

import com.myplace.myplace.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
