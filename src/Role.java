import java.util.Scanner;

public enum Role {
    ADMIN{
        @Override
        public void showMenu(){
            System.out.println("------ADMIN MENU------");
            System.out.println("1. User Management");
            System.out.println("2. Book Management");
            System.out.print("Select an option: ");
        }
    },
    STUDENT{
        @Override
        public void showMenu(){
            System.out.println("------STUDENT MENU------");
            System.out.println("1. Borrow Book ");
        }
    },
    TEACHER{
        @Override
        public void showMenu(){
            System.out.println("------TEACHER MENU------");
            System.out.println("1. Borrow Book ");
        }
    },
    LIBRARIAN{
        @Override
        public void showMenu(){
            System.out.println("------LIBRARIAN MENU------");
            System.out.println("1. Add Book ");
            System.out.println("2. Update Book Information");
            System.out.println("3. Delete Book");
        }
    };
    public abstract void showMenu();

}
