

import java.util.Random;

public class Client extends Persoana {

    private Cont cont;

    Integer IBANSuffix;

    public Client(String nume,String CNP){
        super(nume,CNP);
        generateRandomNumber();
        this.cont = new Cont(CNP + IBANSuffix);
    }

    public Cont getCont() {
        return cont;
    }

    public Double alimentareCont(Double suma){

        if (suma > 0 ){

            this.cont.modificaBalanta(suma);
        }

        return this.cont.getBalanta();
    }

    public Double retragere(Double suma){

        if (suma > 0 ){

            this.cont.modificaBalanta(-suma);
        }

        return this.cont.getBalanta();
    }

    public void generateRandomNumber(){

        Random random = new Random();
        IBANSuffix = random.nextInt(9000);
        IBANSuffix += 1000;
    }

    @Override
    public boolean equals(Object obj){

        if (obj instanceof Client){

            return false;
        }

        Client concreteObj = (Client)   obj;

        if (this.CNP.equals(concreteObj.CNP)){

            return true;
        }

        return false;
    }

    @Override
    public String toString(){

        return "{ Client nume : " + this.getNume() + ", CNP : " + this.getCNP() + ", IBAN : " + this.cont.getIBAN() +", SOLD : " + this.cont.getBalanta()+ "} ";
    }
}
