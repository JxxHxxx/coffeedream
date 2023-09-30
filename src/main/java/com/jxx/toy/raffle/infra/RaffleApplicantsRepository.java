package com.jxx.toy.raffle.infra;


import com.jxx.toy.raffle.domain.RaffleApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RaffleApplicantsRepository extends JpaRepository<RaffleApplicant, Long> {

    List<RaffleApplicant> findByRaffleId(@Param("raffleId") Long raffleId);
}
