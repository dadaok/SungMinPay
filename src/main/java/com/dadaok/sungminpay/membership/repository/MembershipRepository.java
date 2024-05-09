package com.dadaok.sungminpay.membership.repository;

import com.dadaok.sungminpay.membership.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByEmail(String mail);
}
