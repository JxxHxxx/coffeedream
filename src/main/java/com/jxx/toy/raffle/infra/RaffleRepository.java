package com.jxx.toy.raffle.infra;

import com.jxx.toy.raffle.domain.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {
}
