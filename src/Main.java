import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private  static ArrayList<User> userLists = new ArrayList<>();
    private  static ArrayList<Book> listBook = new ArrayList<>();
    private  static int currentUser;

    public static void main(String[] args) {
        CreateMenu();

    }

    public static void CreateMenu() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != -1) {
            System.out.println("-------Menu-------");
            System.out.println("1. Browse Book");
            System.out.println("2. Login ");
            System.out.println("3. Create Account");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: browseBook();
                    break;
                case 2:
                    logIn(userLists);
                    break;
                case 3: createAccount(userLists);
                    break;
                case -1:
                    System.out.println("Exiting the program....");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }

    }
    //User Management system
    private  static void userManagement() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice !=-1) {
            System.out.println("------User Management-------");
            System.out.println("1. Add Users");
            System.out.println("2. Display Users");
            System.out.println("3. Update Users");
            System.out.println("4. Delete Users");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    createAccount(userLists);;
                    break;
                case 2:
                    displayUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void deleteUser(){
        System.out.print("Enter user ID :");
        Scanner input = new Scanner(System.in);
        User user = null;
        String userId = input.nextLine();
        for (User eachUser : userLists) {
            if (eachUser.getUserId().equals(userId)) {
                user = eachUser;
                break;
            }
        }
        userLists.remove(user);
        System.out.println("Delete User Successful");
    }

    private static void displayUsers(){
        for (User user : userLists) {
            System.out.println(
                    " | User ID: " + user.getUserId() +
                            " | Username: " + user.getUserName() +
                            " | Role: " + user.getRole());
        }
    }

    private static void updateUser(){
        System.out.print("Enter user ID :");
        Scanner input = new Scanner(System.in);
        User user = null;
        String userId = input.nextLine();
        for (User eachUser : userLists) {
            if (eachUser.getUserId().equals(userId)) {
                user = eachUser;
                break;
            }
        }
        boolean valid = false;

        //FirstName
        while (!valid) {
            System.out.print("Enter FirstName: ");
            valid = user.setFirstName(input.nextLine());
        }
        //LastName
        valid = false;
        while (!valid) {
            System.out.print("Enter LastName: ");
            valid = user.setLastName(input.nextLine());
        }
        //UserName
        valid =  false;
        while (!valid) {
            System.out.print("Enter UserName: ");
            valid = user.setUserName(input.nextLine());
        }
        //Email
        valid =  false;
        while (!valid) {
            System.out.print("Enter Email: ");
            valid = user.setEmail(input.nextLine());
        }
        //Password
        valid =  false;
        while (!valid) {
            System.out.print("Enter Password: ");
            valid = user.setPassword(input.nextLine());
        }
        //Role
        valid =  false;
        while (!valid) {
            System.out.print("Enter Role" + Arrays.toString(Role.values()) + ": ");
            String roleInput = input.nextLine().trim().toUpperCase();
            Role role = null;
            try {
                role = Role.valueOf(roleInput);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Role");
            }
            user.setRole(role);

        }

        userLists.add(user);
        System.out.println("Update User Successful" + " " +user.getUserName());
    }
    //Book Management
    private static void bookManagement() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice !=-1) {
            System.out.println("------Book Management-------");
            System.out.println("1. Add Books");
            System.out.println("2. Display Books");
            System.out.println("3. Update Books");
            System.out.println("4. Delete Books");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addBook();;
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private static void addBook(){
        Scanner input = new Scanner (System.in);
        System.out.print("Book Name:");
        String bookName = input.next();
        Book book = new Book();
        listBook.add(book);
        System.out.println("Book Added Successfuuly");
    }
    private static void updateBook(){
        System.out.print("Enter Book Title :");
        Scanner input = new Scanner(System.in);
        Book book = null;
        String bookTitle = input.nextLine();
        for (Book eachBook : listBook) {
            if (eachBook.getTitle().equals(bookTitle)) {
                book = eachBook;
                break;
            }
        }
        book.setTitle(bookTitle);
        listBook.add(book);
        System.out.println("Book Update Successfuuly");
    }
    private static void displayBook(){
        for (Book book : listBook) {
            System.out.println(
                    " | Book Title: " + book.getTitle());
        }
    }
    private static void deleteBook(){
        System.out.print("Enter user ID :");
        Scanner input = new Scanner(System.in);
        Book book = null;
        String bookTitle = input.nextLine();
        for (Book eachBook : listBook) {
            if (eachBook.getTitle().equals(bookTitle)) {
                book = eachBook;
                break;
            }
        }
        listBook.remove(book);
        System.out.println("Delete User Successful");
    }
    //Admin menu
    private  static void adminMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice !=-1) {
            System.out.println("-------Admin Menu-------");
            System.out.println("1. User Management");
            System.out.println("2.Book Management");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1: userManagement();
                    break;
                case 2: bookManagement();
                default: System.out.println("Invalid choice");
                    break;
            }
        }
    }

    //Student Menu
    private static void studentMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while(choice !=-1) {
            System.out.println("-------Student Menu-------");
            System.out.println("1. Borrow Book");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
        }
    }
    //Teacher Menu
    private static void teacherMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice !=-1) {
            System.out.println("-------Teacher Menu-------");
            System.out.println("1. Borrow Book");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
        }
    }
    //Librarian Menu
    private static void librarianMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice != -1) {
            System.out.println("-------Librarian Menu-------");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Book Information");
            System.out.println("3. Delete Book ");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
        }
    }

    //Browse Book
    public static void browseBook() {
        System.out.println("------ Available Books ------");
        boolean found = false;

        for (int i = 0; i < listBook.size(); i++) {
            Book book = listBook.get(i);
            if(book == null){
                break;
            }
            if (book.isAvailable()) {
                System.out.println(
                        " | Title: " + book.getTitle() +
                        " | Author: " + Arrays.toString(book.getAuthor()) +
                        " | Subject: " + book.getSubject());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently available.");
        }
    }
    //Show Submenu
    private static void showSubMenu(Role loggedInUserRole) {
        switch (loggedInUserRole) {
            case ADMIN -> adminMenu(userLists);
            case STUDENT -> studentMenu(userLists);
            case TEACHER -> teacherMenu(userLists);
            case LIBRARIAN -> librarianMenu(userLists);
        }
    }
    //login

    public static void logIn(ArrayList<User> userLists) {
        Scanner input = new Scanner(System.in);
        User user = new User();

        String userName = "";
        String password = "";


        boolean valid = false;
        //UserName
        while (!valid) {
            System.out.print("Enter UserName: ");
            userName = input.nextLine();
            user.setUserName(userName);
            valid = user.setUserName(userName);
        }
        //Password
        valid = false;
        while (!valid) {
            System.out.print("Enter Password: ");
            password = input.nextLine();
            valid = user.setPassword(password);
        }

        boolean found = false;
        for (int i = 0; i <currentUser; i++){
            if (userLists.get(i).getUserName().equals(userName))
                if (userLists.get(i).getPassword().equals(password)) {
                    System.out.println("Login Successful "  + userLists.get(i).getUserName() +" "+
                            "as"+ " " + userLists.get(i).getRole().name());
                    showSubMenu(userLists.get(i).getRole());
                    found = true;
                    break;
                }

        }
        if (!found){
            System.out.println("Invalid username or password");
        }
        int roleChoice = input.nextInt();
        input.nextLine(); // consume newline

        Role role;
        switch (roleChoice) {
            case 1 -> role = Role.ADMIN;
            case 2 -> role = Role.STUDENT;
            case 3 -> role = Role.TEACHER;
            case 4 -> role = Role.LIBRARIAN;
            default -> {
                System.out.println("Invalid role! Defaulting to STUDENT.");
                role = Role.STUDENT;
            }
        }
    }
    //CreateAccount
    public  static void createAccount(ArrayList<User> userLists) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        userLists.add(user);

        boolean valid = false;

        //FirstName
        while (!valid) {
            System.out.print("Enter FirstName: ");
            valid = user.setFirstName(input.nextLine());
        }
        //LastName
        valid = false;
        while (!valid) {
            System.out.print("Enter LastName: ");
            valid = user.setLastName(input.nextLine());
        }
        //UserName
        valid =  false;
        while (!valid) {
            System.out.print("Enter UserName: ");
            valid = user.setUserName(input.nextLine());
        }
        //Email
        valid =  false;
        while (!valid) {
            System.out.print("Enter Email: ");
            valid = user.setEmail(input.nextLine());
        }
        //Password
        valid =  false;
        while (!valid) {
            System.out.print("Enter Password: ");
            valid = user.setPassword(input.nextLine());
        }
        //Role
        valid =  false;
        while (!valid) {
            System.out.print("Enter Role" + Arrays.toString(Role.values()) + ": ");
            String roleInput = input.nextLine().trim().toUpperCase();
            Role role = null;
            try {
                role = Role.valueOf(roleInput);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Role");
            }
            user.setRole(role);

        }

        userLists.add(user);
        System.out.println("Create Account Successful" + " " +user.getUserName());

    }
}


