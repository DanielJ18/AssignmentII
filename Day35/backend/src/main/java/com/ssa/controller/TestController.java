package com.ssa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eddb.Student;
//import hello.Greeting;

@CrossOrigin
@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping("/students")
    public List<Student> students() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Greg","Doud", 1350, 3.5));
		students.add(new Student("Mickey","Mouse", 1250, 3.4));
		students.add(new Student("Donald","Duck", 850, 2.5));
		
        return students;
	}
    
	@RequestMapping("/student")
    public Student student() {
        return new Student("Greg","Doud", 1250, 3.5);
	}

  //  @CrossOrigin
//	@RequestMapping("/greeting")
  //  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //    return new Greeting(counter.incrementAndGet(),
      //                      String.format(template, name));
	//}
}
