

public class Persoana {

    protected String nume;
    protected String CNP;

    public Persoana(){}

    public Persoana(String nume,String CNP){

        setNume(nume);
        setCNP(CNP);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
