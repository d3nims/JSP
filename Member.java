package com.sbs.board;

import lombok.Data;

@Data
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String regDate;

}
