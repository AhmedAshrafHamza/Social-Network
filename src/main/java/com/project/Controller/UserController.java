package com.project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.project.Entity.FriendRequest;
import com.project.Entity.Data;
import com.project.Entity.Friend;
import com.project.Entity.Post;
import com.project.Repositories.DataRepository;
import com.project.Repositories.FriendList;
import com.project.Repositories.PostRepository;
import com.project.Repositories.FriendRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;



@Controller
public class UserController {
	public int  count=25;
	public Data t;
	@Autowired
	private DataRepository repo;
	@Autowired
	private PostRepository repo2;
	@Autowired
	private FriendRepository repo3;
	@Autowired
	private FriendList repo4;
	
	
	@GetMapping("/addUser2")
	public String shpowUser(Model model)
	{
		model.addAttribute("Data",new Data());
		return"addUser2";
	}
	@PostMapping("/addUser2")
	public String addUser(Model m,@ModelAttribute Data D)
	{
		System.out.println(D.getName());
		System.out.println(D.getPassword());
		Iterable<Data> Iterable = repo.findAll();
		
		int c=1;
		for(Data student : Iterable){
			c++;
		}
		D.setId(c+1);
		repo.save(D);
		m.addAttribute("Data", new Data());
		return "addUser2";
	}
	
	
	@GetMapping("/showAllStudents")
	public String showAllStudents(Model model,Data y){
		Iterable<Data> studentsIterable = repo.findAll();
		List<Data> studentsList = new ArrayList<Data>();
		for(Data student : studentsIterable){
			studentsList.add(student);
		}
		System.out.println(y.getEmail());
		
		y.setEmail(t.getEmail());
		y.setPassword(t.getPassword());
		for(int i=0;i<studentsList.size();i++)
		{
			Data x=studentsList.get(i);
			System.out.println(x.getName());
			if(x.getEmail()!=null&&x.getPassword()!=null&&x.getEmail().equals(y.getEmail())==true&&x.getPassword().equals(y.getPassword())==true){t.setId(x.getId());model.addAttribute("Data",x);
		
			return "Accept";}
		};
		model.addAttribute("Data",studentsList);
		
		return "Accept";
	}
	@GetMapping("/showAll")
	public String shpowAll(Model model)
	{
		model.addAttribute("Data",new Data());
		
		return"addUser";
	}
	@GetMapping("/Signin")
	public String  Signin(Model model)
	{
		model.addAttribute("Data", new Data());
		return "Signin";
	}
	@PostMapping("/Signin")
	public String  Signin(Model m,@ModelAttribute Data D)
	{
		
		
		System.out.println(D.getEmail());
		m.addAttribute("Data",new Data());
		t=D;
		showAllStudents(m,D);
		/*
		if(D.getEmail()!=null&&D.getPassword()!=null)
		{
		t.setEmail(D.getEmail());
		t.setPassword(D.getPassword());
		return "Signin";
		}*/
		
		return "Accept";
	}
	@GetMapping("/CreatePost")
	public String  Cpost(Model model)
	{
		model.addAttribute("Post", new Post());
		return "CreatePost";
	}
	@PostMapping("/CreatePost")
	public String  Cpost(Model m,@ModelAttribute Post D)
	{
		
		System.out.println(t.getEmail());
		System.out.println(t.getId());
		m.addAttribute("Post",new Post());		
		D.setUid(t.getId());
		Iterable<Post> Iterable = repo2.findAll();
		int c=1;
		for(Post student : Iterable){
			if(student.getUid()==t.getId())c++;
		}
		D.setPid(c+1);
		
		repo2.save(D);
		
		/*
		if(D.getEmail()!=null&&D.getPassword()!=null)
		{
		t.setEmail(D.getEmail());
		t.setPassword(D.getPassword());
		return "Signin";
		}*/
		
		return "CreatePost";	
	}
	@PostMapping("/sendFriendRequest")
	public String  SFR(Model m,@ModelAttribute FriendRequest D)
	{
		
		System.out.println(t.getEmail());
		System.out.println(t.getId());
		m.addAttribute("FriendRequest",new FriendRequest());		
		D.setSenderID(t.getId());
		Iterable<FriendRequest> Iterable = repo3.findAll();
		int c=1;
		for(FriendRequest student : Iterable){
			if(student.getSenderID()==t.getId())c++;
		}
		D.setRequestID(c+1);
		
		repo3.save(D);
	
		
		return "SendFriendRequest";	
	}
	@GetMapping("/sendFriendRequest")
	public String  SFR(Model m)
	{
		m.addAttribute("FriendRequest",new FriendRequest());
		return"sendFriendRequest";
	}
	
