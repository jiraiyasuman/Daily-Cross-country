/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice.spring.librarymanagementsystem.main;

/**
 *
 * @author SUMAN
 */
import com.mycompany.practice.spring.librarymanagementsystem.entity.Admin;
import com.mycompany.practice.spring.librarymanagementsystem.entity.BillingFine;
import com.mycompany.practice.spring.librarymanagementsystem.entity.Books;
import com.mycompany.practice.spring.librarymanagementsystem.entity.IssueBooks;
import com.mycompany.practice.spring.librarymanagementsystem.entity.Student;
import com.mycompany.practice.spring.librarymanagementsystem.entity.User;
import com.mycompany.practice.spring.librarymanagementsystem.exception.BookOutOfStock;
import com.mycompany.practice.spring.librarymanagementsystem.exception.ErrorException;
import com.mycompany.practice.spring.librarymanagementsystem.security.PasswordHashing;
import com.mycompany.practice.spring.librarymanagementsystem.service.StudentService;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.AdminServiceImpl;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.BillingFineServiceImpl;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.BookServiceImpl;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.IssueBookServiceImpl;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.StudentServiceImpl;
import com.mycompany.practice.spring.librarymanagementsystem.service.impl.UserServiceImpl;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;
public class LibraryMain {
    
    static LibraryMain obj = new LibraryMain();
    private static final Logger LOG = Logger.getLogger(LibraryMain.class.getName());
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
     public static void main(String args[])throws Exception{
         System.out.println("================== Welcome to Library Management System ==================");
         while(true){
              System.out.println("Please enter 1 to go to ADMIN menu");
              System.out.println("Please enter 2 to go to USER menu");
              System.out.println("Please enter 3 to exit the menu");
              int choice = Integer.parseInt(BR.readLine());         
              switch(choice){
                  case 1:
                      obj.admin();
                      break;
                  case 2:
                      obj.user();
                      break;
                  case 3:
                      System.out.println("Exiting the application");
                      return ;
                  default:
                      System.out.println("Invalid choice");
                     
              }
         }
         
         
     }
     public void user(){
         boolean status=false;
         System.out.println("Welcome to User Section");
         try {
             while(true){
             System.out.println("Press 1 for registration of new users");
             System.out.println("Press 2 for login");
             System.out.println("Press 3 for exiting ");
             int choice = Integer.parseInt(BR.readLine());
             switch(choice){
                 case 1:
                 status=obj.regUser();
                 break;
                 case 2:
                     obj.loginUser();
                     break;
                 case 3:
                     return;
                     default:
                         System.out.println("Invalid choice");
             }
                     
         }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

    private void admin() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("--------------Welcome to Admin Section================");
        Admin admin = new Admin();
        try {
            while(true){
                System.out.println("Please enter 1 to register");
                System.out.println("Please enter 2 to login ");
                System.out.println("Please enter 3 to exiting");
                int choice = Integer.parseInt(BR.readLine());
                switch(choice){
                    case 1:
                        System.out.println("Please enter the username");
        String userName = BR.readLine();
        System.out.println("Please enter the email");
        String email = BR.readLine();
            System.out.println("Please enter the password");
            String password =BR.readLine();
            PasswordHashing ob = new PasswordHashing();
            String hashPassword = ob.passwordHashing(password);
                        AdminServiceImpl ob1 = new AdminServiceImpl();
                        admin = ob1.registerAdmin(userName, email, password);
                        break;
                    case 2:
                        System.out.println("Please enter the email");
        String email1 = BR.readLine();
            System.out.println("Please enter the password");
            String password1 =BR.readLine();
             PasswordHashing ob0 = new PasswordHashing();
                    hashPassword = ob0.passwordHashing(password1);
                    AdminServiceImpl ob2 = new AdminServiceImpl();
                    Boolean status = ob2.loginAdmin(email1, hashPassword);
                    if(status == true){
                        System.out.println("Login is successful");
                        adminOperation();
                    }else{
                        throw new ErrorException("Sorry we are ending the application");
                    }
                    break;
                    case 3: 
                        System.out.println("Exiting");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean regUser() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      User user =new User();
        try {
             System.out.println("Please enter the username");
        String userName = BR.readLine();
        System.out.println("Please enter the email");
        String email = BR.readLine();
            System.out.println("Please enter the password");
            String password =BR.readLine();
            PasswordHashing ob = new PasswordHashing();
            String hashPassword = ob.passwordHashing(password);
            UserServiceImpl obj1 = new UserServiceImpl();
            user = obj1.registerUser(userName,email,hashPassword);
            if(user!=null)
            {
                return true;
            }else{
                throw new ErrorException("User is not registerd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void loginUser() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("=================Login User=================="); 
       try {
             System.out.println("Please enter the email");
       String email = BR.readLine();
            System.out.println("Please enter the password");
            String password = BR.readLine();
            UserServiceImpl ob = new UserServiceImpl();
            PasswordHashing ob1 = new PasswordHashing();
            String hashPassword = ob1.passwordHashing(password);
            boolean status=ob.loginUser(email, hashPassword);
            if(status==false){
                System.out.println("Login is unsuccesssfull");
                System.out.println("Exiting");
            }else{
                while(true){
                    System.out.println("========Welcome to Student portal");
                System.out.println("Please enter 1 to view all books");
                System.out.println("Please enter 2 to view book by id");
                System.out.println("Please enter 3 to exit ");
                int choice =  Integer.parseInt(BR.readLine());
                switch(choice){
                    case 1:
                        BookServiceImpl ob0 = new BookServiceImpl();
                        List<Books> books = ob0.getAllBooks();
                        System.out.println("=======List of All Books=======");
                        Books b= new Books();
                        for(int i=0;i<books.size();i++){
                            b=books.get(i);
                            System.out.println("Book Id :"+b.getId()+" Book Name : "+b.getBookName()+" Book Author : "+b.getBookAuthor()+" Book Publisher : "+b.getBookPublisher()+" Book Description : "+b.getBookDescription()+" Book Price :  "+b.getBookPrice()+" Book quantity : "+b.getBookQuantity());
                        }
                        break;
                    case 2:
                        BookServiceImpl ob2 = new BookServiceImpl();
                        System.out.println("Please enter the book id");
                        int id=Integer.parseInt(BR.readLine());
                        Books b1 = new Books();
                        b1 = ob2.getBookById(id);
                        System.out.println("Book Id :"+b1.getId()+" Book Name : "+b1.getBookName()+" Book Author : "+b1.getBookAuthor()+" Book Publisher : "+b1.getBookPublisher()+" Book Description : "+b1.getBookDescription()+" Book Price :  "+b1.getBookPrice()+" Book quantity : "+b1.getBookQuantity());
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adminOperation() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Admin obj = new Admin();
        try {
            while(true){
                System.out.println("=========Welcome to Admin Portal=========");
            System.out.println("Please enter 1 for manipulation of books");
            System.out.println("Please enter 2 for book issue services");
            System.out.println("Please enter 3 for billing services");
                System.out.println("Please enter 4 for student manipulation");
            System.out.println("Please enter 5 for exiting the application");
                System.out.println("Please enter your choice");
                int choice = Integer.parseInt(BR.readLine());
                switch(choice){
                    case 1:
                        bookService();
                        break;
                    case 2:
                        issueBooks();
                        break;
                    case 3: 
                        biilingServices();
                        break;
                    case 4:
                        studentServices();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
        }
    
    }

    private void bookService() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("===========Welcome too Book Service==========");
        while(true){
            try {
                System.out.println("Please enter 1 to add books");
            System.out.println("Please enter 2 to get the list of books");
            System.out.println("Please enter 3 to get books by id");
            System.out.println("Please enter 4 to update the books by their price");
            System.out.println("Please enter 5 to delete the books by their id");
            System.out.println("Please enter the choice");
            int choice=Integer.parseInt(BR.readLine());
            switch(choice){
                case 1:
                    System.out.println("Please enter the name of the book");
                    String bookName=BR.readLine();
                    System.out.println("Please enter the name of the author");
                    String bookAuthor=BR.readLine();
                    System.out.println("Please enter the description of the book");
                    String bookDescription = BR.readLine();
                    System.out.println("Please enter the book publisher");
                    String bookPublisher =BR.readLine();
                    System.out.println("Please enter the number of books");
                    int bookQuantity = Integer.parseInt(BR.readLine());
                    System.out.println("Please enter the price of the book");
                    double price=Double.parseDouble(BR.readLine());
                    BookServiceImpl impl = new BookServiceImpl();
                    Books book = impl.addBook(bookName, bookAuthor, bookPublisher, bookDescription, price, bookQuantity);
                    break;
                case 2:
                    List<Books> list= new ArrayList<>();
                    impl = new BookServiceImpl();
                    Books b1 = new Books();
                    list= impl.getAllBooks();
                    for(int i=0; i<list.size();i++){
                        b1=list.get(i);
                        System.out.println("Book Id :"+b1.getId()+" Book Name : "+b1.getBookName()+" Book Author : "+b1.getBookAuthor()+" Book Publisher : "+b1.getBookPublisher()+" Book Description : "+b1.getBookDescription()+" Book Price :  "+b1.getBookPrice()+" Book quantity : "+b1.getBookQuantity());
                        
                    }
                    break;
                case 3:
                    System.out.println("Please enter the book Id");
                    int id1=Integer.parseInt(BR.readLine());
                     impl = new BookServiceImpl();
                    b1= new Books();
                    b1= impl.getBookById(id1);
                    System.out.println("Book Id :"+b1.getId()+" Book Name : "+b1.getBookName()+" Book Author : "+b1.getBookAuthor()+" Book Publisher : "+b1.getBookPublisher()+" Book Description : "+b1.getBookDescription()+" Book Price :  "+b1.getBookPrice()+" Book quantity : "+b1.getBookQuantity());
                    
                    break;
                case 4:
                    System.out.println("Please enter the book Id");
                    int id=Integer.parseInt(BR.readLine());
                    System.out.println("Please enter the price of the books");
                    double price1=Double.parseDouble(BR.readLine());
                    impl = new BookServiceImpl();
                    b1= new Books();
                    b1 = impl.updateBooksByPrice(id, price1);
                    System.out.println("Book Id :"+b1.getId()+" Book Name : "+b1.getBookName()+" Book Author : "+b1.getBookAuthor()+" Book Publisher : "+b1.getBookPublisher()+" Book Description : "+b1.getBookDescription()+" Book Price :  "+b1.getBookPrice()+" Book quantity : "+b1.getBookQuantity());
                    
                    break;
                case 5:
                    System.out.println("Please enter the book Id");
                    int id2=Integer.parseInt(BR.readLine());
                    impl = new BookServiceImpl();
                    b1= new Books();
                    impl.deleteBooksById(id2);
                    break;
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }

    private void issueBooks() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    IssueBooks issueBooks = new IssueBooks();
    BookServiceImpl bookServiceImpl = new BookServiceImpl();
    StudentServiceImpl studentStudentServiceImpl=new StudentServiceImpl();
        IssueBookServiceImpl issueBookServiceImpl = new IssueBookServiceImpl();
        try {
            while(true){
        System.out.println("Please press 1 to add to issue books");
        System.out.println("Please press 2 to get all the books");
        System.out.println("Please press 3 to get book by id");
        System.out.println("Please press 4 to exit the application");
        System.out.println("Please enter the choice");
        int choice = Integer.parseInt(BR.readLine());
        int quantity=0;boolean status=false;
        IssueBooks issue=new IssueBooks();
        switch(choice){
            case 1:
                System.out.println("Please enter the name of the book");
                String bookName= BR.readLine();
                System.out.println("Please enter the name of the Author");
                String bookAuthor=BR.readLine();
                System.out.println("Please enter the issue date of the book");
                LocalDate issueDate= LocalDate.now();
                System.out.println("Please enter the student Id");
                int studentId=Integer.parseInt(BR.readLine());
                System.out.println("Please enter the bookId");
                int bookId=Integer.parseInt(BR.readLine());
                Student student = studentStudentServiceImpl.getByStudent(studentId);
                Books book= bookServiceImpl.getBookById(bookId);
                if(book!=null && student!=null){
                   quantity = book.getBookQuantity();
                   if(quantity>0){
                       status=true;
                       // adding the issuebooks detail in the cache database
                       issue.setBookId(bookId);
                       issue.setBookName(bookName);
                       issue.setBookAuthor(bookAuthor);
                       issue.setIssueDate(issueDate);
                       issue.setQuantity(quantity);
                       issue.setStatusBooks(status);
                       issue.setStudentId(studentId);
                       issueBookServiceImpl.addIssueBook(bookName, bookAuthor, issueDate, quantity, status, studentId, bookId);
                       
                   }else{
                       throw new BookOutOfStock("Book is out of stock");
                   }
                }else if(book==null||student!=null){
                    throw new ErrorException("Book cannot be found");
                }else if(book!=null || student == null){
                    throw new ErrorException("Student cannot be found");
                }else{
                    throw new ErrorException("Neither Student nor Books are present");
                }
            break;
            case 2:
                List<IssueBooks> listIssue = new ArrayList<>();
                listIssue=issueBookServiceImpl.getAllList();
                System.out.println("Display the list of students");
                for(int i=0;i<listIssue.size();i++){
                    issue = listIssue.get(i);
                    System.out.println("Issue Id: "+issue.getId()+" Issue Book Name: "+issue.getBookName()+" Issue Book Author: "+issue.getBookAuthor()+" Issue Book Issue Date: "+issue.getIssueDate()+" Issue Book Quantity:  "+issue.getQuantity()+" Issue Book Status "+issue.isStatusBooks()+" Issue Book Id: "+issue.getBookId()+" Issue Student Id: "+issue.getStudentId());
                    
                }
                break;
        case 3:
            System.out.println("Please enter the issue Id");
            int id =Integer.parseInt(BR.readLine());
            listIssue = issueBookServiceImpl.getDetailsById(id);
            for(int i=0;i<listIssue.size();i++){
                issue = listIssue.get(i);
                    System.out.println("Issue Id: "+issue.getId()+" Issue Book Name: "+issue.getBookName()+" Issue Book Author: "+issue.getBookAuthor()+" Issue Book Issue Date: "+issue.getIssueDate()+" Issue Book Quantity:  "+issue.getQuantity()+" Issue Book Status "+issue.isStatusBooks()+" Issue Book Id: "+issue.getBookId()+" Issue Student Id: "+issue.getStudentId());
                    
            }
            break;
        case 4:
            return;
        default:
            System.out.println("Invalid Choice");
        }        
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void biilingServices() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BillingFine billingFine = new BillingFine();
        BillingFineServiceImpl billingFineServiceImpl = new BillingFineServiceImpl();
        List<BillingFine> billingList = new ArrayList<>();
        List<IssueBooks> issueBooks = new ArrayList<>();
        Books book=new Books();
        IssueBookServiceImpl issueBookServiceImpl=new IssueBookServiceImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        StudentServiceImpl studentStudentServiceImpl=new StudentServiceImpl();
        Student student= new Student();
        IssueBooks issueBook = new IssueBooks();
        try {
            while(true){
                System.out.println("Please enter 1 to add the billing details");
                System.out.println("Please enter 2 to get all the billing details");
                System.out.println("Please enter 3 to exit the application");
                System.out.println("Please enter the choice");
                int choice = Integer.parseInt(BR.readLine());
                switch(choice){
                    case 1:
                        System.out.println("Please enter the Student Name");
                        String name=BR.readLine();
                        System.out.println("Please enter the Student Id");
                        int studentId=Integer.parseInt(BR.readLine());
                        student = studentStudentServiceImpl.getByStudent(studentId);
                        System.out.println("Please enter the book Id");
                        int bookId=Integer.parseInt(BR.readLine());
                        book = bookServiceImpl.getBookById(bookId);
                        System.out.println("Please enter the Issue Id");
                        int issueId=Integer.parseInt(BR.readLine());
                        issueBooks = issueBookServiceImpl.getDetailsById(issueId);
                        System.out.println("Please enter the Book name");
                        String bookName=BR.readLine();
                        System.out.println("Please enter the Book Author");
                        String bookAuthor = BR.readLine();
                        System.out.println("Please enter the IssueDate");
                        LocalDate issueDate=null;
                        for(int i=0;i<issueBooks.size();i++){
                            issueBook = issueBooks.get(i);
                            if(issueId==issueBook.getId()){
                                issueDate=issueBook.getIssueDate();
                            }
                        }
                        System.out.println("Please enter the Return Date");
                        LocalDate returnDate=LocalDate.now();
                        System.out.println("Please enter the number of days");
                        int daysBetween =(int) ChronoUnit.DAYS.between(issueDate, returnDate);
                        // 5 days is the lending period. Beyond that per day 5 INR is calculated
                        double fine=(daysBetween-5)*5.0;
                        billingFine.setIssueId(issueId);
                        billingFine.setStudentId(studentId);
                        billingFine.setBookName(bookName);
                        billingFine.setBookAuthor(bookAuthor);
                        billingFine.setDays(daysBetween);
                        billingFine.setFine(fine);
                        billingFine.setReturnDate(returnDate);
                        billingFine.setIssueDate(issueDate);
                        billingFine.setStudentName(name);
                        billingFine = billingFineServiceImpl.addBill(bookName, studentId, bookId, bookName, bookAuthor, issueDate, returnDate, fine, bookId);
                        break;
                    case 2:
                        billingList = billingFineServiceImpl.getAllList();
                        for(int i=0;i<billingList.size();i++){
                            System.out.println("fineId "+billingList.get(i).getFineId()+" studentName "+billingList.get(i).getStudentName()+" studentId "+billingList.get(i).getStudentId()+" issueId "+billingList.get(i).getIssueId()+" bookId "+billingList.get(i).getBookId()+" bookName "+billingList.get(i).getBookName()+" bookAuthor "+billingList.get(i).getBookAuthor()+" issueDate "+billingList.get(i).getIssueDate()+" returnDate "+billingList.get(i).getReturnDate()+" fine "+billingList.get(i).getFine()+" days "+billingList.get(i).getDays());
                    }
                        break;
                }
            }
        } catch (Exception e) {
        }
        
    
    }

    private void studentServices() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        while(true){
            try {
                System.out.println("Please enter 1 to add student details");
            System.out.println("Please enter 2 to get all student details");
            System.out.println("Please enter 3 to get student details by id");
            System.out.println("Please enter 4 to update student details by id");
            System.out.println("Please enter 5 to delete student details by id");
            System.out.println("Please enter 6 to exit the application");
            int choice = Integer.parseInt(BR.readLine());
            StudentServiceImpl studentService = new StudentServiceImpl();
            switch(choice){
                case 1:
                    System.out.println("Please enter the first name of the Student");
                    String firstName=BR.readLine();
                    System.out.println("Please enter the last name of the Student");
                    String lastName = BR.readLine();
                    System.out.println("Please enter the email of the Student");
                    String email = BR.readLine();
                    System.out.println("Please enter the course of the student");
                    String course = BR.readLine();
                    
                    Student student = studentService.addStudnet(firstName, lastName, email, course);
                    System.out.println("Student Id: "+student.getStudentId()+"Student First Name:"+firstName+" Student Last Name "+lastName+" Student email "+email+" Student course: "+course);
                    break;
                case 2:
                    
                    List<Student> getStudents = studentService.getAllLists();
                    for(int i=0;i<getStudents.size();i++){
                       student=new Student();
                       student = getStudents.get(i);
                       System.out.println("Student Id:"+student.getStudentId()+" Student First Name:"+student.getFirstName()+" Student last Name: "+student.getLastName()+" Student email: "+student.getEmail()+" Student course:  "+student.getCourse());   
                    }         
                    break;
                case 3:
                    student = new Student();
                    System.out.println("Please enter the id of the student");
                    int id= Integer.parseInt(BR.readLine());
                    student = studentService.getByStudent(id);
                    System.out.println("Student Id:"+student.getStudentId()+" Student First Name:"+student.getFirstName()+" Student last Name: "+student.getLastName()+" Student email: "+student.getEmail()+" Student course:  "+student.getCourse());   
                    break;
                case 4:
                    System.out.println("Please enter the id of the student");
                    int newId = Integer.parseInt(BR.readLine());
                    System.out.println("Please enter the first Name of the student");
                    String newFirstName = BR.readLine();
                    System.out.println("Please enter the last Name of the student");
                    String newLastName = BR.readLine();
                    System.out.println("Please enter the email of the student");
                    String newEmail=BR.readLine();
                    System.out.println("Please enter the course of the student");
                    String newCourse = BR.readLine();
                    Student students = new Student();
                    students.setStudentId(newId);
                    students.setFirstName(newFirstName);
                    students.setLastName(newLastName);
                    students.setEmail(newEmail);
                    students.setCourse(newCourse);
                    student = studentService.updateStudent(newId, students);
                    System.out.println("Student Id:"+student.getStudentId()+" Student First Name:"+student.getFirstName()+" Student last Name: "+student.getLastName()+" Student email: "+student.getEmail()+" Student course:  "+student.getCourse());
                    break;
                case 5:
                    System.out.println("Please enter the id");
                    int deletedId = Integer.parseInt(BR.readLine());
                    studentService.deleteStudent(deletedId);
                    
                    break;
                case 6:
                    return;
                    default:
                        System.out.println("Invalid Choice");
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    
    }
}
