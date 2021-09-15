package com.bitcamp.lecture.comm;

import java.util.ArrayList;
import java.util.List;

public class Notice {
	
	public static List <Notice> list = new ArrayList<>();
	
	//필드
	private int id = 0;
	private String title = null;
	private String writer_id = null;
	private String text = null;
	private String regDate = null;
	private int hit = 0;
	private String files = null;
	
	//생성자
	public Notice() {
		
	}
	
	public Notice(int id, String title, String writer_id, String text, String regDate, int hit, String files) {
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.text = text;
		this.regDate = regDate;
		this.hit = hit;
		this.files = files;
	}

	

	//메서드
	public static List<Notice> getList() {
		return list;
	}

	public static void setList(List<Notice> list) {
		Notice.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	
	
}
