public class User {
    private String username;
    private String password;
    private boolean isSignIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isSignIn = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSignIn() {
        return isSignIn;
    }

    public void setSignIn(boolean signIn) {
        isSignIn = signIn;
    }
}
