package Objects;

public class Admin {
    private String idAdmin;
    private String loginName;
    private String password;
    private String fullName;
    private String note;
    private int phoneNumber;
    private String email;
    private int permission;

    public Admin(String idAdmin, String loginName, String password, String fullName, String note, int phoneNumber, String email, int permission) {
        this.idAdmin = idAdmin;
        this.loginName = loginName;
        this.password = password;
        this.fullName = fullName;
        this.note = note;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.permission = permission;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
