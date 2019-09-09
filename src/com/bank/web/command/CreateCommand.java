package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.MemberBean;
import com.bank.web.serviceImpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{
	public CreateCommand(HttpServletRequest request) throws Exception {
		super(request);
	}
	@Override
	public void execute() {
		super.execute();
		MemberBean param = new MemberBean();
		MemberService service = new MemberServiceImpl();
		param.setCredit(request.getParameter("credit"));
		param.setId(request.getParameter("id"));
		param.setName(request.getParameter("name"));
		param.setPw(request.getParameter("pw"));
		param.setSsn(request.getParameter("ssn"));
		System.out.println("ȸ������: "+param.toString());
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("ȸ������ �� �� ������: "+Receiver.cmd.getView());
	}
}