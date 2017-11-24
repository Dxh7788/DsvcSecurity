package spfr.jdbc.analysis.chap01.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/localhost_jdbc.xml"})
public class JdbcConnectionTest {
	
	@Test
	public void testJdbcConnection(){
		System.out.println("");
	}
}
