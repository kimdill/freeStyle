package com.newlecture.web.aop;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;


public class Program {
	static {
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		
		
		/*NoticeDao noticeDao =new MyBatisNoticeDao(); //진짜
		NoticeDao proxy=(NoticeDao)Proxy.newProxyInstance(
							noticeDao.getClass().getClassLoader(), //진짜
							noticeDao.getClass().getInterfaces(),  //진짜
							new InvocationHandler() {
								
								@Override
								public Object invoke(Object proxy, Method method, Object[] args)
										throws Throwable {
									
									
									System.out.println("사전");
									List<Notice> list=(List<Notice>)method.invoke(noticeDao, args);
									System.out.println("사후");
									
									return list;
								}
							});*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/newlecture/web/aop/spring-context.xml");
		
		NoticeDao noticeDao =(NoticeDao)context.getBean("noticeDao");
		List<Notice> list = noticeDao.getNotices();
		Notice notice = noticeDao.getNotice("5");
		
		for(Notice n:list)
			System.out.printf("제목 : %s\n",n.getTitle());

	}
}
