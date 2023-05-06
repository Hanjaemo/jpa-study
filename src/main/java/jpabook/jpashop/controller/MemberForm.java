package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    @NotEmpty(message = "도시명은 필수입니다.")
    private String city;

    @NotEmpty(message = "주소는 필수입니다.")
    private String street;

    @NotEmpty(message = "우편번호는 필수입니다.")
    private String zipcode;
}
