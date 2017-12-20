package com.project.Entity;
import javax.persistence.*;
@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Friends;
	public Friend(int friends, int userID, int friedID) {
		super();
		Friends = friends;
		UserID = userID;
		FriendID = friedID;
	}
	public Friend() {
		
		Friends = 0;
		UserID = 0;
		FriendID = 0;
	}
	private int UserID;
	public int getFriends() {
		return Friends;
	}
	public void setFriends(int friends) {
		Friends = friends;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getFriendID() {
		return FriendID;
	}
	public void setFriendID(int friendID) {
		FriendID = friendID;
	}
	private int FriendID;

}
