package com.jaya.springMVC_learning.utility;

import com.jaya.springMVC_learning.dto.MemberDTO;
import com.jaya.springMVC_learning.models.Member;

public class DtoToEntity {
    public static Member memberDtoToEntity(MemberDTO memberDTO) {
        return new Member(memberDTO.getUsername(), memberDTO.getPassword(), memberDTO.getRole());
    }
}
