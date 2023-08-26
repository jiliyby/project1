package com.example.training;

import com.example.training.Entity.Orders;
import com.example.training.Entity.Product;
import com.example.training.repositories.OrderRepository;
import com.example.training.repositories.ProductRepository;
import com.example.training.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class TrainingApplication {
    private final StudentRepository studentRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public TrainingApplication(StudentRepository studentRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.studentRepository = studentRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TrainingApplication.class, args);

        // Get the TrainingApplication bean to access the repository
        TrainingApplication trainingApplication = context.getBean(TrainingApplication.class);

        Scanner scanner = new Scanner(System.in);

//        System.out.print("Nama : ");
//        String nama = scanner.next();
//
//        System.out.print("NIM : ");
//        String nim = scanner.next();
//
//        System.out.print("IPK : ");
//        double ipk = Double.parseDouble(scanner.next());
//
//        List<String> arrayList = new ArrayList<>();
//
//        arrayList.add(nama);
//        arrayList.add(nim);
//        arrayList.add(String.valueOf(ipk));
//
//        System.out.println("========================== Output ==========================");
//        System.out.println("Nama : " + arrayList.get(0));
//        System.out.println("NIM : " + arrayList.get(1));
//        System.out.println("IPK : " + arrayList.get(2));
//
//        // Example: Use the bookRepository to perform operations
//        Student newStudent = new Student();
//        newStudent.setName(arrayList.get(0));
//        newStudent.setNIM(Double.parseDouble(arrayList.get(1)));
//        newStudent.setIPK(Double.parseDouble(arrayList.get(2)));
//        Student savedStudent = trainingApplication.studentRepository.save(newStudent);
//        System.out.println("Saved Student: " + savedStudent);
//
//        List<Student> newStudentList =new ArrayList<>();

        System.out.print(" Choose One : Product 1 | Order 2 ");
        String request = scanner.next();

        if(request.equals("1"))
        {
            System.out.print("Name : ");
            String name_product = scanner.next();

            System.out.print("stock : ");
            String stock_product = scanner.next();

            Product product = new Product();
            product.setName(name_product);
            product.setStock(Integer.parseInt(stock_product));

            Product savedProduct = trainingApplication.productRepository.save(product);
            System.out.println("Saved Product: " + savedProduct);
        }
        else
        {
            System.out.print("Name : ");
            String orderName = scanner.next();

            System.out.print("Qty : ");
            String orderQty = scanner.next();

            Orders orders = new Orders();
            orders.setName(orderName);
            orders.setQty(Integer.parseInt(orderQty));

            Orders savedOrders = trainingApplication.orderRepository.save(orders);
            System.out.println("Saved Orders: " + savedOrders);
        }

    }
}
