package com.jxx.toy.applicant.infra;

import com.jxx.toy.applicant.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
