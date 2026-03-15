import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private  static User[] userLists = new User[1000];
    private  static int currentUser;
    private static BookItem[] booklists = new BookItem[1000];
    private static int currentBook = 0;

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
        while (choice != -1) {
            System.out.println("------User Management-------");
            System.out.println("1. Add Users");
            System.out.println("2. Display Users");
            System.out.println("3. Update Users");
            System.out.println("4. Delete Users");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
    }
    //Book Management
    private static void bookManagement() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != -1) {
            System.out.println("------Book Management-------");
            System.out.println("1. Add Books");
            System.out.println("2. Display Books");
            System.out.println("3. Update Books");
            System.out.println("4. Delete Books");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
    }
    //Admin menu
    private  static void adminMenu(User[] userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice != -1) {
            System.out.println("-------Admin Menu-------");
            System.out.println("1. User Management");
            System.out.println("2.Book Management");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
        switch (choice) {
            case 1: userManagement();
                break;
            case 2: bookManagement();
            default: System.out.println("Invalid choice");
                break;
        }
    }

    //Student Menu
    private static void studentMenu(User[] userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while(choice != -1) {
            System.out.println("-------Student Menu-------");
            System.out.println("1. Borrow Book");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
    }
    //Teacher Menu
    private static void teacherMenu(User[] userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice != -1) {
            System.out.println("-------Teacher Menu-------");
            System.out.println("1. Borrow Book");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
    }
    //Librarian Menu
    private static void librarianMenu(User[] userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice != -1) {
            System.out.println("-------Librarian Menu-------");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Book Information");
            System.out.println("3. Delete Book ");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
        }
    }


    //Browse Book
    public static void browseBook() {
        System.out.println("------ Available Books ------");
        boolean found = false;

        for (int i = 0; i < currentBook; i++) {
            if (booklists[i].getStatus() == Status.AVAILABLE) {
                System.out.println("ID: " + booklists[i].getBookItemId() +
                        " | Title: " + booklists[i].getTitle() +
                        " | Author: " + booklists[i].getAuthor() +
                        " | Subject: " + booklists[i].getSubject() +
                        " | Shelf: " + booklists[i].getLocationShelf());
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

    public static void logIn(User[] userLists) {
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
            if (userLists[i].getUserName().equals(userName))
                if (userLists[i].getPassword().equals(password)) {
                    System.out.println("Login Successful "  + userLists[i].getUserName() +" "+
                            "as"+ " " + userLists[i].getRole().name());
                    showSubMenu(userLists[i].getRole());
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
    public  static void createAccount(User[] userLists) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        userLists[currentUser++] = user;

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

        userLists[currentUser++] = user;
        System.out.println("Create Account Successful" + " " +user.getUserName());

    }
}


