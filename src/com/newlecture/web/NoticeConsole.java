package com.newlecture.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.vo.Notice;

 
public class NoticeConsole {
	
	NoticeDao noticedao;
	
	@Autowired
	@Resource(name="noticeDao")
	public void setNoticeDao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}


	public void print(){
		
		
		List<Notice> list=noticedao.getNotices();
		
		for(Notice n : list)
			System.out.printf("title: %s\n", n.getTitle());

	}

}