	@GetMapping("/showPosts")
	public String GetPosts (Model m)
	{
		Iterable<Post> Iterable = repo2.findAll();
		List<Post> List = new ArrayList<Post>();
		for(Post student : Iterable){
			List.add(student);
		}
		List<Post>itr=new ArrayList<Post>();
		for(int i=0;i<List.size();i++)
		{
			Post x=List.get(i);
		
			if(x.getUid()!=0&&x.getPid()!=0&&x.getWords()!=null){itr.add(x);}
		};
		 	
		m.addAttribute("Post",itr);
	return"showPosts";
	}
	
	@GetMapping("/Like")
	public String addLike(Model m)
	{
		Iterable<Post> Iterable = repo2.findAll();
		List<Post> List = new ArrayList<Post>();
		for(Post student : Iterable){
			List.add(student);
		}
		List<Post>itr=new ArrayList<Post>();
		for(int i=0;i<List.size();i++)
		{
			Post x=List.get(i);
		
			if(x.getUid()!=0&&x.getPid()!=0&&x.getWords()!=null){itr.add(x);}
		};
		 	
		m.addAttribute("Post",itr);
		System.out.println("Function");
		return "Like";
	}
	@PostMapping("/Like")
	public String addLike(Model m,@ModelAttribute Post D)
	{
		System.out.println(D.getUid());
		/*
		System.out.println(D.getUid());
		D.setLikes(D.getLikes()+1);*/
		/*
		m.addAttribute("Post",new Post());
		System.out.println(D.getLikes());
		repo2.save(D);*/
		return "Like";
	}
	
	
	@GetMapping("/ShowFriendRequest")
	public String showFriendRequest(Model model)
	{
		
		Iterable<FriendRequest> Iterable = repo3.findAll();
		List<FriendRequest> List = new ArrayList<FriendRequest>();
		for(FriendRequest student : Iterable){
			List.add(student);
		}
		List<FriendRequest>itr=new ArrayList<FriendRequest>();
		for(int i=0;i<List.size();i++)
		{
			FriendRequest x=List.get(i);
		
			if(x.getRecieverID()!=0&&x.getRequestID()!=0&&x.getSenderID()!=0&&x.getRecieverID()==t.getId()){itr.add(x);}
		};
		 	
		
		model.addAttribute("FriendRequest",itr);
		return"ShowFriendRequest";
	}
	
	@PostMapping("/ShowFriendRequest")
	public String sendFriendRequest(Model model,@ModelAttribute FriendRequest fr)
	{
		
		System.out.println(t.getEmail());
		System.out.println(t.getId());
		model.addAttribute("FriendRequest",new FriendRequest());		
		fr.setSenderID(t.getId());
		Iterable<FriendRequest> Iterable = repo3.findAll();
		int c=1;
		
		for(FriendRequest student : Iterable){
			if(student.getSenderID()==t.getId())c++;
		}
		fr.setRequestID(c+1);
		model.addAttribute("FriendRequest", fr);
		repo3.save(fr);
		return"ShowFriendRequest";
	}
	
	@GetMapping("/Friend")
	public String ShowFriend(Model m)
	{
		Iterable<Friend> Iterable = repo4.findAll();
		List<Friend> List = new ArrayList<Friend>();
		for(Friend student : Iterable){
			List.add(student);
		}
		List<Friend>itr=new ArrayList<Friend>();
		for(int i=0;i<List.size();i++)
		{
			Friend x=List.get(i);
			if(x.getFriends()!=0&&x.getFriendID()!=0&&x.getUserID()!=0&&x.getUserID()==t.getId()){itr.add(x);}
		};
		 	
		
		m.addAttribute("Friend",itr);
		return "Friend";
	}
	
	
	@PostMapping("/AcceptFriendRequest")
	public String AFR(Model m,@ModelAttribute Friend D)
	{
		
		
		System.out.println(t.getEmail());
		System.out.println(t.getId());
		m.addAttribute("Friend",new Friend());		
		D.setUserID(t.getId());
		Iterable<Friend> Iterable = repo4.findAll();
		int c=1;
		for(Friend student : Iterable){
			c++;
			
		}
		D.setFriends(c+1);
		
		repo4.save(D);
		
		return "AcceptFriendRequest";
	}
	
	@GetMapping("/AcceptFriendRequest")
	public String  AFR(Model m)
	{
		m.addAttribute("Friend",new Friend());
		return"AcceptFriendRequest";
	}
	/*
	@PostMapping("/Like")
	public String Like(Model m,@ModelAttribute Post D)
	{
		D.setLikes(D.getLikes()+1);
		m.addAttribute("Post",new Post());	
		repo2.save(D);
		return "Like";
	}
	*/
	
}
