package ra.model;

public class User {
    private int id;
    private String fullName;
    private String userName;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean status = true;
    private int  role = 0;
    private Cart[] carts = new Cart[10];

    public User() {
    }

    public User(int id, String userName, String password, int role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(int id, String fullName, String userName, String password, String address, String phoneNumber, String email, boolean status,int  role, Cart[] carts) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.role = role;
        this.carts = carts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }
}
