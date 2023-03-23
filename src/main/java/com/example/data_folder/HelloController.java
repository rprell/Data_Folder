package com.example.data_folder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HelloController {
    public TableView welcomeText;
    public TableColumn<Phone, Float> screenSizeColumn;
    public TableColumn<Phone, Integer> storageColumn;
    public TableColumn<Phone, String> processorColumn;
    public TableColumn<Phone, String> chargerTypeColumn;
    public TableColumn<Apple, String> LiDARColumn;


    public void initialize() throws Exception {
        restoreOrReadData();

        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<>("screenSize"));
        storageColumn.setCellValueFactory(new PropertyValueFactory<>("storage"));
        processorColumn.setCellValueFactory(new PropertyValueFactory<>("processor"));
        chargerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("chargerType"));
        LiDARColumn.setCellValueFactory(new PropertyValueFactory<>("LiDAR"));

        screenSizeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        storageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        processorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        chargerTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LiDARColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        screenSizeColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Phone, Float> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Phone filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setScreenSize(t.getNewValue());
                });
        storageColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Phone, Integer> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Phone filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setStorage(t.getNewValue());
                });
        processorColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Phone, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Phone filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setProcessor(t.getNewValue());
                });
        chargerTypeColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Phone, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Phone filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setChargerType(t.getNewValue());
                });
        LiDARColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Apple, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Apple filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setLiDAR(t.getNewValue());
                });
    }

    public void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedPhoneList");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> temporaryList = new ArrayList<>(welcomeText.getItems());
        out.writeObject(temporaryList);

        out.close();
        fileOut.close();
    }

    public void restoreOrReadData() throws Exception {
        try {
            FileInputStream fileIn = new FileInputStream("SavedPhoneList");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Phone.setPhone((ArrayList<Phone>)in.readObject());
            in.close();
            fileIn.close();
        } catch (Exception exception) {
            Apple.readAppleData();
            System.out.println("Tried to read");
            System.out.println(Phone.getPhones());
        }

        ArrayList<Phone> temporaryList = (ArrayList<Phone>) Phone.getPhones();
        ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
        welcomeText.setItems(temporaryObservableList);
    }
}