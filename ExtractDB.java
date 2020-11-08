package com.dbtotext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class ExtractDB {

    /*
    You can use this app to export data from SQL database to txt file and to use it latter as DB for spamming (1 line per output).
    Furthermore I created e few methods that either create random values from scratch or random-pick from existing source.
     */

    public static  String telBr(){
        String broj = "";
        Random random = new Random();
        String [] operatori = {"070","071","072","075","076","077"};
        int operator = random.nextInt(4)+1;
        int test = random.nextInt(8)+1;
        StringBuilder sb = new StringBuilder();
        sb.append(operatori[operator]);
        sb.append(String.valueOf(test));
        broj = sb.toString();

        return broj;
    }
    public static String randomGrad(){
        String grad = "";
        String[] gradovi = {"Skopje","Gostivar","Aracinovo","Tetovo","Bitola","Prilep","Strumica","Veleshta","Kumanovo","Debar","Kicevo","Ohrid","Struga","Debar","Pehcevo","Podrzi Konj","Veles","Gevgelija","Kavadarci",
                "Negotino","Valandovo","Kondovo"};
        Random random = new Random();
        int test = random.nextInt(20)+1;
        grad = gradovi[test];

        return grad;
    }
    public static String datumNaRagjanje(){
        String datum = "";
        int den = 0;
        int mesec = 0;
        int godina = 0;
        int upperBound = 2004;
        int lowerBound = 1948;


        Random random = new Random();
        den = random.nextInt(29) + 1;
        mesec = random.nextInt(11) + 1;
        godina = random.nextInt(upperBound-lowerBound) + lowerBound;

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(den));
        sb.append("/");
        sb.append(Integer.toString(mesec));
        sb.append("/");
        sb.append(Integer.toString(godina));
        datum = sb.toString();


        return datum;
    }

    public static String profesija(){
        String profesija = "";
        int test = 0;
        String[] profesii = {"doktor","masinovozac","traktorist","kranist","distributer","doktor po pravo","inziner","programer","ucitel","grobar","bocvar","nalanzdija","poet","umetnik slikar","striptizer",
                "anonimus","svesteno lice","frizer","kazandzija","front end developer","profesor na fakultet"};
        Random random = new Random();
        test = random.nextInt(19)+1;
        profesija = profesii[test];

        return profesija;
    }
    public static String mejl(String ime, String prezime){
        String mejl = "";
        String[] hosts = {"@gmail.com","@yahoo.com","@hotmail.com"};
        Random random = new Random();
        int test = random.nextInt(3);
        StringBuilder sb = new StringBuilder();
        sb.append(ime);
        sb.append(prezime);
        sb.append(hosts[test]);
        mejl = sb.toString().toLowerCase();


        return mejl;
    }



    public static void main(String[] args) {


        String username = "sa";
        String password = "test";
        String dbURL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName = hidden";//replace this with your DB
        Connection connection = null;
        PreparedStatement statement = null;
        ArrayList<String>db = new ArrayList<>();


        //query
        String QUERY_CLEN = "SELECT * FROM hidden";//replace this query
        String zp = "";
        String prezime = "";
        String ime = "";
        String telefon = "";
        String datumNaRagjanje = "";
        String adresa = "";
        String strucnoZvanje = "";
        String rabotodavac = "";
        String mejl = "";
        String zip = "";
        String testTel = "";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("outputDB.txt"));
            connection = DriverManager.getConnection(dbURL,username,password);
            statement = connection.prepareStatement(QUERY_CLEN);
            ResultSet results = statement.executeQuery();

                        while (results.next()){
                    ime = results.getString("ime");
                    prezime = results.getString("prezime");
                    adresa = results.getString("adresa");
                    testTel = results.getString("broj");
                    if(testTel.length() == 5){
                        telefon = telBr() + testTel;
                    }else if(testTel.length() == 6){
                        telefon = telBr6() + testTel;
                    }
                    zp = randomGrad();
                    datumNaRagjanje = datumNaRagjanje();            //16/02/2019 is the format
                    strucnoZvanje = profesija();
                    rabotodavac = rabotodavac();
                    mejl = mejl(ime, prezime);

                            db.add(ime);
                            db.add(prezime);
                            db.add(adresa);
                            db.add(telefon);
                            db.add(zp);
                            db.add(datumNaRagjanje);
                            db.add(strucnoZvanje);
                            db.add(rabotodavac);
                            db.add(mejl);

                        }
            String strToWrite  = "";
            String strToRetrieve = "";
            for (int i = 0; i< db.size(); i++){

                    strToRetrieve = db.get(i);
                    strToWrite = strToRetrieve;
                System.out.println(strToWrite);
                    writer.write(strToWrite);
                    writer.newLine();
                    writer.flush();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String rabotodavac() {
        String rabotodavac = "";
        String [] rabotodavaci = { "Uciliste","Min za kultura", " zdravstvo","Min za pravda","Uciliste", "Pazari","Trejd Kom Fijasko","privatno","cuvar zatvor","frizernica","nevraboten","nemam rabota","stecaec","kelner","/",
                "nema","nemam"};
        Random random = new Random();
        int test = random.nextInt(15);
        rabotodavac = rabotodavaci[test];
        return rabotodavac;
    }

    private static String telBr6() {
        String broj = "";
        Random random = new Random();
        String [] operatori = {"070","071","072","075","076","077"};
        int operator = random.nextInt(5);
        StringBuilder sb = new StringBuilder();
        sb.append(operatori[operator]);
        broj = sb.toString();

        return broj;
    }


}
