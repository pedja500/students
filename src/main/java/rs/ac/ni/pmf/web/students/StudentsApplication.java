package rs.ac.ni.pmf.web.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rs.ac.ni.pmf.web.students.model.entity.StudentEntity;
import rs.ac.ni.pmf.web.students.repository.StudentRepository;

@SpringBootApplication
public class StudentsApplication {

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {

		SpringApplication.run(StudentsApplication.class, args);
	}
	@Bean
	public StudentRepository makeDataBase() {
		System.out.println("Initializing data");
		StudentEntity student1 = studentRepository.save(StudentEntity.builder().name("Pera Peric").yearOfStudy(4).build());
		StudentEntity student2 = studentRepository.save(StudentEntity.builder().name("Joca Jocic").yearOfStudy(2).build());
		StudentEntity student3 = studentRepository.save(StudentEntity.builder().name("Jovana Jovanovic").yearOfStudy(3).build());
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		return studentRepository;
	}
}
