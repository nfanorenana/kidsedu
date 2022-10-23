package mg.m1p9.kidsedu.model;

public class SignInBody {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SignInBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
