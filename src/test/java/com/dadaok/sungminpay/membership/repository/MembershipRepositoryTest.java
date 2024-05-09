package com.dadaok.sungminpay.membership.repository;

import com.dadaok.sungminpay.membership.entity.Address;
import com.dadaok.sungminpay.membership.entity.Membership;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MembershipRepositoryTest {
    @Autowired
    MembershipRepository membershipRepository;

    @Test
    void 멤버십생성(){
        // given
        Membership membership = Membership.builder()
                .name("test")
                .email("test@test.co.kr")
                .address(Address.builder()
                        .city("서울")
                        .street("서울로 99")
                        .zipcode("1234")
                        .build())
                .isValid(true)
                .isCorp(false)
                .build();
        // when
        membershipRepository.save(membership);
        // then
        Membership findMember = membershipRepository.findByEmail("test@test.co.kr");

        assertThat(findMember)
                .extracting("name","isValid","address.city")
                .containsExactly("test",true,"서울");

    }

}