package com.jaya.springMVC_learning.utility;

import com.jaya.springMVC_learning.dto.MemberDTO;
import com.jaya.springMVC_learning.models.Member;

public class EntityToDto {
    public static MemberDTO memberEntityToDto(Member member) {
        return new MemberDTO(member.getUsername(), member.getPassword(), member.getRole());
    }
}
