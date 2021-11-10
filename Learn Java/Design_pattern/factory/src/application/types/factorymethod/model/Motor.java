package application.types.factorymethod.model;

import application.types.factorymethod.RegistryFactoryConcrete;

public class Motor implements Vehicle {

    // registry factory
    static {
        RegistryFactoryConcrete.getInstance().addNewVehicle(EnumVehicle.MOTOR, new Motor());
    }

    @Override
    public Vehicle createVehicle() {
        return new Motor();
    }

    @Override
    public String getType() {
        return "Motor";
    }
}
