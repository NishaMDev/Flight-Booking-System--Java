package test.controller;

import test.Database.Database;
import test.helper.FileHelper;
import test.model.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;


public class DatasetController {
    private Database database = Database.getInstance();
    private FileHelper fileHelper;
    private String idx= "";

    public DatasetController(String path) throws IOException {
        fileHelper = new FileHelper(path);
    }

    public void datasetCreation() {
        try{
            fileHelper.fileReader(true);
        }catch (Exception e){
            System.out.println("The Dataset file path was not found. Please enter valid file path");
            System.exit(0);
        }
        readItems(fileHelper.getContentFile());
    }

    private void readItems(ArrayList<String> contentOfFile){
        for(int i=0;i<contentOfFile.size();i++){
            String[] splitItem = contentOfFile.get(i).split(",");
            idx = splitItem[0].toLowerCase().concat(splitItem[1]);
            database.getFlightMap().put(idx, new Flight(splitItem[0],splitItem[1],Integer.parseInt(splitItem[2]),Double.parseDouble(splitItem[3]),splitItem[4],splitItem[5]));
        }
    }
}

