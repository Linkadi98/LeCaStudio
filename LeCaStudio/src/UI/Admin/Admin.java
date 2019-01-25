package UI.Admin;

public class Admin {
    private int idAdmin;
    private String loginAdmin;
    private String password;
    private String fullName;
    private int phoneNumber;
    private String email;
    private int permisson;
    private String note;



    public Admin(String loginAdmin, String password, String fullName, int phoneNumber, String email, int permisson, String note) {
        this.loginAdmin = loginAdmin;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.permisson = permisson;
        this.note = note;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermisson() {
        return permisson;
    }

    public void setPermisson(int permisson) {
        this.permisson = permisson;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }


}
