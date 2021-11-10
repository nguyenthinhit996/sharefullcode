package pattern.creational.factory.fucntionfactoryvehicleroad;

import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.IVehicleRoad;

public class Run {

    // call static block to registry RegistryFactoryConcrete
    static
    {
        try
        {
            Class.forName("pattern.creational.factory.fucntionfactoryvehicleroad.model.Bike");
            Class.forName("pattern.creational.factory.fucntionfactoryvehicleroad.model.Car");
            Class.forName("pattern.creational.factory.fucntionfactoryvehicleroad.model.Motor");
        }
        catch (ClassNotFoundException any)
        {
            any.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // use factory registry Reflection
        IVehicleRoad vehicle2 = RegistryVehicleRoadFactoryReflection.getInstance().factoryRegistryVehicle(EnumVehicle.BIKE);
        System.out.println(vehicle2.toString());

        IVehicleRoad vehicle3 = RegistryVehicleRoadFactoryReflection.getInstance().factoryRegistryVehicle(EnumVehicle.BIKE);
        System.out.println(vehicle3.toString());

        // use factory registry AvoidReflection
        IVehicleRoad vehicle32 = RegistryFactoryAvoidReflection.getInstance().factoryRegistryVehicle(EnumVehicle.BIKE);
        System.out.println(vehicle32.toString());

        IVehicleRoad vehicle342 = RegistryFactoryAvoidReflection.getInstance().factoryRegistryVehicle(EnumVehicle.BIKE);
        System.out.println(vehicle342.toString());

    }

}
