package com.bank.web.serviceImpls;

import com.bank.web.daoimps.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		dao= new MemberDAOImpl();
	}
	

	@Override
	public void join(MemberBean param) {
		dao.insertCustomer(param);
	}

	@Override
	public MemberBean login(MemberBean param) {
		return dao.login(param);
	}

}
