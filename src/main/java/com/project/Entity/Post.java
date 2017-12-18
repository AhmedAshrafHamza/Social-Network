package com.project.Entity;
import javax.persistence.*;
@Entity
public class Post {
	private String  Words;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Pid;
	private int Uid;
	private int likes;
	public Post(String words, int pid, int uid,int l) {
		super();
		Words = words;
		Pid = pid;
		Uid = uid;
		likes=l;
		
	}
	public Post()
	{
		Words="";
		Pid=0;
		Uid=0;
		likes=0;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
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
