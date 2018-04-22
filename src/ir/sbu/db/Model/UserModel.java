package ir.sbu.db.Model;

public class UserModel {
    private long id;
    private String aliasName;
    private String state;
    private String email;

    public UserModel() {
    }

    public UserModel(long id, String aliasName, String state, String email) {
        this.id = id;
        this.aliasName = aliasName;
        this.state = state;
        this.email = email;
    }

    public UserModel(String aliasName, String state, String email) {
        this.aliasName = aliasName;
        this.state = state;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
