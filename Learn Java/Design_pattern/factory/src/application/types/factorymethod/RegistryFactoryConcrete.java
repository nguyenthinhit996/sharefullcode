package application.types.factorymethod;


import application.types.factorymethod.model.EnumVehicle;
import application.types.factorymethod.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

// singleton
public class RegistryFactoryConcrete {

    private static RegistryFactoryConcrete registryFactoryConcrete;

    // map save vehicle
    private  Map<EnumVehicle, Vehicle> MAP_REGISTRY = new HashMap<>();

    private RegistryFactoryConcrete(){

    }

    // add new vehicle when new class type vehicle
    public void addNewVehicle(EnumVehicle enumVehicle, Vehicle classVehicle){
        MAP_REGISTRY.put(enumVehicle, classVehicle);
        System.out.println();
    }

    // get instance vehicle
    public Vehicle factoryRegistryVehicle(EnumVehicle enumVehicle){
        Vehicle classVehicle = MAP_REGISTRY.get(enumVehicle);
        if(classVehicle != null){
            return classVehicle.createVehicle();
        }
        return null;
    }

    public static synchronized RegistryFactoryConcrete getInstance(){
         if(registryFactoryConcrete == null){
             return registryFactoryConcrete = new RegistryFactoryConcrete();
         }
         return registryFactoryConcrete;
    }
}
