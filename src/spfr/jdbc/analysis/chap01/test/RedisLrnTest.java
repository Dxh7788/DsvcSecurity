package spfr.jdbc.analysis.chap01.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.otk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.SortParameters.Order;
import org.springframework.data.redis.connection.SortParameters.Range;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.query.SortQuery;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/localhost_jdbc.xml"})
public class RedisLrnTest {

	@Autowired
	@Qualifier("template")
	RedisTemplate<String, String> template;
	
	@Autowired
	RedisTemplate<String, User> redisTemplateForUser;
	
	@Test
	public void testList(){
		/**		
		 * pop是取值操作,push是设值的操作
		 * leftPop(key);左弹出
		 * leftPop(key, timeout, unit);
		 * leftPush(key, value);左入栈
		 * leftPush(key, pivot, value);
		 * leftPushAll(key, values);集合values全部左入
		 * leftPushAll(key, values);数组values全部左入
		 * leftPushIfPresent(key, value);如果value不存在则加入,已存在则加入失败
		 * 与之对应的右操作为:
		 * rightPop(key);
		 * rightPop(key, timeout, unit);
		 * rightPush(key, value);
		 * rightPush(key, pivot, value);
		 * rightPushAll(key, values);
		 * rightPushAll(key, values);
		 * rightPushIfPresent(key, value);
		 * 左右协调操作有:
		 * rightPopAndLeftPush(sourceKey, destinationKey)
		 * rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit)
		 * 以上均是插入值的操作
		 * */
		/**
		 * 	template.opsForList().index(key, index);根据索引取值,类似list.get(i)
		 *	template.opsForList().range(key, start, end);取出列表中值,从start到end,start=0,end=-1则取出list中的所有值
		 *	template.opsForList().remove(key, i, value);//底层是redis的lrem操作,从左开始删除i个数量的value值
		 *	template.opsForList().set(key, index, value);//底层是lset操作,索引index处的值设置为value
		 *	template.opsForList().trim(key, start, end);//从左开始取,取start到end的值
		 */
//		template.opsForList().leftPush("localtest_dxh_list_key", "123");
//		template.opsForList().leftPush("localtest_dxh_list_key", "124");
//		template.opsForList().leftPush("localtest_dxh_list_key", "123", "125");
//		System.out.println(template.opsForList().leftPop("localtest_dxh_list_key"));
//		System.out.println(template.opsForList().rightPop("localtest_dxh_list_key"));
		/**
		 * 测试对象的leftPush(key, pivot, value)
		 * */
//		Jackson2JsonRedisSerializer<User> ustr = new Jackson2JsonRedisSerializer<>(User.class);
//		User u = new User(123,"1");
//		String str = new String(ustr.serialize(u));
//		User u1 = new User(125,"2");
//		String str0 = new String(ustr.serialize(u1));
//		
//		User u2 = new User(124,"2");
//		String str1 = new String(ustr.serialize(u2));
//		template.opsForList().leftPush("localtest_dxh_list_key",str,str1);
		User u0 = new User(123,"1");
		User u1 = new User(125,"2");
		User u2 = new User(124,"3");
//		redisTemplateForUser.opsForList().leftPush("localtest_dxh_list_key", u0);
//		redisTemplateForUser.opsForList().leftPush("localtest_dxh_list_key", u2);
		/**
		 * 
		 * */
		List<User> users = redisTemplateForUser.opsForList().range("localtest_dxh_list_key", 0, -1);
		Iterator<User> iter = users.iterator();
		/**while(iter.hasNext()){
			User u = iter.next();
			if(u.getId().equals("1")){
				//redisTemplateForUser.opsForList().leftPushIfPresent("localtest_dxh_list_key", value)
			}
		}*/
		/**
		 * Redis回调
		 * new RedisCallback<T>使用指定的Connection执行指定的redis命令,最好不要使用RedisCallback来执行事务,执行者的异常会返回给调用者,然后传给上层的DAO,可以反悔domain 实体或者集合实体,
		 * 因为会自动执行实例化或者反实例化.注意：并不建议使用Callback来操作事务,也不要调用connection的生命周期方法,比如close
		 * */
		redisTemplateForUser.opsForList().getOperations().exec();
		redisTemplateForUser.opsForList().getOperations().execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection) throws DataAccessException {
				return null;
			}
		});
		/**
		 * 执行Redis 回话,开启事务通过multi()或者watch(),如果要是用事务最好使用SessionCallback
		 * */
		redisTemplateForUser.opsForList().getOperations().execute(new SessionCallback<User>(){

			@Override
			public User execute(RedisOperations operations) throws DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		redisTemplateForUser.opsForList().getOperations().exec(new RedisSerializer<User>() {
			@Override
			public byte[] serialize(User t) throws SerializationException {
				return null;
			}
			
			@Override
			public User deserialize(byte[] bytes) throws SerializationException {
				return null;
			}
		});
	}
	
	@Test
	public void testHash(){
		HashOperations ho = template.opsForHash();
		/**
		 * Hash的数值操作
		 * ho.put(key, hashKey, value);
		 * ho.putAll(key, m);
		 * ho.putIfAbsent(key, hashKey, value);
		 * 总的来说Map有的常用操作Spring的RedisTemplate都按惯用方式封装
		 * ho.entries(key);Map的键值Set集合
		 * ho.values(key);Map的所有values
		 * ho.keys(key);Map的所有keys
		 * ****
		 * ho.get(key, hashKey);
		 * ho.multiGet(key, hashKeys);获取多个键值的值
		 **/
		/**
		 * 暂时不研究ScanOptions,留中 
		 * ScanOptions so = new ScanOptionsBuilder().build();
		 * ho.scan("123", so);
		 */
		
		
		
		
		
		
		
		/**=============================================
		 * 看一下Hash的Operations
		 * =========================================
		 * 留一个起子,template.execute(action)和template.opsForHash().getOperations().execute(action)的区别
		 * */
//		ho.getOperations().executePipelined(session);
		template.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				return null;
			}
		});
		template.opsForHash().getOperations().execute(new RedisCallback<Object>(){
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				return null;
			}
		});
		
		SortQueryBuilder builder = SortQueryBuilder.sort("localtest_dxh_hash_key");
//		builder.get(getPattern)
		template.opsForHash().getOperations().boundHashOps("localtest_dxh_hash_key");
	}
	
	/**
	 * @Test
	public void testLuaScript(){
		List<String> keys = new ArrayList<String>(0);
		keys.add("localtest_dxh_hash_key");
		keys.add("localtest_dxh_list_key");
		
		template.execute(new RedisScript<User>() {
			@Override
			public String getSha1() {
				return null;
			}
			@Override
			public Class<User> getResultType() {
				return null;
			}
			@Override
			public String getScriptAsString() {
				return null;
			}},keys,"123","123");
	}
	*/
	
}
