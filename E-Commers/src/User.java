public class User {

    private String FirstName;
    private String LastName;
    private String Email;
    private String UserId;
    private String Password;

    public User() {

    }

    public User(String FirstName, String LastName, String Email, String UserId, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.UserId = UserId;
        this.Password = Password;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getEmail() {
        return Email;
    }
    public String getUserId() {
        return UserId;
    }
    public String getPassword() {
        return Password;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
