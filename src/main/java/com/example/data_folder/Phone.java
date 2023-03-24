package com.example.data_folder;

import java.util.ArrayList;

public class Phone {

    private static ArrayList<Phone> phones = new ArrayList<>();
    private int storage;
    private float screenSize;
    private int price;
    private String processor;
    private String chargerType;
    private String phoneType;

    public Phone(int storage, float screenSize, String processor, String chargerType) {
        this.setStorage(storage);
        this.setScreenSize(screenSize);
        this.setProcessor(processor);
        this.setChargerType(chargerType);
        phones.add(this);
    }


    public Phone(String phoneType, int storage, float screenSize, String processor, int price, String chargerType) {
        this.setStorage(storage);
        this.setScreenSize(screenSize);
        this.setProcessor(processor);
        this.setPrice(price);
        this.setChargerType(chargerType);
        this.setPhoneType(phoneType);
        phones.add(this);
    }


    public static ArrayList<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(ArrayList<Phone> phones) {
        Phone.phones = phones;
    }

    public static void readAllData() {
    }

    public static void setPhone(ArrayList<Phone> readObject) {
    }

    public static void getPhone() {
    readAllData();
    }


        int getStorage () {
            return storage;
        }

        void setStorage ( int storage){
            this.storage = storage;
        }

        float getScreenSize () {
            return screenSize;
        }

        void setScreenSize ( float screenSize){
            this.screenSize = screenSize;
        }

        int getPrice () {
            return price;
        }

        void setPrice ( int price){
            this.price = price;
        }

        String getProcessor () {
            return processor;
        }

        void setProcessor (String processor){
            this.processor = processor;
        }

        String getChargerType () {
            return chargerType;
        }

        void setChargerType (String chargerType){
            this.chargerType = chargerType;
            this.phoneType = phoneType;
        }
        String getPhoneType () {
            return phoneType;
        }

        void setPhoneType (String phoneType){
            this.phoneType = phoneType;
        }


 }