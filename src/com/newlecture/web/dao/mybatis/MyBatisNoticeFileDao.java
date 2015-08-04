package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int addNoticeFile(NoticeFile noticeFile) {

		int result = 0;

		//SqlSession session = factory.openSession();
		try {
			NoticeFileDao dao = session.getMapper(NoticeFileDao.class);

			result = dao.addNoticeFile(noticeFile);
			session.commit();

		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public NoticeFile getNoticeFile(String name) {
		//SqlSession session = factory.openSession();
		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);

		return dao.getNoticeFile(name);
	}
	
	public List<NoticeFile> getNoticeFilesOfNotice(String code){
	/*	
		List<NoticeFile> list = new ArrayList<NoticeFile>();
		NoticeFile file=new NoticeFile();
		file.setName(code+"파일1");
		list.add(file);
		
		file=new NoticeFile();
		file.setName(code+"파일2");
		list.add(file);*/
		
		NoticeFileDao dao = (NoticeFileDao)session.getMapper(NoticeFileDao.class);
		List<NoticeFile> list = dao.getNoticeFilesOfNotice(code); 
		session.close();
		
		return list;
		
	}
}
