package com.dadaok.sungminpay.membership.service;

import com.dadaok.sungminpay.common.dto.ResponseDTO;
import com.dadaok.sungminpay.membership.entity.Membership;
import com.dadaok.sungminpay.membership.model.request.MembershipRegisterRequest;
import com.dadaok.sungminpay.membership.repository.MembershipRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl {

    private final MembershipRepository membershipRepository;

    /**
     * 신규 멤버 저장
     * @param membershipRegisterRequest
     * @return
     */
    @Transactional
    public ResponseEntity<ResponseDTO> membershipRegister(MembershipRegisterRequest membershipRegisterRequest){

        membershipRepository.save(Membership.of(membershipRegisterRequest));

        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("SUCCESS!!")
                .build());
    }
}
