package assembler;

import gui.GUIApp;
import persistence.FlightStorageService;
import persistence.PersistenceFactory;

public class Assembler {

    private PersistenceFactory persistenceFactory;

    public static void main(String[] args) {

        //Persistance layer
        FlightStorageService flightStorageService = PersistenceFactory.createFlightStorageService();
        GUIApp guiApp = new GUIApp();
        guiApp.startApp();

//        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation();
//        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation( persistenceAPI );
//
//        new GUIApp( businesslogicAPI ).show();
    }
}
