package com.dadaok.sungminpay.membership.entity;

import com.dadaok.sungminpay.membership.model.request.MembershipRegisterRequest;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String city;
    private String street;
    private String zipcode;

    @Builder
    private Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public static Address of(MembershipRegisterRequest membershipRegisterRequest){
        return Address.builder()
                .city(membershipRegisterRequest.getCity())
                .street(membershipRegisterRequest.getStreet())
                .zipcode(membershipRegisterRequest.getZipcode())
                .build();
    }
}
