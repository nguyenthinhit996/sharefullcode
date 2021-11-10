package application.types.factorymethod;

import application.types.factorymethod.model.*;

public class Application {

    // call static block to registry RegistryFactoryConcrete
    static
    {
        try
        {
            Class.forName("application.types.factorymethod.model.Bike");
            Class.forName("application.types.factorymethod.model.Car");
            Class.forName("application.types.factorymethod.model.Motor");
        }
        catch (ClassNotFoundException any)
        {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // use factory method
        Vehicle vehicle = MethodFactoryConcrete.factoryMethodVehicle(EnumVehicle.MOTOR);
        System.out.println(vehicle.getType());

        // use factory registry
        Vehicle vehicle2 = RegistryFactoryConcrete.getInstance().factoryRegistryVehicle(EnumVehicle.BIKE);
        System.out.println(vehicle2.getType());
    }
}