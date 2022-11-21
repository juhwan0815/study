package com.study.springbatch.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tax {

    @Id
    @GeneratedValue
    private Long id;

    private long txAmount;

    private long ownerNo;

    public Tax(long txAmount, long ownerNo) {
        this.txAmount = txAmount;
        this.ownerNo = ownerNo;
    }
}
