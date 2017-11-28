package spfr.jdbc.analysis.chap01.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.otk.model.Dor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/localhost_jdbc.xml"})
public class JdbcConnectionTest {
	
	@Autowired
	DataSource dataSource;
	
	/*@Test
	public void testJdbcConnection(){
		//插入数据
		*//***
		 * 操作数据的方式
		 * 1.JdbcTemplate
		 * 2.NamedParameterJdbcTemplate
		 * 3.SimpleJdbcInsert 和  SimpleJdbcCall 
		 * 4.MappingSqlQuery, SqlUpdate and StoredProcedure
		 * 层级由低到高
		 *//*
		*//***
		 * JdbcTemplate方式
		 * 占位参数的设置方式
		 *//*
		String sql = "insert into dor(id,name,title) values (?,?,?)";
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update(sql,"1","123","123");
		*//***
		 * NamedParameterJdbcTemplate使用:name命名
		 * 命名参数的操作方式
		 *//*
		NamedParameterJdbcTemplate njt = new NamedParameterJdbcTemplate(dataSource);
		String nameSql = "insert into dor(id,name,title) values (:id,:name,:title)";
		Map<String ,Object> paramMap =new HashMap<String,Object>();
		paramMap.put("id", "2");
		paramMap.put("name", "124");
		paramMap.put("title", "124");
		njt.update(nameSql, paramMap);
		*//**
		 * SimpleJdbcInsert 和  SimpleJdbcCall
		 * 1.SimpleJdbcInsert
		 * *//*
		SimpleJdbcInsert sji = new SimpleJdbcInsert(dataSource);
	}*/
	/**
	 * JDBCTemplate完整测试
	 * JDBCTemplate参数
	 * 1:DataSource,数据源配置,必配
	 * 2.lazyInit,懒初始化,懒加载
	 * 3.nativeJdbcExtractor,有时候，你需要访问特定于供应商的JDBC方法不同于标准JDBC API.这可能会出现问题,如果你正在运行一个应用程序服务器或一个DataSource包装的连接,
	 * 				 Statement和ResultSet对象与自己的包装对象。要获得本地对象，你可以配置你JdbcTemplate或OracleLobHandler的一个NativeJdbcExtractor。
	 * 4.ignoreWarnings,如果为true提示所有异常信息,如果为false则抛SqlException异常
	 * 5.fetchSize.  设置每次取多少行.如果不设置默认会取查询的全部数据,很容易造成内存不足.fetchSize设置后,每次取这样大小的数据量,循环取完,有效防止内存不足,Mysql需要特殊的设置来支持该参数设定,一般
	 * 				   不需要设置,因为默认最优的.如果会出现内存不足的情况,再去设置该参数.
	 * 6.maxRows.    查询结果的最大条数,超出的部分直接丢弃.
	 * 7.queryTimeout queryTimeout如果设置为非负数值,则代表查询超时时间
	 * 8.skipResultsProcessing 如果设置该参数为true,则任何回调进程的结果检查就会跳过,这个参数可以用来避免JDBC驱动器的bug,比如Oracle 的10.1.0.2版本
	 * 9.skipUndeclaredResults 如果该变量为true,那么有输出参数的存储过程的调用结果检查将被省略，除非skipResultsProcessing为true，否侧其他返回结果都将被处理。默认为false
	 * 10.resultsMapCaseInsensitive 如果该参数设置为true,那么回调执行的结果会以参数大小写不敏感的名称Map返回
	 * */
	@Test
	public void testJDBCTemplate(){
		String sql="insert into dor(id,name,title) values (?,?,?)";
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		/**
		 * 回调分四个类型,7个方法
		 * 1.ConnectionCallback连接回调,	execute(ConnectionCallback<T> action)
		 * 2.Statement回调,	execute(StatementCallback<T> action)
		 * 					execute(final String sql)
		 * 3.PrepareStatement回调	execute(String sql, PreparedStatementCallback<T> action)
		 * 						execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action)
		 * 4.CallableStatementCallback存储过程回调,	execute(CallableStatementCreator csc, CallableStatementCallback<T> action)
		 * 										execute(String callString, CallableStatementCallback<T> action)
		 * */
		
		
		/**
		 * JDBCTemplate的Query:
		 * query,
		 * queryForObject,
		 * queryForList,
		 * queryForMap,
		 * queryForRowSet,
		 * */
		/**
		 * query(sql,new RowMapper<Dor>)查询
		 * */
		String sql2 = "select * from dor";
		List<Dor> dors0 = jt.query(sql2,new RowMapper<Dor>() {
			@Override
			public Dor mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		});
		for(Dor dor:dors0){
			System.out.println("query(sql,new RowMapper<Dor>)查询"+dor);
		}
		/**
		 * query(new PreparedStatementCreator(),new RowMapper<Dor>)查询
		 * */
		List<Dor> dors1 = jt.query(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql2);
				return ps;
			}
		},new RowMapper<Dor>() {
			@Override
			public Dor mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		});
		for(Dor dor:dors1){
			System.out.println("query(new PreparedStatementCreator(),new RowMapper<Dor>)查询"+dor);
		}
		/**
		 * 条件查询jt.query(sql2, new ResultSetExtractor<Dor>()
		 * */
		Dor dor0 = jt.query(sql2, new ResultSetExtractor<Dor>() {
			@Override
			public Dor extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
					if(rs.getString(1).equals("2")){
						return new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
					}
				}
				return null;
			}
		});
		System.out.println(dor0);
		/**
		 * jt.query(new PreparedStatementCreator(),new ResultSetExtractor<Dor>())
		 * */
		Dor dor1 = jt.query(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps =con.prepareStatement(sql2);
				return ps;
			}
			
		}, new ResultSetExtractor<Dor>() {

			@Override
			public Dor extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
					if(rs.getString(1).equals("1")){
						return new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
					}
				}
				return null;
			}
		});
		System.out.println(dor1);
