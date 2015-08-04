package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.NoticeFile;

public interface NoticeFileDao {

	
	public int addNoticeFile(NoticeFile noticeFile);
	
	public NoticeFile getNoticeFile(String noticeCode);
	public List<NoticeFile> getNoticeFilesOfNotice(String code);
}
