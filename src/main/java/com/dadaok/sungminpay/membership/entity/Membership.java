package com.dadaok.sungminpay.membership.entity;

import com.dadaok.sungminpay.common.entity.BaseEntity;
import com.dadaok.sungminpay.membership.model.request.MembershipRegisterRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Membership extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memebership_id")
    private Long id;
    private String name;
    private String email;
    @Embedded
    private Address address;
    private Boolean isValid;
    private Boolean isCorp;

    @Builder
    private Membership(String name, String email, Address address, Boolean isValid, Boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    public static Membership of(MembershipRegisterRequest membershipRegisterRequest){
        return Membership.builder()
                .name(membershipRegisterRequest.getName())
                .email(membershipRegisterRequest.getEmail())
                .address(Address.of(membershipRegisterRequest))
                .isValid(membershipRegisterRequest.getIsValid())
                .isCorp(membershipRegisterRequest.getIsCorp())
                .build();
    }
}
