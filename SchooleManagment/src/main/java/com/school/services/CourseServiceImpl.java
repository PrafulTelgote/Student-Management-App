package com.school.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.exceptions.CourseException;
import com.school.exceptions.LoginException;
import com.school.exceptions.StudenExpection;
import com.school.model.Course;
import com.school.model.CurrentSession;
import com.school.model.Student;
import com.school.repo.CourseDao;
import com.school.repo.CurrentSessionDao;
import com.school.repo.StudentDao;

@Service
public class CourseServiceImpl implements CourseServices {

	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private CurrentSessionDao currentdao;


	@Override
	public Course addCourse(String uuid, Course course) throws LoginException, CourseException {
		
		Optional<CurrentSession> admin=currentdao.findByuuid(uuid);
		if(admin.isEmpty()) {
			throw new LoginException("Please Login First...!!!");
		}
		Course data= coursedao.save(course);
		return data;
	}

	@Override
	public Course UpdateCourse(String uuid, Course course) throws LoginException, CourseException {
		// TODO Auto-generated method stub
		Optional<CurrentSession> admin=currentdao.findByuuid(uuid);
		if(admin.isEmpty()) {
			throw new LoginException("Please Login First...!!!");
		}
		if(coursedao.findById(course.getCourseid()).isPresent()) {
			Course data= coursedao.save(course);
			return data;
			
		}else {
			throw new CourseException("Course Not found Please Enter the valide CourseId");
		}
		
	}

	@Override
	public String AddStudentToCourse(String uuid, Integer courseId, Integer StudentID)
			throws LoginException, CourseException, StudenExpection {
	Optional<Student> student=  studentdao.findById(StudentID);
	 Optional<Course> course= coursedao.findById(courseId);
	Optional<CurrentSession>admin=  currentdao.findByuuid(uuid);
	if(admin.isEmpty()) {
		throw new LoginException("Login First");
	}
	if(student.isEmpty()) {
		throw new StudenExpection("Student not Found..!!!");
	}
	if(course.isEmpty()) {
		throw new CourseException("Course Not found...!!!");
	}
	
	Set<Student> students=course.get().getStudent();
	students.add(student.get());
	course.get().setStudent(students);
	coursedao.save(course.get());
	
	
		
		
		
		return "updated..!!!";
	}

	@Override
	public String RemoveStudentFromCourse(String uuid, Integer courseId, Integer StudentID)
			throws LoginException, CourseException, StudenExpection {
		Optional<Student> student=  studentdao.findById(StudentID);
		 Optional<Course> course= coursedao.findById(courseId);
		Optional<CurrentSession>admin=  currentdao.findByuuid(uuid);
		if(admin.isEmpty()) {
			throw new LoginException("Login First");
		}
		if(student.isEmpty()) {
			throw new StudenExpection("Student not Found..!!!");
		}
		if(course.isEmpty()) {
			throw new CourseException("Course Not found...!!!");
		}
		
		Set<Student> students=course.get().getStudent();
		Set<Course> courses=student.get().getCourse();
		for(Student i:students) {
			if(StudentID == i.getStudentid()) {
				students.remove(StudentID);
//				courses.remove(courses.contains(course.get()));
				return "Removed..!!";
			}
		}
		throw new StudenExpection("Student not Found in the abouve course..!!!");
	}
	
	
	
	
}
