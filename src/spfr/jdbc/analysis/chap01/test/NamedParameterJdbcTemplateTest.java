package spfr.jdbc.analysis.chap01.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.otk.model.Dor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/localhost_jdbc.xml"})
public class NamedParameterJdbcTemplateTest {
	@Autowired
	DataSource dataSource;
	/**
	 * 命名版的JDBCTemplate使用命名参数
	 * */
	@Test
	public void testNamedParameterJdbcTemplate(){
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(dataSource);
		npjt.query("", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
