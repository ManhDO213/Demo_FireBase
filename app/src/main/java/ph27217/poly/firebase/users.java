package ph27217.poly.firebase;

public class users {
    private int id;
    private String username, email, passwd;

    public users(int id, String username, String email, String passwd) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwd = passwd;
    }

    // bat buoc tao
    public users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
