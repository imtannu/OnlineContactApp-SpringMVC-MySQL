package in.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class BaseDAO extends NamedParameterJdbcDaoSupport {
	@Autowired // DataSource object will come from SpringRootConfig java file
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
	}

}
