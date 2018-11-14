package jp.co.rakus.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.repository.MemberRepository;

@Service
public class MemberService {
		
	@Autowired
	private MemberRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	//メールの重複をDB経由で確認する。
	public Member findByEmail(String mailAddress) {
		return repository.findbyEmail(mailAddress);
	}
	
	//新規登録
	public Member save(Member member) {
		return repository.save(member);
	}
	
	//パスワードの暗号化
	//rowPassword 平文のパスワード
	public String encodePassword(String rowPassword) {
		String encodedPassword = passwordEncoder.encode(rowPassword);
		return encodedPassword;
	}
	
	//平文のパスワードと暗号化されたパスワードを比較。あっていればtrueを返す。
	public boolean isMatchPassword(String rowPassword, String encodedPassword) {
	return passwordEncoder.matches(rowPassword, encodedPassword);
	}
	
	
	
}
