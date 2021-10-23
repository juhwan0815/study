package spring.study.replication.service;

import spring.study.replication.dto.MemberCreateRequest;
import spring.study.replication.dto.MemberResponse;
import spring.study.replication.dto.MemberUpdateRequest;

import java.util.List;

public interface MemberService {

    MemberResponse createMember(MemberCreateRequest request);

    MemberResponse updateMember(Long memberId, MemberUpdateRequest request);

    void deleteMember(Long memberId);

    MemberResponse findById(Long memberId);

    List<MemberResponse> findAll();
}
