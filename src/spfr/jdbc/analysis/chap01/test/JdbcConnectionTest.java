package spfr.jdbc.analysis.chap01.test;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/localhost_jdbc.xml"})
public class JdbcConnectionTest {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testJdbcConnection(){
		//插入数据
		/***
		 * 操作数据的方式
		 * 1.JdbcTemplate
		 * 2.NamedParameterJdbcTemplate
		 * 3.SimpleJdbcInsert 和  SimpleJdbcCall 
		 * 4.MappingSqlQuery, SqlUpdate and StoredProcedure
		 * 层级由低到高
		 */
		/***
		 * JdbcTemplate方式
		 * 占位参数的设置方式
		 */
		String sql = "insert into dor(id,name,title) values (?,?,?)";
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update(sql,"1","123","123");
		/***
		 * NamedParameterJdbcTemplate使用:name命名
		 * 命名参数的操作方式
		 */
		NamedParameterJdbcTemplate njt = new NamedParameterJdbcTemplate(dataSource);
		String nameSql = "insert into dor(id,name,title) values (:id,:name,:title)";
		Map<String ,Object> paramMap =new HashMap<String,Object>();
		paramMap.put("id", "2");
		paramMap.put("name", "124");
		paramMap.put("title", "124");
		njt.update(nameSql, paramMap);
		/**
		 * SimpleJdbcInsert 和  SimpleJdbcCall
		 * 1.SimpleJdbcInsert
		 * */
		SimpleJdbcInsert sji = new SimpleJdbcInsert(dataSource);
	}
}
