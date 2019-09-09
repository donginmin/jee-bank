package com.bank.web.services;

import com.bank.web.domains.MemberBean;

public interface MemberService {
	public void join(MemberBean param);
	public MemberBean login(MemberBean param);
	

}
