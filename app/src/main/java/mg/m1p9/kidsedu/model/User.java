package mg.m1p9.kidsedu.model;

public class User {


    String name;
    String username;
    String birthdate;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String username, String birthdate, String email, String password) {
        this.name = name;
        this.username = username;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }
}
