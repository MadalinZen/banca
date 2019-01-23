

import java.util.LinkedList;

public class Banca {

    private LinkedList<Client> clienti;
    private LinkedList<Angajat> angajati;

    public Banca(){

        clienti = new LinkedList<>();
        angajati = new LinkedList<>();
    }

    public LinkedList<Client> getClienti(){

        return this.clienti;
    }

    public LinkedList<Angajat> getAngajati(){

        return this.angajati;
    }

    public void adaugaAngajat(Angajat a){

        this.angajati.add(a);
    }

    public void stergeAngajat(Angajat a){

        this.angajati.remove(a);
    }

    public void stergeAngajat(String CNP){

        for (int i = 0 ; i < angajati.size(); ++i){

            if (this.angajati.get(i).CNP.equals(CNP)){

                this.angajati.remove(i);

                break;
            }

        }
    }

    public void adaugaClient(Client client){

        this.clienti.add(client);
    }

    public void stergeClient(Client client){

        this.clienti.remove(client);
    }

    public Client cautareClientDupaIBAN(String iban){

        int i = 0 ;
        while( i < clienti.size()){

            Client aux = clienti.get(i);

            if (aux.getCont().getIBAN().equals(iban)){

                return aux;
            }

            ++i;
        }

        return null;
    }
    public Client cautareClientDupaCNP(String cnp){


        for ( Client c : this.clienti) {

            if (c.getCNP().equals(cnp)){

                return c;
            }
        }

        return null;
    }

    @Override
    public String toString(){

        return "{Banca angajati : " + this.angajati + "clienti " + this.clienti + " }";
    }
}
