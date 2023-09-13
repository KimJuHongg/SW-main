package com.adacho.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.adacho.model.Member;

public class MemberDao {

    private static long nextId = 0;

    //이메일 맵
    private Map<String, Member> map = new HashMap();

    //이메일을 통해 Member 객체를 찾음.
    public Member selectByEmail(String email) {
        return map.get(email);
    }

    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        //해당 이메일을 가진 멤버의 내용을 변경(update)
        map.put(member.getEmail(), member);
    }
    
    public Collection<Member> selectAll(){
       return map.values();
    }

}
