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

	@RequestMapping(value="/fetchjava",method=RequestMethod.GET)
	public String DisplayJava(Model model) {
		model.addAttribute("exam", new Exam());
		return "instruction" ;
	}
	@RequestMapping(value = "/fetchjavaques")
	public String Fetchjavaquestion(@ModelAttribute ("exam")
	@Valid Exam e,Model model,HttpSession session) {
		System.out.println("hii");
		Question q= new Question();
		q.setLev(l);
		if(q.getLev()==1) {
	List<Question> li=this.examService.fetchAlljavaQuestion(l);
	while(i < li.size() ){
		session.setAttribute("ques",li.get(i));
			
			i++;
			return "viewpaper";
		
		}
	Question q2=(Question)session.getAttribute("level2");
	
	if(q2.getLev()==2)
	{
		List<Question> list=this.examService.fetchAlljavaQuestion(l);
		while(i < list.size() ){
			session.setAttribute("ques",li.get(i));
				
				i++;
				return "viewpaper";
	}
		if(q2.getLev()==3)
		{
			List<Question> list1=this.examService.fetchAlljavaQuestion(l);
			while(i < list1.size() ){
				session.setAttribute("ques",li.get(i));
					
					i++;
					return "viewpaper";
		}
	}
		}}
			
System.out.println(score);
    return "result";

		}
	
	
	
	@RequestMapping(value="/fetchhtml")
	public String Displayhtml(Model model) {
	
		return "instruction1" ;
	}
	
	
	@RequestMapping(value="/fetchhtmlques",method =RequestMethod.GET)
	  public String fetchhtmlquestion(@ModelAttribute("exam")Exam e,HttpSession session) {
		List<Question> li=this.examService.fetchAllhtmlQuestion(l);

		while(i <= li.size() ){
		session.setAttribute("ques",li.get(i));
		i++;
			return "viewpaper";
		}
		return "result";}
	
	@RequestMapping(value="/fetchsql",method=RequestMethod.GET)
	public String Displaysql(Model model) {
	
		return "instruction2" ;
	}
	
	@RequestMapping(value="/fetchsqlques",method =RequestMethod.POST)
	public String Fetchsqlquestion(@ModelAttribute("exam")Exam e) {
			this.examService.fetchAllsqlQuestion(l);
		return "viewpaper";
	}
	@RequestMapping(value="/evalute")
	public String Evaluteresult(HttpSession session,@RequestParam("option")int option,@ModelAttribute("exam")Exam e) {
		Question q1=(Question)session.getAttribute("ques");
		int r =q1.getRightanswer();
		 e.setUser_choice(option);
		if(option==r)
		{
			int s=score++;
			e.setScore(s);
			if(s>=5) {
				q1.setLev(2);	
			session.setAttribute("level2",q1);
			}
			else if(s>= 10) {
			q1.setLev(3);
			session.setAttribute("level3",q1);
			}
		}
		
		if(q1.getTopic() == "jav1") {
		return "redirect:/fetchjavaques";
		}
	if(q1.getTopic() == "htmll") {
		return "redirect:/fetchhtmlques";
		}
if(q1.getTopic() == "sqll") {
	return "redirect:/fetchsqlques";
	}
return null;
	} }
		

	

