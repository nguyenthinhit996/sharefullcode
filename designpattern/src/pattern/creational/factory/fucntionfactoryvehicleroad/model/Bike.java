package pattern.creational.factory.fucntionfactoryvehicleroad.model;


import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryFactoryAvoidReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;

public class Bike implements IVehicleRoad {

    // registry factory reflection
    static {
        RegistryVehicleRoadFactoryReflection.getInstance().addNewVehicle(EnumVehicle.BIKE, Bike.class);
    }

    // registry factory not reflection
    static {
        RegistryFactoryAvoidReflection.getInstance().addNewVehicle(EnumVehicle.BIKE, new Bike());
    }

    @Override
    public IVehicleRoad createVehicle() {
        return new Bike();
    }


    @Override
    public String getType() {
        return "Bike";
    }
}
