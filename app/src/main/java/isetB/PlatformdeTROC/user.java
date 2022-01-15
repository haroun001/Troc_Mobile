package isetB.PlatformdeTROC;

public class user {
    private int id;



    private String Nom;
    private String EMAIL;
    private String PASSWORD;


    public user(int id,String nom , String EMAIL, String PASSWORD) {
        this.id = id;
        this.Nom=nom;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
    }

    public user() {
    }

    public user(String nom, String email, String password) {

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}