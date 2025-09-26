package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.MyAuthority;
import lv.venta.model.MyUser;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IMyAuthorityRepo;
import lv.venta.repo.IMyUserRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzDemoSem2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzDemoSem2Application.class, args);
	}
	@Bean
	public CommandLineRunner testModelLayer(IStudentRepo studRepo, 
			IProfessorRepo profRepo, IGradeRepo grRepo, ICourseRepo courseRepo ,
			IMyAuthorityRepo authRepo, IMyUserRepo userRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student s1 = new Student("Konstantins", "Cmils");
				Student s2 = new Student("Guna", "Kravale");
				Student s3 = new Student("Sintija", "Ernstreite");
				
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);
				
				Professor p1 = new Professor("Karina", "Skirmante", Degree.magistra);
				Professor p2 = new Professor("Karlis", "Immers", Degree.magistra);
				Professor p3 = new Professor("Vija", "Vagale", Degree.doktora);
				
				//garais pieraksts
				/*
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				*/
				//īsais pieraksts
				profRepo.saveAll((Arrays.asList(p1, p2, p3)));
			
				Course c1 = new Course("Programmaturas Inzenierija I", 6, p1);
				Course c2 = new Course("Datubazes II", 3, p3);
				Course c3 = new Course("Web tehnologijas", 6, p2);
				
				courseRepo.saveAll(Arrays.asList(c1, c2, c3));
				
				Grade g1 = new Grade(6, s1, c1);//Konstantīns nopelnīja 6 ProgInz I
				Grade g2 = new Grade(9, s1, c2);//Konstantīns nopelnīja 9 Datubāzēs II
				Grade g3 = new Grade(3, s2, c1);//Guna nopelnīja 3 ProgInz I
				Grade g4 = new Grade(8, s2, c2);//Guna nopelnīja 8 Datubāzēs II
				Grade g5 = new Grade(10, s2, c3);//Guna nopelnīja 10 Webteh
				Grade g6 = new Grade(7, s3, c2);//Sintija nopelnīja 7 Datubāzēs II
				Grade g7 = new Grade(5, s3, c3);//Sintija nopelnīja 5 Webteh
				grRepo.saveAll(Arrays.asList(g1, g2, g3, g4, g5, g6, g7));
				
				
				MyAuthority auth1 = new MyAuthority("USER_PROF");
				authRepo.save(auth1);
				
				MyAuthority auth2 = new MyAuthority("ADMIN");
				authRepo.save(auth2);	
				
				MyAuthority auth3 = new MyAuthority("USER_STUD");
				authRepo.save(auth3);
				
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				
				MyUser u1 = new MyUser("marta", encoder.encode("333"), auth2);
				userRepo.save(u1);
				
				MyUser u2 = new MyUser("janis", encoder.encode("321"), auth1);
				userRepo.save(u2);			
				
				MyUser u3 = new MyUser("guna", encoder.encode("111"), auth3);
				userRepo.save(u3);
				
				//TODO izveidot sasaisti starp MyAuthority un MyUser klasēm 
				
			}
		};
	}

}
