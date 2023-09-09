package persistence;

class PersistenceFactoryImpl implements PersistenceFactory{



    public FlightStorageService PersistenceFactoryImpl (){
        return new FlightStorageServiceImpl();
        //private constructor to prevent instantiation

    }



}
