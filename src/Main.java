import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private  static User[] userLists = new User[1000];
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
                case 1: browseBook(userLists);
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
    public  static void browseBook(User[] userLists) {
        System.out.println("pe");

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
                        System.out.println("Login Successful "  + userLists[i].getUserName()+" "+
                        "as"+ " "+ userLists[i].getRole());
                        userLists[i].getRole().showMenu();

                        found = true;
                        break;
                    }

            }
            if (!found){
                System.out.println("Invalid username or password");
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


