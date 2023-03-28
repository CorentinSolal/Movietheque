package com.eni.service;

import com.eni.bo.Member;

public interface ConnectionService {
	Member login(String email, String password);
}
