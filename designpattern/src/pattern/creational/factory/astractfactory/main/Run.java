package pattern.creational.factory.astractfactory.main;

import pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model.IVehicleWater;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;
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

            Class.forName("pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model.Cano");
            Class.forName("pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model.Ship");

            Class.forName("pattern.creational.factory.astractfactory.functionfactoryvehiclewater.RegistryVehicleWaterFactoryReflection");
            Class.forName("pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection");
        }
        catch (ClassNotFoundException any)
        {
            any.printStackTrace();
        }
    }

    static AbstractFactory factoryVehicleType(String typeVehicle){
        return RegistryFunctionFactoryNonReflection.getInstance().getFactoryMethod(typeVehicle);
    }

    public static void main(String[] args) {

        String choiceVehicleRoad = "road";
        EnumVehicle choiceBike = EnumVehicle.BIKE;

        String choiceVehicleWater = "water";
        EnumVehicle choiceCano = EnumVehicle.CANO;

        AbstractFactory isRoadType = factoryVehicleType(choiceVehicleRoad);
        IVehicleRoad bike = (IVehicleRoad) isRoadType.createObject(choiceBike);
        System.out.println(bike.toString());

        AbstractFactory isWaterType = factoryVehicleType(choiceVehicleWater);
        IVehicleWater cano = (IVehicleWater) isWaterType.createObject(choiceCano);
        System.out.println(cano.toString());
    }

}
