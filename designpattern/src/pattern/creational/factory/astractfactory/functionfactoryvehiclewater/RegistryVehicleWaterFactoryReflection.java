package pattern.creational.factory.astractfactory.functionfactoryvehiclewater;

import pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model.IVehicleWater;
import pattern.creational.factory.astractfactory.main.AbstractFactory;
import pattern.creational.factory.astractfactory.main.RegistryFunctionFactoryNonReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.Bike;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;


public class RegistryVehicleWaterFactoryReflection implements AbstractFactory<IVehicleWater> {

    // registry factory reflection with abstract factory
    static {
        RegistryFunctionFactoryNonReflection.getInstance().addNewVehicle("water", getInstance());
    }

    //private constructor to avoid client applications to use constructor
    private RegistryVehicleWaterFactoryReflection(){}

    private static RegistryVehicleWaterFactoryReflection registryFactoryConcrete;

    // map save vehicle
    private final Map<EnumVehicle,  Class<IVehicleWater>> MAP_REGISTRY = new HashMap<>();


    // add new vehicle when new class type vehicle
    public void addNewIVehicleWater(EnumVehicle enumIVehicleWater,  Class classIVehicleWater){
        MAP_REGISTRY.put(enumIVehicleWater, classIVehicleWater);
    }

    // get instance vehicle
    public IVehicleWater factoryRegistryIVehicleWater(EnumVehicle enumIVehicleWater){
        try {
            //Reflection class to instance
            Class<IVehicleWater> classIVehicleWater = MAP_REGISTRY.get(enumIVehicleWater);
            Constructor<IVehicleWater> productConstructor = classIVehicleWater.getDeclaredConstructor();
            return productConstructor.newInstance();
        }catch( Exception e) {
            return null;
        }
    }

    public static synchronized RegistryVehicleWaterFactoryReflection getInstance(){
         if(registryFactoryConcrete == null){
             return registryFactoryConcrete = new RegistryVehicleWaterFactoryReflection();
         }
         return registryFactoryConcrete;
    }


    // abstract factory , factory of factory
    @Override
    public IVehicleWater createObject(EnumVehicle enumVehicle) {
        return factoryRegistryIVehicleWater(enumVehicle);
    }
}
