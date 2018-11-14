package jp.co.rakus.stockmanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.stockmanagement.domain.Member;

@Repository
public class MemberRepository {
	
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	//1行ずつ入ってくるので、行単位で処理する。
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs,i) ->{
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String mailAddress = rs.getString("mail_address");
		String password = rs.getString("password");
		
		return new Member(id,name,password,mailAddress);
	}; 
	
	

	
	
	/**
	 * memberの新規登録と更新.
	 * 
	 * @param member
	 * @return
	 */
	public Member save(Member member) {
		//自動でプロパティをセットしてくれる。
		SqlParameterSource param = new BeanPropertySqlParameterSource(member);
		
		if(member.getId() == null) {
			String sql = "insert into members(name,password,mail_address) values(:name,:password,:mailAddress)";
			template.update(sql,param);
			return member;
		}else {
			String sql = "update members set (:name,:password,:mailAddress)";
			template.update(sql,param);
			return member;
		}
	}
	
	public Member findbyEmail(String mailAddress) {
		String sql = "select id,name,password,mail_address from members where mail_address=:mailAddress;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress",mailAddress);
		
		//　list が　空だったら mail の重複はない。
		List<Member> members = template.query(sql,param,MEMBER_ROW_MAPPER);
		
		if( members.isEmpty() ) {
			return null;
		}
		
		//1つのみ返却されるので、0をとって memberとして返却する。
		return members.get(0);	
	}
	
	
	
	
	
	
	
	
}
