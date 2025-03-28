package com.jaya.springMVC_learning.services;

import com.jaya.springMVC_learning.dto.MemberDTO;
import org.springframework.ui.Model;

public interface MemberService {
    void addUser(MemberDTO memberDto, Model model);
}
