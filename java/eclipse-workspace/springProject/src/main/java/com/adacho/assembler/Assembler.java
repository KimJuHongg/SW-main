package com.adacho.assembler;

import com.adacho.service.ChangePasswordService;
import com.adacho.service.MemberDao;
import com.adacho.service.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}	

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}

	
}
