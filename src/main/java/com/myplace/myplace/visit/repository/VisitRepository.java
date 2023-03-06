package com.myplace.myplace.visit.repository;

import com.myplace.myplace.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByMember_MemberId(String memberId);
}
