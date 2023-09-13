package com.adacho.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adacho.service.ChangePasswordService;
import com.adacho.service.MemberDao;
import com.adacho.service.MemberInfoPrinter;
import com.adacho.service.MemberListPrinter;
import com.adacho.service.MemberPrinter;
import com.adacho.service.MemberRegisterService;
import com.adacho.service.MemberSummaryPrinter;

@Configuration
public class AppCtx {
   @Bean
   public MemberDao memberDao() {
      return new MemberDao();
   }

   @Bean
   public MemberRegisterService memberRegSvc() {
      return new MemberRegisterService();
   }

//   @Bean
//   public MemberPrinter memberPrinter() {
//      return new MemberPrinter();
//   }

   @Bean
   @Qualifier("printer")
   public MemberPrinter memberPrinter1() {
      return new MemberPrinter();
   }

   @Bean
   @Qualifier("summaryPrinter")
   public MemberPrinter memberPrinter2() {
      return new MemberSummaryPrinter();
   }

   @Bean
   public ChangePasswordService changePwdSvc() {
      ChangePasswordService pwdSvc = new ChangePasswordService();
//      pwdSvc.setMemberDao(memberDao());
      return pwdSvc;
   }

   @Bean
   public MemberPrinter memberPrinter() {
      return new MemberPrinter();
   }

   @Bean
   public MemberListPrinter listPrinter() {
      return new MemberListPrinter();
   }

   @Bean
   public MemberInfoPrinter infoPrinter() {
      MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//      infoPrinter.setMemberDao(memberDao());
//      infoPrinter.setPrinter(memberPrinter());
      return infoPrinter;
   }

   @Bean
   public VersionPrinter versionPrinter() {
      VersionPrinter versionPrinter = new VersionPrinter();
      versionPrinter.setMajorVersion(5);
      versionPrinter.setMinorVersion(0);
      return versionPrinter;
   }

}