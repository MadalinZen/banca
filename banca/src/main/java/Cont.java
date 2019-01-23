

public class Cont {

    protected String IBAN;
    protected Double balanta;

    public Cont(String IBAN){

        setIBAN(IBAN);
        setBalanta(0d);
    }

    public Cont(String IBAN,Double balanta){

        setIBAN(IBAN);
        setBalanta(balanta);
    }

    public void setIBAN(String IBAN){

        this.IBAN = IBAN;
    }

    public String getIBAN(){

        return IBAN;
    }

    private void setBalanta(Double balanta){

        this.balanta = balanta;
    }

    public Double getBalanta(){

        return this.balanta;
    }

    public Double modificaBalanta(Double delta){

        if (balanta + delta >0){

            balanta += delta;
        }

        return this.balanta;
    }


    @Override
    public String toString(){

        return "{Cont IBAN " + this.getIBAN() + " balanta " + this.getBalanta()+ " }";
    }
}
