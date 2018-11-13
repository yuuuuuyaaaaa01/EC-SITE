package jp.co.rakus.stockmanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ログイン認証用設定.
 * 
 * @author igamasayuki
 *
 */
@Configuration // 設定用のクラス
@EnableWebSecurity // Spring Securityのウェブ用の機能を利用する
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	/**
	 * このメソッドをオーバーライドすることで、認可の設定や
	 * ログインアウトに関する設定ができる.
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() // 認可に関する設定
			.antMatchers("/**").permitAll() //「/」などのパスは全てのユーザに許可
			.anyRequest().authenticated(); // それ以外のパスは認証が必要
	}


 
}
