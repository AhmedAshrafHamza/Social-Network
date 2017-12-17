package com.project.Entity;
import javax.persistence.*;
@Entity
public class Post {
	private String  Words;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Pid;
	private int Uid;
	public Post(String words, int pid, int uid) {
		super();
		Words = words;
		Pid = pid;
		Uid = uid;
	}
	public Post()
	{
		Words="";
		Pid=0;
		Uid=0;
	}
	public String getWords() {
		return Words;
	}
	public void setWords(String words) {
		Words = words;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	

}
