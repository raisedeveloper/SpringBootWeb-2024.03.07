package com.example.abbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aside")
public class AsideController {
		
	@GetMapping("/stateMsg")
	public String chagestateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMsg", stateMsg);
		return "1"; 		// ""  이 부분에 수정 된 값이 html 이 아니라 data 를 보낼 것 == responsebody data를 바로 보냄
	}
}
