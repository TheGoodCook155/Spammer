package com.dbspammer;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Main {

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
        if (den<10) {
            sb.append("0");
            sb.append(Integer.toString(den));
        }else{
            sb.append(Integer.toString(den));
        }
        sb.append("/");
        if(mesec < 10) {
            sb.append("0");
            sb.append(Integer.toString(mesec));
        }else{
            sb.append(Integer.toString(mesec));
        }
        sb.append("/");
        sb.append(Integer.toString(godina));
        datum = sb.toString();


        return datum;
    }
    static int firstPosition = 0;

    public static int currentPosition (int firstPosition){
        int position = 0;
        position = position + firstPosition;

        return position;
    }

    public static int increaseFirstPosition (int currentPosition){
        int position = currentPosition + 8;
        return position;
    }




    public static void spam() throws IOException {

        ArrayList<String> db = read();

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        for (int i = 1; i <= 50000; i++){

            System.out.println("First position before increment " + firstPosition);
            currentPosition(currentPosition(firstPosition));
            String ime = db.get(4 + currentPosition(firstPosition)) ;
            String prezime = db.get(0 + currentPosition(firstPosition)) ;
            String adresa = db.get(5 + currentPosition(firstPosition));
            String telefon = db.get(1 + currentPosition(firstPosition));
            String grad = db.get(6 + currentPosition(firstPosition));
            String datumNaRagjanje = datumNaRagjanje(); //I miscalculated the regex form of the date when I created the txt DB, so I won't be using the date from the DB, instead I created method to create random date
            String profesija = db.get(7 + currentPosition(firstPosition));
            String vrabotenKako = db.get(3 + currentPosition(firstPosition));
            String email = db.get(8 + currentPosition(firstPosition));


            System.setProperty("webdriver.chrome.driver", "D:\\Install\\JavaLibraries\\ChromeDriver\\v86\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("URL OF THE CONTACT FORM");
            try {
                Thread.sleep(4000);//Check your internet connection and calculate the time needed in order to load the page
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //You can use some refactoring here e.g. create method()
            WebElement searchBox = driver.findElement(By.name("fname"));
            searchBox.sendKeys(ime);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);



            WebElement searchBox2 = driver.findElement(By.name("lname"));
            searchBox2.sendKeys(prezime);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement searchBox3 = driver.findElement(By.name("nf-field-22"));
            searchBox3.sendKeys(datumNaRagjanje);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement searchBox4 = driver.findElement(By.name("address"));
            searchBox4.sendKeys(adresa);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);



            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement searchBox5 = driver.findElement(By.name("phone"));
            searchBox5.sendKeys(telefon);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement searchBox6 = driver.findElement(By.name("email"));
            searchBox6.sendKeys(email);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);



            WebElement click = driver.findElement(By.name("nf-field-13"));
            click.click();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);




            WebElement searchBox7 = driver.findElement(By.name("nf-field-23"));
            searchBox7.sendKeys(profesija);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement click2 = driver.findElement(By.name("nf-field-25"));
            click2.click();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);




            WebElement click3 = driver.findElement(By.name("nf-field-14"));
            click3.click();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);


            WebElement searchBox8 = driver.findElement(By.name("nf-field-15"));
            searchBox8.sendKeys(vrabotenKako);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //Submit
            // WebElement click4 = driver.findElement(By.id("nf-field-17"));
            // click4.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            firstPosition = increaseFirstPosition(firstPosition) + 1;
            driver.quit();

        }
    }



        public static ArrayList read() throws IOException {
             BufferedReader reader = new BufferedReader(new FileReader("FinalDB.txt"));
             ArrayList<String> db = new ArrayList<>();
             String str = "";
            int index = 0;
            while (reader.readLine() != null){
                str = reader.readLine();
                db.add(index, str);
                index++;
            }
            return db;
        }








    public static void main(String[] args) throws InterruptedException, IOException {

        spam();

    }

}
