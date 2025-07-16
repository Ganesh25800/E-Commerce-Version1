public class SessionManager {
    public static User currentUser = null;

    public static void setCurrectUser(User user) {
        currentUser = user;
    }

    public static User getCurrectUser() {
        return currentUser;
    }

    public static void removeCurrectUser() {
        currentUser = null;
    }

    public static String getUserFirstName(){
        return currentUser.getFirstName();
    }
    public static String getUserLastName(){
        return currentUser.getLastName();
    }
    public static String getUserEmail(){
        return currentUser.getEmail();
    }
    public static String getUserPassword(){
        return currentUser.getPassword();
    }
    public static String getUserId(){
        return currentUser.getUserId();
    }
    public static void setUserId(String userId) {
        currentUser.setUserId(userId);
    }
    public static void setUserFirstName(String userFirstName) {
        currentUser.setFirstName(userFirstName);
    }
    public static void setUserLastName(String userLastName) {
        currentUser.setLastName(userLastName);
    }
    public static void setUserEmail(String userEmail) {
        currentUser.setEmail(userEmail);
    }
    public static void setUserPassword(String userPassword) {
        currentUser.setPassword(userPassword);
    }
}
