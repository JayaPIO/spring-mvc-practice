package com.jaya.springMVC_learning.services.impl;

import com.jaya.springMVC_learning.dto.MemberDTO;
import com.jaya.springMVC_learning.models.Member;
import com.jaya.springMVC_learning.repositories.MemberRepository;
import com.jaya.springMVC_learning.services.MemberService;
import com.jaya.springMVC_learning.utility.DtoToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    /**
     * adding user into db
     *
     * @param memberDto
     * @param model
     */
    @Override
    @Transactional
    public void addUser(MemberDTO memberDto, Model model) {
        Member member = DtoToEntity.memberDtoToEntity(memberDto);
        model.addAttribute("member", member);
        memberRepository.save(member);
    }
}
