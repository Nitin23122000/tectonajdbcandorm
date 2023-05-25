package com.springORM.springORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springORM.Dao.StudentDao;
import com.springORM.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext a= new ClassPathXmlApplicationContext("config2.xml");
    	StudentDao studentDao= (StudentDao) a.getBean("studentDao");
		/*
		 * Student student=new Student(123,"Nitin","Rampura"); int r
		 * =studentDao.insert(student); System.out.println("Done.."+r);
		 */
    	 
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	boolean go=true;
    	while(go) {
    		System.out.println("press 1 for add new Student");
    		System.out.println("press 2 for display all Student");
    		System.out.println("press 3 for get details of single student");
    		System.out.println("press 4 for delete Student");
    		System.out.println("press 5 for update student");
    		System.out.println("press 6 for exit");
    		
    		try {
    			
    			int input = Integer.parseInt(br.readLine());
    			switch (input) {
				case 1:
					//add new Student
					
					System.out.println("Enter user id ");
					int uid = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name : " );
					String uname= br.readLine();
					
					System.out.println("Enter user city :  ");
					String ucity= br.readLine();
					
					Student s=new Student();
					s.setId(uid);
					s.setName(uname);
					s.setCity(ucity);
					
					int r = studentDao.insert(s);
					System.out.println("student added : "+r);
					System.out.println(".................................");
					
					
					break;

				case 2:
					//display all Student
					List<Student> allStudent = studentDao.getAllStudent();
					for (Student st : allStudent) {
						System.out.println("Student Id : "+st.getId());
						System.out.println("Student Name : "+st.getName());
						System.out.println("Student City : "+st.getCity());
						System.out.println("............................");
					}
					break;
				case 3:
					//get details of single student
					System.out.println("Enter user id ");
					int userid = Integer.parseInt(br.readLine());
					
					Student std = studentDao.getsingledata(userid);
					System.out.println("Student ID : "+std.getId());
					System.out.println("Student Name : "+std.getName());
					System.out.println("Student City : "+std.getCity());
					System.out.println("---------------------------------");
					
					
					break;
				case 4:
					//delete student
					System.out.println("delete Student record : ");
					int user = Integer.parseInt(br.readLine());
					
					  studentDao.delete(user);
					  System.out.println("delete successfully");
					
					break;
				case 5:
					//update student
					System.out.println("Enter User Id : ");
					int id = Integer.parseInt(br.readLine());
					
					System.out.println("Enter User name : ");
					String name=br.readLine();
					
					System.out.println("Enter User City : ");
					String city=br.readLine();
					
					Student st =new Student();
					st.setId(id);
					st.setName(name);
					st.setCity(city);
					
					studentDao.update(st);
					System.out.println(" Student Updated Successfully");
					break;
				case 6:
					//exit
					go=false;
					break;
					
					
				default:
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Invalid Input please enter valid Input");
				e.printStackTrace();
			}
    	}
    	System.out.println("Thank you for  coming here");
    	System.out.println("apka din shubh ho!!");
    
    }
}
