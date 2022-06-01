package test.Database;

import test.model.Flight;
import java.util.HashMap;


public class Database {

    private static Database databaseInstance;

    private HashMap<String,Flight> flightMap = new HashMap<>();



    private Database() {}

    public static Database getInstance() {
        if( databaseInstance == null){
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    public HashMap<String,Flight> getFlightMap(){
        return flightMap;
    }

}
