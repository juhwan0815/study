package com.study.jacoco.service;

import com.study.jacoco.dto.MemberCreateRequest;
import com.study.jacoco.dto.MemberResponse;
import com.study.jacoco.dto.MemberUpdateRequest;

import java.util.List;

public interface MemberService {


    MemberResponse create(MemberCreateRequest request);

    MemberResponse update(Long memberId, MemberUpdateRequest request);

    void delete(Long memberId);

    MemberResponse findById(Long memberId);

    List<MemberResponse> findAll();
}
