package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.service.IExamService;
@Controller
public class ExamController {
	private IExamService examService;
@Autowired
	public void setExamService(IExamService examService) {
		this.examService = examService;
	}
int i=0;
int score=0;
int l=1;
	@RequestMapping(value="/fetch",method=RequestMethod.GET)
	public String DisplayDashboard(Model model) {
	
		return "Studentdashboard" ;
	}
///Java
	@RequestMapping(value="/fetchjava",method=RequestMethod.GET)
	public String DisplayJava(Model model) {
		model.addAttribute("exam", new Exam());
		return "instruction" ;
	}
	@RequestMapping(value = "/fetchjavaques")
	public String Fetchjavaquestion(@ModelAttribute ("exam")
	@Valid Exam e,Model model,HttpSession session) {
	 l=1;
			List<Question> list1=this.examService.fetchAlljavaQuestion(l);
			while(i < list1.size() ){
				session.setAttribute("ques",list1.get(i));
					
					i++;
					return "viewpaper";
		}
			return "result";
	    }
	int i1=0;
	@RequestMapping(value = "/fetchjava2")
	public String Fetchjava2(@ModelAttribute ("exam")
	@Valid Exam e,Model model,HttpSession session) {
		int s=(Integer) session.getAttribute("s1");
		System.out.println(s);
        if(s<=3){
        int l2=2;
	List<Question> li=this.examService.fetchAlljavaQuestion(l2);
	System.out.println(li);
	while(i1 <= li.size() ){
		System.out.println(i);
		session.setAttribute("ques",li.get(i1));
		System.out.println("44");
			i1++;
			return "viewpaper";
			} 
	return "result";
	}	
      int i2=0;
	 if(s>=4)
	{ 
	       l=3;
		List<Question> list=this.examService.fetchAlljavaQuestion(l);
		while(i2 <= list.size() ){
			System.out.println(i2);
			session.setAttribute("ques",list.get(i2));
			System.out.println("44");
				i2++;
				return "viewpaper";
	}
		return "result";
	}
	return "result";
	}
	
		
////html question
	@RequestMapping(value="/fetchhtml")
	public String Displayhtml(Model model) {
		return "instruction1" ;
	}
	@RequestMapping(value="/fetchhtmlques",method =RequestMethod.GET)
	  public String fetchhtmlquestion(@ModelAttribute("exam")Exam e,HttpSession session) {
		 l=1;
			List<Question> list1=this.examService.fetchAllhtmlQuestion(l);
			while(i < list1.size() ){
				session.setAttribute("ques",list1.get(i));
					i++;
					return "viewpaper";
		}
			return "result";}
	int i3=0;
	@RequestMapping(value = "/fetchhtml2")
	public String Fetchhtml2(Model model,HttpSession session) {
		int s=(Integer) session.getAttribute("s1");
		System.out.println(s);
        if(s<=3){
        int l2=2;
	List<Question> li=this.examService.fetchAllhtmlQuestion(l2);
	System.out.println(li);
	while(i3 <= li.size() ){
		System.out.println(i3);
		session.setAttribute("ques",li.get(i3));
			i3++;
			return "viewpaper";
			} 
	return "result";
	}	
      int i2=0;
	 if(s>=4)
	{ 
	       l=3;
		List<Question> list=this.examService.fetchAllhtmlQuestion(l);
		while(i2 <= list.size() ){
			System.out.println(list);
			session.setAttribute("ques",list.get(i2));
			System.out.println("44");
				i2++;
				return "viewpaper";
	}
		return "result";
	}
	return "result";
	}
	
	
	////sqlquestion
	@RequestMapping(value="/fetchsql",method=RequestMethod.GET)
	public String Displaysql(Model model) {
	
		return "instruction2" ;
	}
	
	@RequestMapping(value="/fetchsqlques")
	public String Fetchsqlquestion(HttpSession session) {
		
		
		 l=1;
		 System.out.println("1234");
			List<Question> list1=this.examService.fetchAllsqlQuestion(l);
			while(i < list1.size() ){
				session.setAttribute("ques",list1.get(i));
					i++;
					return "viewpaper";
		}
			return "result";}
	int i2=0;
	@RequestMapping(value = "/fetchsql2")
	public String Fetchsql2(Model model,HttpSession session) {
		int s=(Integer) session.getAttribute("s1");
		System.out.println(s);
        if(s<=3){
        int l2=2;
	List<Question> li=this.examService.fetchAllsqlQuestion(l2);
	System.out.println(li);
	while(i1 <= li.size() ){
		System.out.println(i);
		session.setAttribute("ques",li.get(i1));
		System.out.println("44");
			i1++;
			return "viewpaper";
			} 
	return "result";
	}	
	 if(s>=4)
	{ 
	       l=3;
		List<Question> list=this.examService.fetchAllsqlQuestion(l);
		while(i2 <= list.size() ){
			System.out.println(i2);
			session.setAttribute("ques",list.get(i2));
			System.out.println("44");
				i2++;
				return "viewpaper";
	}
		return "result";
	}
	return "result";
	}
	
	
	////evalution
	@RequestMapping(value="/evalute")
	public String Evaluteresult(HttpSession session,@RequestParam("option")int option,@ModelAttribute("exam")Exam e) {
		Question q1=(Question)session.getAttribute("ques");
		int r =q1.getRightanswer();
		 e.setUser_choice(option);
		if(option==r)
		{
		score++;
			session.setAttribute("s1", score);
		}
		String x=q1.getTopic() ;
		if(x .equals("jav1") ) {
		return "redirect:/fetchjavaques";
		}
		else if((x .equals("htmll"))){
		return "redirect:/fetchhtmlques";
		}
		else {
	return "redirect:/fetchsqlques";
	}
	}
	//level
	@RequestMapping(value="/level")
	public String Level(HttpSession session) {
		Question q1=(Question)session.getAttribute("ques");
	String x=q1.getTopic() ;
	if(x .equals("jav1") ) {
		
	return "redirect:/fetchjava2";
	}
	else if((x .equals("htmll"))){
	return "redirect:/fetchhtml2";
	}
	else 
	{
        return "redirect:/fetchsql2";
	}
	}
}		

	

