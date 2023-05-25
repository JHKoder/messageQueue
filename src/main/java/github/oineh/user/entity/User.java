package github.oineh.user.entity;

public class User  {
    private final String id;
    private final String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public boolean isId(User targerUser){
        return this.getId().equals(targerUser.getId());
    }
}
