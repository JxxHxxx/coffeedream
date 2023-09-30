package com.jxx.toy.raffle.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RaffleApplicant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long applicantId;
    private Long raffleId;
    @Enumerated(value = EnumType.STRING)
    private RaffleResult raffleResult;

    public RaffleApplicant(Long applicantId, Long raffleId) {
        this.applicantId = applicantId;
        this.raffleId = raffleId;
        this.raffleResult = RaffleResult.PENDING;
    }

    public RaffleApplicant changeRaffleResult(RaffleResult raffleResult) {
        this.raffleResult = raffleResult;
        return this;
    }
}
