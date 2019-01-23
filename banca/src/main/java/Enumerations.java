

public class Enumerations {

    private Angajat.RolAngajat rolAngajat;

    public Enumerations(Angajat.RolAngajat rolAngajat){

        this.rolAngajat = rolAngajat;
    }


    public Angajat.RolAngajat alegereRolAngajat(){

        /*switch (rolAngajat){

            case CASIER:
                rolAngajat = Angajat.RolAngajat.CASIER;
                break;

            case AGENT_VANZARI:
                rolAngajat = Angajat.RolAngajat.AGENT_VANZARI;
                break;

            case DIRECTOR:
                rolAngajat = Angajat.RolAngajat.DIRECTOR;
                break;
        }*/

        return this.rolAngajat;
    }


}
