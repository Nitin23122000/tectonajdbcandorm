package com.springJDBC.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springJDBCdao.Studentdao;
import com.springJDBCentity.pojo;

/**
 * Hello world!
 *
 */
public class App 
{
  

	public static void main( String[] args )
    {
    	
    	ApplicationContext a=new ClassPathXmlApplicationContext("com/springJDBC/springJDBC/config.xml");


    	 Studentdao studentdao=(Studentdao)a.getBean("stdao");
			/*
			 * pojo pp=new pojo(); pp.setId(12); pp.setName("nitin");
			 * pp.setCity("ahmedabad"); int r=studentdao.insert(pp);
			 * System.out.println("added successfully..."+r);
			 */
			/*
			 * pojo p2=new pojo(); p2.setId(12); p2.setName("amrit");
			 * p2.setCity("sindrath"); int res = studentdao.change(p2);
			 * System.out.println("changed successfully...."+res);
			 */
    	 
    	 int result = studentdao.delete(12);
    	 System.out.println("delete..."+result);
    	 
    	
    }
}
