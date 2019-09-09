package com.bank.web.daos;

import com.bank.web.domains.MemberBean;

public interface MemberDAO {
	public void insertCustomer(MemberBean param);
	public MemberBean login(MemberBean param);

}
