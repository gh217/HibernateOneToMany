package controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import model.Information;
import model.Student;


public class Main {

	static SessionFactory factory=new Configuration()
			.configure("Config.xml")
			.addAnnotatedClass(Student.class)
			.addAnnotatedClass(Information.class)
			.buildSessionFactory();
	
	static Session session=factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		session.beginTransaction();
		
//		System.out.println(add());

//		System.out.println(delete());
	
//		Information inf=session.get(Information.class, 29);
		
//		System.out.println(inf.getId()+" "+inf.getPhone());
		get();
//		
//		update();
		session.getTransaction().commit();
		
	}
	
	public static boolean delete() {
		
		int id=9;
				
		Student stuRes=session.get(Student.class, id);
		if(stuRes==null)return false;
		
		
		session.delete(stuRes);
		
		return true;
				
	}
	
	
	public static boolean update() {
			
	try {
			
		    int id=3;
			Student stuRes=session.get(Student.class, id);
		
			stuRes.setName("Mohamed Eid Ghanem");
			
			// refrence
			List<Information> listInfo=stuRes.getListInfo();
			
			System.out.println(stuRes.getId()+" "+stuRes.getName());
			for(Information inf : listInfo) {
				System.out.println(inf.getId()+" "+inf.getPhone());
			}
			
			listInfo.get(0).setPhone("001111111");
			
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
					
	}

	public static void get() {
	
		int id=37;
		Student stuRes=session.get(Student.class, id);
		System.out.println(stuRes.getId()+" "+stuRes.getName());
		
		for(Information stInfo : stuRes.getListInfo() ) {
			System.out.println(stInfo.getId()+" "+stInfo.getPhone());
		}
	}
	
	public static boolean add() {
		try {
			
			Student stu = new Student();
			stu.setName("mohamed eid ghanem");
			
			Information info1 = new Information();
			info1.setPhone("01557035617");
			
			Information info2 = new Information();
			info2.setPhone("01557035617 ");
			
			stu.getListInfo().add(info1);
			stu.getListInfo().add(info2);
			
			
			info1.setStudent(stu);
			info2.setStudent(stu);
			
			session.save(stu);
			
			// if i do not use cascade
//			session.save(info1);
//			session.save(info2);
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
			
		
	}
}
