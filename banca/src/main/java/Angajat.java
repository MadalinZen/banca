

public class Angajat extends Persoana {

    public enum RolAngajat {
        CASIER(1), AGENT_VANZARI(2), DIRECTOR(3);

        private int val;

         RolAngajat(int val){
            this.val = val;
        }

        public static RolAngajat getByValue(int val){
            switch (val){
                case 1: return CASIER;
                case 2: return AGENT_VANZARI;
                case 3: return DIRECTOR;
            }
            return null;
        }

        public  int getValue(){
            return this.val;
        }
    }

    private RolAngajat rolAngajat;
    protected String codAngajat;
    private Banca banca;

    public Angajat(String nume, String CNP,Banca banca, RolAngajat rolAngajat, String codAngajat) {
        super(nume, CNP);
        setRolAngajat(rolAngajat);
        setCodAngajat(codAngajat);
        this.banca = banca;
    }


    public void setRolAngajat(RolAngajat rolAngajat) {

        this.rolAngajat = rolAngajat;
    }

    public RolAngajat getRolAngajat() {

        return this.rolAngajat;
    }

    public String getCodAngajat() {
        return codAngajat;
    }

    public void setCodAngajat(String codAngajat) {
        this.codAngajat = codAngajat;
    }


    public String deschidereCont(Client client) {

        if (getRolAngajat() != RolAngajat.AGENT_VANZARI) {

            return null;
        }

        banca.getClienti().add(client);

       return client.getCont().getIBAN();
    }

    public Boolean inchidereCont(Client client){

        if ( (getRolAngajat() != RolAngajat.AGENT_VANZARI) || (getRolAngajat() != RolAngajat.DIRECTOR)  ){

            return null;
        }

        return banca.getClienti().remove(client);
    }



    @Override
    public boolean equals(Object obj){

        if (!(obj instanceof  Angajat)){

            return false;
        }

        Angajat concreteObj = (Angajat) obj;

        if (this.CNP.equals(concreteObj.getCNP())){

            return true;
        }

        return false;
    }

    @Override
    public String toString(){

        return "{Angajat nume : " + this.getNume() +
                ", rol : " + this.getRolAngajat() +
                ", cod : " + this.getCodAngajat() + "}";
    }




}