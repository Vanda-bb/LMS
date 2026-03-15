public class User {
    //Attributes
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Role role;
    private boolean active = true;
    private int maxBorrowLimit = 3;
    private int currentBorrow = 0;

    //Method
    //Default Constructors with default values
    public User(){
        this.userId = "";
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.email = "";
        this.password = "";
        this.role = Role.ADMIN;
        this.active = true;
        this.maxBorrowLimit = 3;
    }
    //Non-default constructors
    public User(String userId, String firstName, String lastName, String userName, String email, String password, Role role,boolean active, int maxBorrowLimit){
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        setRole(role);
        this.active = active;
        this.maxBorrowLimit = maxBorrowLimit;
    }
    //Getter
    public String getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    public boolean isActive() {
        return active;
    }
    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //Setter
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean setFirstName(String firstName){
        if (firstName == null||firstName.isEmpty()) {
            return false;
        } else {
            this.firstName = firstName;
            return true;
        }
    }
    public boolean setLastName(String lastName){
        if (lastName == null||lastName.isEmpty()) {
            return false;
        } else {
            this.lastName = lastName;
            return true;
        }
    }
    public boolean setUserName(String userName){
        if (userName == null||userName.isEmpty()) {
            return false;
        } else {
            this.userName = userName;
            return true;
        }
    }
    public boolean setEmail(String email){
        if ( email != null && email.contains("@")){
            this.email = email;
            return true;
        }else{
            System.out.println("Invalid Email");
            return false;
        }
    }
    public boolean setPassword(String password){
        String strongRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        if ( password == null ||password.isEmpty()){
            System.out.println("Password cannot be empty!!");
            return false;
        } else if (!password.matches(strongRegex)) {
            System.out.println("Invalid Password!");
            return false;
        }else {
            this.password = password;
            return true;
        }

    }
    public boolean setRole(Role role){
        if (role == null){
            return false;
        }else{
            this.role = role;
            return true;
        }
    }

    public void setActive(boolean active){
        this.active = active;
        System.out.print(active ? "Yes" : "No");
    }

    public void setMaxBorrowLimit(int maxBorrowLimit) {
        if (currentBorrow >=maxBorrowLimit){
            System.out.println("You cannot borrow more than " + maxBorrowLimit + "items!");

        }else {
            currentBorrow++;
            System.out.println("Item borrowed successfully!! You now have "+ currentBorrow +" items!");
        }
    }
    //Behavioral Methods
    public boolean canBorrow(int currentBorrowCount){
        return  currentBorrowCount >= maxBorrowLimit && active;
    }
    public void deactivate(){
        active = false;
    }
    public void activate(){
        active = true;
    }
}

