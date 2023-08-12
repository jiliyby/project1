package com.example.training;

import com.example.training.Entity.Student;
import com.example.training.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class TrainingApplication {
    private final StudentRepository studentRepository;

    public TrainingApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TrainingApplication.class, args);

        // Get the TrainingApplication bean to access the repository
        TrainingApplication trainingApplication = context.getBean(TrainingApplication.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama : ");
        String nama = scanner.next();

        System.out.print("NIM : ");
        String nim = scanner.next();

        System.out.print("IPK : ");
        double ipk = Double.parseDouble(scanner.next());

        List<String> arrayList = new ArrayList<>();

        arrayList.add(nama);
        arrayList.add(nim);
        arrayList.add(String.valueOf(ipk));

        System.out.println("========================== Output ==========================");
        System.out.println("Nama : " + arrayList.get(0));
        System.out.println("NIM : " + arrayList.get(1));
        System.out.println("IPK : " + arrayList.get(2));

        // Example: Use the bookRepository to perform operations
        Student newStudent = new Student();
        newStudent.setName(arrayList.get(0));
        newStudent.setNIM(Double.parseDouble(arrayList.get(1)));
        newStudent.setIPK(Double.parseDouble(arrayList.get(2)));
        Student savedStudent = trainingApplication.studentRepository.save(newStudent);
        System.out.println("Saved Student: " + savedStudent);


    }
}
