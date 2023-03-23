package com.example.data_folder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Apple extends Phone {

    private String faceTime;
    private String applePay;
    private String faceID;
    private String LiDAR;


    public Apple(float screenSize, int storage, String processor, String chargerType, String LiDAR) {
        super(storage, screenSize, processor, chargerType);
        this.faceTime = faceTime;
        this.applePay = applePay;
        this.faceID = faceID;
        this.LiDAR = LiDAR;
    }

    String getFaceTime() {
        return faceTime;
    }

    void setFaceTime(String faceTime) {
        this.faceTime = faceTime;
    }

    String getApplePay() {
        return applePay;
    }

    void setApplePay(String applePay) {
        this.applePay = applePay;
    }

    String getFaceID() {
        return faceID;
    }

    void setFaceID(String faceID) {
        this.faceID = faceID;
    }

    String getLiDAR() {
        return LiDAR;
    }

    void setLiDAR(String liDAR) {
        LiDAR = liDAR;
    }

    public String toString() {
        return "APPLE: The " + super.getPhoneType() + " has " + super.getStorage() + "GB of storage, a screen size of " + super.getScreenSize() + " inches, a " + super.getProcessor() + " processor, it costs " + super.getPrice() + ", and uses a " + super.getChargerType() + " charger. It is " + faceTime + " that it uses FaceTime. It is " + applePay + " that it uses applepay. It is " + faceID + " that it uses FaceID. It is " + LiDAR + "that it uses LiDAR.";
    }

    static void readAppleData() throws FileNotFoundException {
        File file = new File("Apple Phones Data");
        Scanner scan = new Scanner(file);

        ArrayList<ArrayList> allArrays = new ArrayList<>();
        while (scan.hasNextLine()) {
            ArrayList<String> dataArray = new ArrayList<>();
            String line = scan.nextLine();
            //System.out.println("line " + lineNumber + " :" + line);

            Scanner barScanner = new Scanner(file);

            barScanner.useDelimiter("\t");

            while (barScanner.hasNext()) {
                String data = barScanner.next();
                dataArray.add(data);
            }
            if (dataArray.size() > 1) {
                allArrays.add(dataArray);
            }

            System.out.println(allArrays);
            System.out.println("BREAK");
            for (int index = 1; index < allArrays.size() ; index = index + 1) {
                String screenSizeWithIn = (String) allArrays.get(0).get(index);
                System.out.println(screenSizeWithIn);
                screenSizeWithIn = screenSizeWithIn.substring(0, screenSizeWithIn.indexOf(" "));
                System.out.println(screenSizeWithIn);
                Float screenSize = Float.valueOf(screenSizeWithIn);

                String storagewithB = (String) allArrays.get(1).get(index);
                storagewithB = storagewithB.substring(0,storagewithB.indexOf(" "));
                Integer storage = Integer.valueOf(storagewithB);
                String processor = (String)allArrays.get(3).get(index);
                String chargerType = (String)allArrays.get(4).get(index);
                String LiDAR = (String)allArrays.get(2).get(index);

                // String phoneType, int storage, float screenSize, String processor, int price, String chargerType, String faceTime, String applePay, String faceID, String liDAR
               new Apple(screenSize, storage, processor, chargerType, LiDAR);
                }

        }
    }

}





