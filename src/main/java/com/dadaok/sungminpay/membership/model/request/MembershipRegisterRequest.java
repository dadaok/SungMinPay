package com.dadaok.sungminpay.membership.model.request;

import lombok.Getter;

@Getter
public class MembershipRegisterRequest {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String street;
    private String zipcode;
    private Boolean isValid;
    private Boolean isCorp;
}
