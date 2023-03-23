package com.example.data_folder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Samsung extends Phone {
    private String externalMemory;

    private String fingerPrint;

    private int ram;


    public Samsung(String phoneType, int storage, float screenSize, String processor, int price, String chargerType, String externalMemory, String fingerPrint, int ram) {
        super(phoneType, storage, screenSize, processor, price, chargerType);
        this.setExternalMemory(externalMemory);
        this.setFingerPrint(fingerPrint);
        this.setRam(ram);
    }


    String getExternalMemory() {
        return externalMemory;
    }

    void setExternalMemory(String externalMemory) {
        this.externalMemory = externalMemory;
    }

    String getFingerPrint() {
        return fingerPrint;
    }

    void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    int getRam() {
        return ram;
    }

    void setRam(int ram) {
        this.ram = ram;
    }

    public String toString() {
        return "Samsung: Does samsung have external memory: " + externalMemory + ". Does Samsung have finger print: " + fingerPrint + ". How much Ram does Samsung have: " + ram + "GB."  + "The " + super.getPhoneType() + " has " + super.getStorage() + "GB of storage, a screen size of " + super.getScreenSize() + " inches, a " + super.getProcessor() + " processor, it uses the " + super.getChargerType() + "charger and costs $" + super.getPrice();
    }

    static void readSamsungData() throws FileNotFoundException {

        //creating File instance to reference text file in Java
        File file = new File("SamsungPhonesData");

        //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(file);


        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        int howMuchData = 0;
        ArrayList<ArrayList> allArrays = new ArrayList<>();
        while (scan.hasNextLine()) {
            ArrayList<String> dataArray = new ArrayList<>();
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\t");
            if (lineNumber == 1) {
                dataArray.add("Date");
            }
            while (lineScanner.hasNext()) {
                String data = lineScanner.next();
                dataArray.add(data);
                if (lineNumber == 1) {
                    howMuchData = howMuchData + 1;
                }
            }
            if (dataArray.size() > 1) {
                allArrays.add(dataArray);
            }
        }

        // go through allArrays and extract Data strings and create objects

        for (int index = 1; index < howMuchData ; index = index + 1) {
            String data = (String)allArrays.get(0).get(index);

            String screenSize = (String)allArrays.get(1).get(index);
            //new Apple(data);
        }
    }
}
