package pattern.creational.factory.fucntionfactoryvehicleroad.model;


import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryFactoryAvoidReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;

public class Motor implements IVehicleRoad {

    // registry factory
    static {
        RegistryVehicleRoadFactoryReflection.getInstance().addNewVehicle(EnumVehicle.MOTOR, Motor.class);
    }

    // registry factory reflection
    static {
        RegistryFactoryAvoidReflection.getInstance().addNewVehicle(EnumVehicle.MOTOR, new Motor());
    }

    @Override
    public IVehicleRoad createVehicle() {
        return new Motor();
    }

    @Override
    public String getType() {
        return "Motor";
    }
}
