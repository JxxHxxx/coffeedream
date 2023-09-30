package com.jxx.toy.raffle.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LifeCycleDate {
    protected LocalDate createdDate;
    protected LocalDate modifiedDate;

}
