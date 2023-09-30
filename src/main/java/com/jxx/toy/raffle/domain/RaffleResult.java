package com.jxx.toy.raffle.domain;

import lombok.Getter;

@Getter
public enum RaffleResult {

    PENDING("결과 대기중"), WINNING("당첨"), LOSE("낙첨");

    private String description;

    RaffleResult(String description) {
        this.description = description;
    }
}
