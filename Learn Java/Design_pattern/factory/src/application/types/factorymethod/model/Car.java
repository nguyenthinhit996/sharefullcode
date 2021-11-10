package application.types.factorymethod.model;

import application.types.factorymethod.RegistryFactoryConcrete;

public class Car implements Vehicle {

    // registry factory
    static {
        RegistryFactoryConcrete.getInstance().addNewVehicle(EnumVehicle.CAR, new Car());
    }
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public String getType() {
        return "Car";
    }
}
