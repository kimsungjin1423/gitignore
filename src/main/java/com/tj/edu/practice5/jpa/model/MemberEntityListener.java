package com.tj.edu.practice5.jpa.model;

import com.tj.edu.practice5.jpa.repository.MemberLogHistoryRepository;
import com.tj.edu.practice5.jpa.util.SpringBeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MemberEntityListener {
    //    @Autowired
//    private MemberLogHistoryRepository memberLogHistoryRepository;
    @PostPersist
    @PostUpdate
    public void afterMemberSave(Object o) {
        MemberLogHistoryRepository memberLogHistoryRepository = SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        Member member = (Member) o;

        MemberLogHistory memberLogHistory = MemberLogHistory.builder()
                .member(member)
                .name(member.getName())
                .email(member.getEmail())
                .build();
        memberLogHistoryRepository.save(memberLogHistory);
    }
}
