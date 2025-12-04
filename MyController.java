package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    StudentService ss;

    @GetMapping("/")
    public String home() 
    {
        return "home";   // home.jsp
    }

    @GetMapping("/register")
    public String register() 
    {
        return "register";   // register.jsp
    }

    @GetMapping("/viewdata")
    public String viewdata(Model m) 
    {
        List<Student> list = ss.getallstudents();  
        m.addAttribute("list", list);
        return "viewdata";  // viewdata.jsp
    }

    @GetMapping("/login")
    public String login() 
    {
        return "login";   // login.jsp
    }

    @PostMapping("/saveform")
    public String saveform(@ModelAttribute Student s) 
    {
        ss.registration(s);
        return "redirect:/viewdata";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
    	try
    	{
    		ss.delete(id);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return "redirect:/viewdata";
    }
    
    @GetMapping("/profileedit/{id}")
    public String profileedit(@PathVariable Long id, Model m)
    {
    	Optional<Student> s = ss.getStudentById(id);
    	m.addAttribute("student",s.get());
    	return "edit";	//edit.jsp
    }
    
    @PostMapping("/saveprofile/{id}")
    public String saveprofile(@PathVariable Long id,@ModelAttribute Student s)
    {
    	ss.profileupdate(id,s);
    	
    	return "redirect:/viewdata";
    }
    
    @PostMapping("/logincheck")
    public String logincheck(@RequestParam String email, @RequestParam String password)
    {
    	try
    	{
    		ss.logincheck(email,password);
    		return "redirect:/dashboard";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return "redirect:/login";
    	}
    }
    
    @GetMapping("/dashboard")
    public String dashboard()
    {
    	return "dashboard";	//dashboard.jsp
    }
    
    @GetMapping("/logout")
    public String logout()
    {
    	return "redirect:/login";
    }
}

