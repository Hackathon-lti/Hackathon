package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	List<Question> li=this.examService.fetchAlljavaQuestion();
	session.setAttribute("list", li);
//int i=0;
// for(i=0;i<2 ;i++){
	/*model.addAttribute("question",	li.get(i).getQuestion() );
	model.addAttribute("option1",	li.get(i).getOption1() );
	model.addAttribute("option2",	li.get(i).getOption2() );
	model.addAttribute("option3",	li.get(i).getOption3() );
	model.addAttribute("option4",	li.get(i).getOption4() );*/
	model.addAttribute("list", li);
	System.out.println(li);
			return "viewpaper";
		}

	
	
	
	@RequestMapping(value="/fetchhtml",method=RequestMethod.GET)
	public String Displayhtml(Model model) {
	
		return "instruction1" ;
	}
	
	
	@RequestMapping(value="/fetchhtmlques",method =RequestMethod.POST)
	  public String fetchhtmlquestion(@ModelAttribute("exam")Exam e) {
			this.examService.fetchAllhtmlQuestion();
			return "viewpaper";
		}
	
	@RequestMapping(value="/fetchsql",method=RequestMethod.GET)
	public String Displaysql(Model model) {
	
		return "instruction2" ;
	}
	
	@RequestMapping(value="/fetchsqlques",method =RequestMethod.POST)
	public String Fetchsqlquestion(@ModelAttribute("exam")Exam e) {
			this.examService.fetchAllsqlQuestion();
		return "viewpaper";
	}
		
	}
	

