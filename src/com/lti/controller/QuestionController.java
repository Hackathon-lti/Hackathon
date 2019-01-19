package com.lti.controller;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lti.exception.CustomException;
import com.lti.model.Question;

import com.lti.service.IQuestionService;

@Controller
@SessionAttributes({"tl"})
public class QuestionController {

	@Autowired
private IQuestionService questionService;

//@Qualifier(value = "questionService")
public void setQuestionService(IQuestionService qs) {
	this.questionService = qs;
}
/*@Autowired
private IAnswerService answerService;

	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}*/

//@ExceptionHandler(CustomException.class)
public ModelAndView handlePersonNotFoundException(CustomException ex) {
	Map<String, CustomException> model = new HashMap<String, CustomException>();
	model.put("exception", ex);
	return new ModelAndView("error", model);

}

//@ExceptionHandler(Exception.class)
public ModelAndView handleException(Exception ex) {
	Map<String, Exception> model = new HashMap<String, Exception>();
	model.put("exception", ex);
	return new ModelAndView("error", model);

}


/*@RequestMapping(value="/topic",method=RequestMethod.GET)
public String selectTopic(Model model) {
	
	model.addAttribute("tl", new QuestionSet());
	
	return "Topiclevel";
}*/
@RequestMapping(value = "/questions", method = RequestMethod.GET)
public String listQuestions(Model model ,HttpSession ses) {
/*ses.setAttribute("tl",tl)*/;

	model.addAttribute("ques", new Question());// model
	
	model.addAttribute("listQuestions",
			this.questionService.listQuestions());
	
	return "question";// view name
}


/*@ModelAttribute("level")
public List<Integer> getLevels()
{
	
return Arrays.asList(1,2,3);

}

@ModelAttribute("topic")
public List<String> getTopic()
{
return Arrays.asList("java","python");	

}
*/
// For add and update person both
@RequestMapping(value = "/question/add", 
		method = RequestMethod.POST)
//@ExceptionHandler({ CustomException.class })
public String addQuestion(
		@ModelAttribute ("ques")
		@Valid Question question,
		BindingResult result,  
		Model model,
		HttpSession session) {
	if (!result.hasErrors()) {
		
		;
		if (question.getQuestion_id() == 0) {
			// new person, add it
	    /*  QuestionSet qs = new QuestionSet();
	      qs.setLevel(re);
	      qs.setTopic(req);
	      question.setQuestionset(qs);*/
			/*question.setQuestionset((QuestionSet)session.getAttribute("tl"));*/
			this.questionService.addQuestion(question);
			
		} else {
			// existing person, call update
			this.questionService.updateQuestion(question);
		}
		
		return "redirect:/questions";
	}
	System.out.println(question);
	model.addAttribute("listQuestions", this.questionService.listQuestions());
	return "question";
		}

	
	


@RequestMapping("/delete/{question_id}")
//@ExceptionHandler({ CustomException.class })
public String deleteQuestion(@PathVariable("question_id") int question_id) throws CustomException {
	if (question_id < 0) {
		throw new CustomException("Given Id Not Found","404");
	} else {
		this.questionService.deleteQuestion(question_id);
	}
	return "redirect:/questions";
}

@RequestMapping("/edit/{question_id}")
public String showEditQuestionPage(
		@PathVariable("question_id") int question_id, Model model) {
	Question questionObj = 
			this.questionService.getQuestionByQuestion_id(question_id);
	model.addAttribute("question", questionObj);
	List<Question> questionListObj =
			this.questionService.listQuestions();
	model.addAttribute("listQuestions", questionListObj);
	return "question";// view name
}









@RequestMapping("/showErrorPage/error")
//@ExceptionHandler(Exception.class)
public ModelAndView exception(Exception e) {

	ModelAndView mav = new ModelAndView("error");// view name
	mav.addObject("exName", e.getClass().getSimpleName());// model for ex name
	mav.addObject("exMessage", e.getMessage());// model for ex msg
	return mav;
}



}