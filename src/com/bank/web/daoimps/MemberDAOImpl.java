package com.bank.web.daoimps;

import com.bank.web.pool.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.MemberBean;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insertCustomer(MemberBean param) {

		try {
			File file = new File(Constants.FILE_PATH + "customers0905.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s,%s,%s", param.getId(), param.getPw(), param.getName(), param.getSsn(),
					param.getCredit()));
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public MemberBean login(MemberBean param) {
		MemberBean m = null;
		try {
			File file = new File(Constants.FILE_PATH + "customers0905.txt");
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String[] user = reader.readLine().split(",");
			if (user[0].equals(param.getId()) && user[1].equals(param.getPw())) {
				m = new MemberBean();
				m.setId(user[0]);
				m.setPw(user[1]);
				m.setName(user[2]);
				m.setSsn(user[3]);
				m.setCredit(user[4]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

}
