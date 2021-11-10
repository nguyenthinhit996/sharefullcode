package application.types.factorymethod.model;

import application.types.factorymethod.RegistryFactoryConcrete;

public class Bike implements Vehicle {

    // registry factory
    static {
        RegistryFactoryConcrete.getInstance().addNewVehicle(EnumVehicle.BIKE, new Bike());
    }
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }


    @Override
    public String getType() {
        return "Bike";
    }
}
