package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.constants.ViewConstant;
import com.jaya.springMVC_learning.dto.MemberDTO;
import com.jaya.springMVC_learning.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    /**
     * adding user into db
     * @param memberDto
     * @param model
     * @return
     */
    @PostMapping("/saveUser")
    public String addUser(MemberDTO memberDto, Model model) {
        System.out.println("in add user");
        memberService.addUser(memberDto, model);
        return ViewConstant.HOME_PAGE;
    }
}
