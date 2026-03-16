import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
    //Browse Book
    private static void browseBook() {
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
    //login
    private static void logIn(ArrayList<User> userLists) {
        Scanner input = new Scanner(System.in);

        //UserName
        System.out.print("Enter UserName: ");
        String userName = input.nextLine();

        //Password

        System.out.print("Enter Password: ");
        String password = input.nextLine();


        boolean found = false;
        for (User u : userLists) {
            if (u.getUserName().equals(userName))
                if (u.getPassword().equals(password)) {
                    System.out.println("Login Successful "  + u.getUserName() +" "+
                            "as"+ " " + u.getRole().name());
                    showSubMenu(u.getRole());
                    found = true;
                    break;
                }

        }
        if (!found){
            System.out.println("Invalid username or password");
        }
    }
    //CreateAccount
    public  static void createAccount(ArrayList<User> userLists) {
        Scanner input = new Scanner(System.in);
        User user = new User();

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
        //generate random ID
        user.setUserId("A00"+ (userLists.size() +1));

        userLists.add(user);
        System.out.println("Create Account Successful" + " " +user.getUserName()+ " " +user.getUserId());

    }
    //Admin menu
    private  static void adminMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice !=-1) {
            System.out.println("-------Admin Menu-------");
            System.out.println("1. User Management");
            System.out.println("2. Book Management");
            System.out.println("3. LMS Menu");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1: userManagement();
                    break;
                case 2: bookManagement();
                    break;
                case 3: CreateMenu();
                    break;
                case -1:
                    System.out.println("Exiting Program....");
                    break;
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
            System.out.println("1. Browse Book");
            System.out.println("2. LMS Menu");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1: browseBook();
                    break;
                case 2: CreateMenu();
                    break;
                case -1:
                    System.out.println("Exiting Program....");
                    break;
                    default: System.out.println("Invalid choice");
                    break;
            }
        }
    }
    //Teacher Menu
    private static void teacherMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice !=-1) {
            System.out.println("-------Teacher Menu-------");
            System.out.println("1. Browse Book");
            System.out.println("2. LMS Menu");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1: browseBook();
                    break;
                case 3: CreateMenu();
                    break;
                case -1:
                    System.out.println("Exiting Program....");
                    break;
                default: System.out.println("Invalid choice");
                    break;
            }
        }
    }
    //Librarian Menu
    private static void librarianMenu(ArrayList<User> userLists) {
        int choice = 0;
        Scanner input = new Scanner (System.in);
        while (choice !=-1) {
            System.out.println("-------Librarian Menu-------");
            System.out.println("1. User Management");
            System.out.println("2. Book Management");
            System.out.println("3. LMS Menu");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1: userManagement();
                    break;
                case 2: bookManagement();
                    break;
                case 3: CreateMenu();
                    break;
                case -1:
                    System.out.println("Exiting Program....");
                    break;
                default: System.out.println("Invalid choice");
                    break;
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
            System.out.println("5. LMS Menu");
            System.out.println("5. Book Management");
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
                case 5: CreateMenu();
                    break;
                case 6: bookManagement();
                    break;
                case -1:
                    System.out.println("Exiting Program....");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    //Display User
    private static void displayUsers(){
        for (User user : userLists) {
            System.out.println(
                    " | User ID: " + user.getUserId() +
                            " | Username: " + user.getUserName() +
                            " | Role: " + user.getRole());
        }
    }
    //Update User
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

    //Delete User
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
            System.out.println("5. LMS Menu");
            System.out.println("6. User Management");
            System.out.println("-1 to Exit");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addBook();
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
                case 5: CreateMenu();
                    break;
                case 6: userManagement();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    //Add Book
    private static void addBook(){
        Scanner input = new Scanner (System.in);
        Book book = new Book();
        boolean valid = false;
        while (!valid) {
            //BookID
            System.out.print("Book ISBN-13:");
            valid = book.setIsbn13(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Title
            System.out.print("Book Title:");
            valid = book.setTitle(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Author
            System.out.print("Author: ");
            valid = book.setAuthor(Arrays.toString(new String[]{input.nextLine()}));
        }

        valid = false;
        while (!valid) {
            //Publication Year
            System.out.print("Year Publication: ");
            valid = book.setPublicationYear(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //language
            System.out.print("language: ");
            valid = book.setLanguage(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //available
            System.out.print("Available (YES/NO): ");
            String availableInput = input.nextLine().trim();
            valid = book.validateAvailable(availableInput);
        }

        valid = false;
        while (!valid) {
            //format
            System.out.print("Format:");
            valid = book.setFormat(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Page Count
            System.out.print("Page Count: ");
            valid = book.setPageCount(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Description
            System.out.print("Description: ");
            valid = book.setDescription(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Editor
            System.out.print("Editor: ");
            String editor = input.nextLine();
            valid = book.setEditor(editor);
        }

        valid = false;
        while (!valid) {
            //Subject
            System.out.print("Subject: ");
            String subject = input.nextLine();
            valid = book.setSubject(subject);
        }

        book.setBookId(listBook.size() + 1);
        listBook.add(book);
        System.out.println("Book Added Successfully");
    }

    //Update Book
    private static void updateBook() {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        Book book = null;

        while(!isValid){
            System.out.print("Enter Book ID to update: ");
            try{
                int bookId = Integer.parseInt(input.nextLine());
                for (Book eachBook : listBook) {
                    if (eachBook.getBookId() == bookId) {
                        book = eachBook;
                        break;
                    }
                }
                isValid = true;
            }catch (NumberFormatException e){
                System.out.println("Invalid Book ID!");
            }
        }

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        boolean valid = false;
        while (!valid) {
            //BookID
            System.out.print("New Book ISBN-13:");
            valid = book.setIsbn13(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Title
            System.out.print("New Book Title:");
            valid = book.setTitle(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Author
            System.out.print("New Author: ");
            valid = book.setAuthor(Arrays.toString(new String[]{input.nextLine()}));
        }

        valid = false;
        while (!valid) {
            //Publication Year
            System.out.print("New Year Publication: ");
            valid = book.setPublicationYear(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //language
            System.out.print("New language: ");
            valid = book.setLanguage(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //available
            System.out.print("New Available (YES/NO): ");
            String availableInput = input.nextLine().trim();
            valid = book.validateAvailable(availableInput);
        }

        valid = false;
        while (!valid) {
            //format
            System.out.print("New Format:");
            valid = book.setFormat(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Page Count
            System.out.print("New Page Count: ");
            valid = book.setPageCount(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Description
            System.out.print("New Description:");
            valid = book.setDescription(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Editor
            System.out.print("New Editor: ");
            valid = book.setEditor(input.nextLine());
        }

        valid = false;
        while (!valid) {
            //Subject
            System.out.print("New Subject: ");
            valid = book.setSubject(input.nextLine());
        }

        System.out.println("Book Update Successfully");
    }

    //Display Book
    private static void displayBook() {
        if (listBook.isEmpty()) {
            System.out.println("No book found!");
        }
        for (Book book : listBook) {
            System.out.println(
                    "| Book isbn13: " + book.getIsbn13() +
                            " | Title: " + book.getTitle() +
                            " | Author: " + Arrays.toString(book.getAuthor()) +
                            " | Year: " + book.getPublicationYear() +
                            " | Language: " + book.getLanguage() +
                            " | Available: " + (book.isAvailable() ? "YES" : "NO") +
                            " | Format: " + book.getFormat() +
                            " | Pages: " + book.getPageCount() +
                            " | Editor: " + Arrays.toString(book.getEditor()) +
                            " | Subject: " + book.getSubject()
            );
        }
    }

    //Delete Book
    private static void deleteBook(){
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        Book book = null;

        while(!isValid){
            System.out.print("Enter Book ID to delete: ");
            try{
                int bookId = Integer.parseInt(input.nextLine());
                for (Book eachBook : listBook) {
                    if (eachBook.getBookId() == bookId) {
                        book = eachBook;
                        break;
                    }
                }
                isValid = true;
            }catch (NumberFormatException e){
                System.out.println("Invalid Book ID!");
            }
        }

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        listBook.remove(book);
        System.out.println("Book Delete Successfully");
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

}


