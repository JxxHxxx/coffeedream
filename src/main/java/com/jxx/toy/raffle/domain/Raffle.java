package com.jxx.toy.raffle.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Raffle {

    @Id @GeneratedValue
    @Column(name = "raffle_id")
    private Long id;
    private String name;

    public Raffle(String name) {
        this.name = name;
    }
}
