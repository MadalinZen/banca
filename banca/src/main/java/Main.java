

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Banca banca = new Banca();
//
//        Banca bancaING = new Banca();
//
//        Angajat angajat = new Angajat("Stefan","123456789",banca,Angajat.RolAngajat.AGENT_VANZARI,"8fy89gyb8fghifg");
//
//        Angajat angajat2 = new Angajat("Veronica","287124343454",banca,Angajat.RolAngajat.AGENT_VANZARI,"fjghfugfhfh67fgh");
//
//        Angajat director = new Angajat("Lila","2335446789",bancaING,Angajat.RolAngajat.DIRECTOR,"fgh7gh8g");
//
////        Persoana persoana = new Persoana("Vasile","1234657687");
//
//        banca.adaugaAngajat(angajat);
//        banca.adaugaAngajat(angajat2);
//        banca.adaugaAngajat(director);
//        bancaING.adaugaAngajat(director);
//
//
//        System.out.println(banca);
//
//        banca.stergeAngajat("123456789");
//
//        System.out.println(banca);
//
//        Client client1 = new Client("George","1234567");
//
//
//        client1.alimentareCont(969.0);
//        client1.retragere(555.5);
//        System.out.println(client1.getCont());
//
//        System.out.println(client1.toString());
//        System.out.println(client1.IBANSuffix);
//
//        angajat2.deschidereCont(client1);
//
//        Client client3 = new Client("Marc","1456");
//        client3.alimentareCont(9999.9);
//        client3.retragere(3333.3);
//        System.out.println(client3.getCont());
//        System.out.println(client1);
//        System.out.println(client3);
//        System.out.println("***********");
//        angajat2.inchidereCont(client3);
//        System.out.println(banca.getClienti());

        Scanner scan = new Scanner(System.in);
        Banca banca = new Banca();
        Angajat angajat = new Angajat("Gloria", "23456", banca, Angajat.RolAngajat.AGENT_VANZARI, "56hgf");
        banca.adaugaAngajat(angajat);


        while (true) {

            afiseazaMeniu();
            Integer optiune = scan.nextInt();

            switch (optiune) {

                case 1:
                    adaugaAngajat(scan, banca);
                    break;
                case 2:
                    stergeAngajat(scan, angajat, banca);
                    break;
                case 3:
                    adaugaClient(scan, angajat);
                    break;
                case 4:
                    stergeClient(scan, angajat, banca);
                    break;
                case 5:
                    afiseazaClienti(banca);
                    break;
                case 6:
                    afiseazaAngajati(banca);
                    break;
                case 7:
                    retragere(scan, banca);
                    break;
                case 8:
                    depunere(scan, banca);
                    break;
                case 9:
                    interogareSold(scan, banca);
                    break;
                case 10:
                    scan.close();
                    return;
                default:
                    System.err.println("Optiune inexistenta/neimplementata. Incearca din nou.");
            }
        }


    }

    public static void afiseazaMeniu() {

        System.out.println("1. Adauga angajat ");
        System.out.println("2. Sterge angajat ");
        System.out.println("3. Adauga client ");
        System.out.println("4. Sterge client ");
        System.out.println("5. Afisare clienti ");
        System.out.println("6. Afisare angajati  ");
        System.out.println("7. Retragere ");
        System.out.println("8. Depunere ");
        System.out.println("9. Interogare sold ");
        System.out.println("10. Iesire ");
        System.out.println("Introduceti optiunea !");

    }

    public static void adaugaAngajat(Scanner scan, Banca banca) {

        System.out.println("Introduceti numele ");
        String nume = scan.next();
        System.out.println("Introduceti CNP ");
        String cnp = scan.next();
        System.out.println("Selectati rolul angajatului : ");
        System.out.println("1. CASIER ");
        System.out.println("2. AGENT_VANZARI ");
        System.out.println("3. DIRECTOR ");

        Enumerations casier = new Enumerations(Angajat.RolAngajat.CASIER);
        //casier.alegereRolAngajat();
        Enumerations agentVanzari = new Enumerations(Angajat.RolAngajat.AGENT_VANZARI);
        //agentVanzari.alegereRolAngajat();
        Enumerations director = new Enumerations(Angajat.RolAngajat.DIRECTOR);
        //director.alegereRolAngajat();


        Integer option = scan.nextInt();

        Angajat.RolAngajat rolAngajat = Angajat.RolAngajat.getByValue(option);

        System.out.println("Rol angajat = " + rolAngajat);


        System.out.println("Introduceti codul angajatului ");
        String codAngajat = scan.next();

        Angajat angajat = new Angajat(nume, cnp, banca, rolAngajat, codAngajat);
        System.out.println("A fost adaugat angajatul : " + angajat);

        banca.adaugaAngajat(angajat);

    }

    public static void stergeAngajat(Scanner scan, Angajat angajat,Banca banca) {

        System.out.println("Intriduceti optiunea : ");
        System.out.println("1. Stergere angajat dupa CNP : ");
        System.out.println("2. Stergere angajat dupa Angajat : ");

        Integer option ;

        option = scan.nextInt();

        if (option == 1){

            System.out.println(" Introduceti CNP ");

            System.out.println("cnp : ");
            String cnp = scan.next();

            System.out.println("CNP-ul angajatului ce va fi sters : " + cnp);

            banca.stergeAngajat(cnp);
        }else if (option == 2 ){

            banca.stergeAngajat(angajat);

            System.out.println("Angajatul ce a fost sters : "+ angajat.toString());
        }

    }

    public static void afiseazaAngajati(Banca banca) {

        System.out.println(banca.getAngajati());
    }

    public static void adaugaClient(Scanner scan, Angajat angajat) {

        System.out.println("Introduceti numele ");
        String nume = scan.next();
        System.out.println("CNP");
        String CNP = scan.next();
        Client client = new Client(nume, CNP);
        angajat.deschidereCont(client);
        System.out.println("A fost creat clientul : " + client);
    }

    public static void afiseazaClienti(Banca banca) {

        System.out.println(banca.getClienti());
    }

    public static void stergeClient(Scanner scan, Angajat angajat, Banca banca) {

        System.out.println("1. Sterge cleint dupa CNP ");
        System.out.println("2. Sterge client dupa IBAN ");
        System.out.println("Introduceti optiunea ");

        Integer optiune = scan.nextInt();

        Client client = null;

        if (optiune == 1) {

            System.out.println("cnp ");
            String cnp = scan.next();
            client = banca.cautareClientDupaCNP(cnp);
        } else if (optiune == 2) {

            System.out.println("iban ");
            String iban = scan.next();
            client = banca.cautareClientDupaIBAN(iban);
        }

        if (client == null) {

            System.err.println("Nu am gasit clientul respectiv");
        }

        angajat.inchidereCont(client);
        System.out.println("A fost inchis contul clientului " + client);
        banca.stergeClient(client);
        System.out.println("A fost sters clientul " + client);
    }


    public static void depunere(Scanner scan,Banca banca) {

        System.out.println("1. Depunere dupa CNP ");
        System.out.println("2. Depunere dupa IBAN");

        System.out.println("Introduceti optiunea ");
        Integer option = scan.nextInt();
        Client client = null;

        if (option == 1) {

            System.out.println("CNP : ");
            String cnp = scan.next();

            client = banca.cautareClientDupaCNP(cnp);

        } else if (option == 2) {

            System.out.println("IBAN : ");
            String iban = scan.next();

            client = banca.cautareClientDupaIBAN(iban);
        }

        if (client == null) {

            // nu am gasit clientul cu acel iban
            System.err.println("Contul nu exista ");
            return;
        }

        System.out.println("Suma : ");
        Double suma = scan.nextDouble();
        client.alimentareCont(suma);

    }

    public static void retragere(Scanner scan,Banca banca) {

        System.out.println("1. Retragere dupa CNP ");
        System.out.println("2. Retragere dupa IBAN");

        System.out.println("Introduceti optiunea ");

        Integer optiune = scan.nextInt();

        Client client = null;

        if (optiune == 1) {
            System.out.println("CNP : ");
            String cnp = scan.next();
            client = banca.cautareClientDupaCNP(cnp);
            System.out.println("Retragere suma");

        } else if (optiune == 2) {

            System.out.println("IBAN : ");
            String iban = scan.next();
            client = banca.cautareClientDupaIBAN(iban);
            System.out.println("Retragere suma ");
        }

        if (client == null) {

            System.err.println("Nu am gasit contul ");
        }

        Double suma = scan.nextDouble();
        client.retragere(suma);
        System.out.println(client.getCont());
    }

    public static void interogareSold(Scanner scan,Banca banca) {

        System.out.println("1. Interogare sold dupa CNP ");
        System.out.println("2. Interogare sold dupa IBAN");

        System.out.println("Introduceti optiunea ");

        Integer optiune = scan.nextInt();

        Client client2 = null;

        if (optiune == 1) {
            System.out.println("CNP : ");
            String cnp = scan.next();
            client2 = banca.cautareClientDupaCNP(cnp);


        } else if (optiune == 2) {

            System.out.println("IBAN : ");
            String iban = scan.next();
            client2 = banca.cautareClientDupaIBAN(iban);

        }

        if (client2 == null) {

            System.err.println("Nu am gasit contul ");
        }

        System.out.println(client2.getCont());

    }


}
