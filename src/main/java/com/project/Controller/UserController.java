package com.project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Entity.Data;
import com.project.Entity.Post;
import com.project.Repositories.DataRepository;
import com.project.Repositories.PostRepository;

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
		D.setId(count);
		count++;
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
			if(x.getEmail()!=null&&x.getPassword()!=null&&x.getEmail().equals(y.getEmail())==true&&x.getPassword().equals(y.getPassword())==true){model.addAttribute("Data",x);
		
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
		D.setUid(24);
		D.setPid(2);
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
		m.addAttribute("Post",new Post());
		System.out.println("Function");
		return "Like";
	}
	@PostMapping("/Like")
	public String addLike(Model m,@ModelAttribute Post D)
	{
		
		D.setLikes(D.getLikes()+1);
		
		m.addAttribute("Post",new Post());
		System.out.println(D.getLikes());
		repo2.save(D);
		return "Like";
	}
	/*
	@GetMapping("/Like")
	public String Like(Model m)
	{
		m.addAttribute("Post", new Post());
		return "Like";
	}
	@PostMapping("/Like")
	public String Like(Model m,@ModelAttribute Post D)
	{
		D.setLikes(D.getLikes()+1);
		D.setUid(24);
		D.setPid(1);
		
		m.addAttribute("Post",new Post());	
		repo2.save(D);
		return "Like";
	}
	*/
	
}
