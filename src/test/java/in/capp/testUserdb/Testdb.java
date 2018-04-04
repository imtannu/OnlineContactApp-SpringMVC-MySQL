package in.capp.testUserdb;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import in.capp.config.SpringRootConfig;

public class Testdb {

	public static void main(String[] args) {
		ApplicationContext apx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource dt = apx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(dt);
		String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] {"Tannu","8483813344","tanveers330@gmail.com","Shrirampur","Imtannu","tannu"};
		jt.update(sql, param);
		System.out.println("SQL Excecuted...");

	}

}
