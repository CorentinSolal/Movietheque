package com.eni.service.mock;

import com.eni.bo.Member;
import com.eni.service.ConnectionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionServiceMock implements ConnectionService {
	//Liste des membres
	private static List<Member> lstMembers;
	
	public ConnectionServiceMock() {
		//initialisation de la liste
		lstMembers= new ArrayList<>();
		lstMembers.add(new Member(1, "admin", "admin", "admin", "admin", true));

	}

	@Override
	public Member login(String email, String password) {
		if(email != null && password != null) {
			for (Member member : lstMembers) {
				if(member.getLogin().equals(email) && member.getPassword().equals(password)) {
					return member;
				}
			}
		}
		return null;
	}

}
