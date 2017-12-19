package com.project.Entity;
import javax.persistence.*;
@Entity
public class FriendRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int RequestID;
	public int getRequestID() {
		return RequestID;
	}
	public void setRequestID(int requestID) {
		RequestID = requestID;
	}
	public int getSenderID() {
		return SenderID;
	}
	public void setSenderID(int senderID) {
		SenderID = senderID;
	}
	public int getRecieverID() {
		return RecieverID;
	}
	public void setRecieverID(int recieverID) {
		RecieverID = recieverID;
	}
	public FriendRequest(int requestID, int senderID, int recieverID) {
		super();
		RequestID = requestID;
		SenderID = senderID;
		RecieverID = recieverID;
	}
	public FriendRequest()
	{
		RequestID = 0;
		SenderID = 0;
		RecieverID = 0;
		
	}
	private int SenderID;
	private int RecieverID;

}
