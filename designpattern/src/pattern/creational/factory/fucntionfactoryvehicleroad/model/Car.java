package pattern.creational.factory.fucntionfactoryvehicleroad.model;


import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryFactoryAvoidReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;

public class Car implements IVehicleRoad {

    // registry factory
    static {
        RegistryVehicleRoadFactoryReflection.getInstance().addNewVehicle(EnumVehicle.CAR, Car.class);
    }

    // registry factory not reflection
    static {
        RegistryFactoryAvoidReflection.getInstance().addNewVehicle(EnumVehicle.CAR, new Car());
    }

    @Override
    public IVehicleRoad createVehicle() {
        return new Car();
    }

    @Override
    public String getType() {
        return "Car";
    }
}
