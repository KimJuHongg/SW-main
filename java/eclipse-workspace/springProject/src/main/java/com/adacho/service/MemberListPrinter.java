package com.adacho.service;

import java.util.Collection;

import com.adacho.model.Member;

public class MemberListPrinter
{
   private MemberDao memberDao;
   private MemberPrinter printer;
   
   public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
   {
      this.memberDao = memberDao;
      this.printer = printer;
   }
   
   public void printAll()
   {
      Collection<Member> members = memberDao.selectAll();
      members.forEach(m -> printer.print(m));
   }
}