//		/**
//		 * 
//		 * */
//		jt.query(sql2, new Object[]{"4","125","125"},new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR}, new ResultSetExtractor<Dor>(){
//			@Override
//			public Dor extractData(ResultSet rs) throws SQLException, DataAccessException {
//				return null;
//			}
//			
//		});
		/**
		 * 
		 * */
		List<Dor> dors3 = new ArrayList<Dor>(0);
		/**
		 * 连接关闭,导致错误
		 * jt.query(sql2,new RowCallbackHandler()
		 * */
		jt.query(sql2,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Dor dor = new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
				dors3.add(dor);
			}
		});
		for(Dor dor:dors3){
			System.out.println("query(sql2,new RowCallbackHandler()"+dor);
		}
		/**
		 * 剩余的Query基本上都是要调用RowCallbackHandler,RowMapper,PreparedStatementCreator,或者sql执行不再赘述
		 * 说一下其他的queryForXXX,比如queryForObject
		 * */
		/**
		 * jt.queryForObject(String sql, Class<T> requiredType)只支持基本数据类型和基本数据类型的封装类型
		 * */
		String sql4 = "select count(*) from dor";
		Integer dorcnt0 = jt.queryForObject(sql4, Integer.class);
		System.out.println(dorcnt0);
		/**
		 * jt.queryForObject(String sql, Class<T> requiredType)只支持基本数据类型和基本数据类型的封装类型
		 * */
		Dor dor4 = jt.queryForObject(sql2, new RowMapper<Dor>(){

			@Override
			public Dor mapRow(ResultSet rs, int rowNum) throws SQLException {
				while(rs.next()){
					if(rs.getString(1).equals("3")){
						return new Dor(rs.getString(1),rs.getString(2),rs.getString(3));
					}
				}
				return null;
			}
			
		});
		System.out.println("jt.queryForObject(String sql, Class<T> requiredType):"+dor4);
		/**
		 * queryForObject(String sql, Class<T> requiredType, Object... args)查询
		 * queryForObject(String sql, Object[] args, Class<T> requiredType)和queryForObject(String sql, Class<T> requiredType, Object... args)是一样的
		 * */
		String sql5 = "select count(*) from dor where id =?";
		Integer dorcnt1 = jt.queryForObject(sql5, Integer.class, new Object[]{"2"});
		System.out.println("jt.queryForObject(String sql, Class<T> requiredType):  "+dorcnt1);
		/**
		 * queryForObject(String sql, Object[] args, RowMapper<T> rowMapper)和queryForObject(String sql, RowMapper<T> rowMapper, Object... args)查询方式一致
		 * */
		String sql6 = "select distinct * from dor where id =?";
		Dor dor5 = jt.queryForObject(sql6, new Object[]{"1"}, new RowMapper<Dor>(){

			@Override
			public Dor mapRow(ResultSet rs, int rowNum) throws SQLException {
				while(rs.next()){
					System.out.println( new Dor(rs.getString(1),rs.getString(2),rs.getString(3)));
				}
				return null;
			}
			
		});
		System.out.println(dor5);
		/**
		 * queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)用于映射自定义类
		 * queryForObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType)用于基本类型和基本类型包装类,如Integer.class和int.class
		 * queryForObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType)的底层调用是queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)
		 * 将rowMapper封装成getSingleColumnRowMapper
		 * */
		
		/**
		 * queryForList(String sql)查询一个结果列表
		 * 同理,queryForList(String sql,Object ...)
		 * */
		List<Map<String,Object>>jmap0= jt.queryForList(sql2);
		for(Map<String,Object> map:jmap0){
			Set<Entry<String, Object>> jmaps = map.entrySet();
			for(Entry<String, Object> jmap:jmaps){
				System.out.println("key:"+jmap.getKey()+",  value:"+jmap.getValue());
			}
		}
		/**
		 * queryForList(String sql, Class<T> elementType);基本类型查询
		 * queryForList(String sql, Class<T> elementType,Object ...)
		 * queryForList(String sql, RowMapper<T> rowMapper);自定义类型映射查询
		 * 其余不再赘述
		 * */
		jt.queryForList(sql6, Integer.class);
		/**
		 * queryForMap主要有三个
		 * queryForMap(String sql,Object ...,int[] argtypes)
		 * queryForMap(String sql,)
		 * */
	}
	
	@Autowired
	@Qualifier("template")
	RedisTemplate<String, String> template;
	@Test
	public void testJRedisConnection(){
		template.opsForValue().set("kkk__k","123");
	}
}
