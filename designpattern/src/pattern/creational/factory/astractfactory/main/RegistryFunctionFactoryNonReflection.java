package pattern.creational.factory.astractfactory.main;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class RegistryFunctionFactoryNonReflection {

    private static RegistryFunctionFactoryNonReflection registryFunctionFactory;

    private Map<String, AbstractFactory> MAP_ABSTRACT = new HashMap<>();


    public void addNewVehicle(String typeVihicle,  AbstractFactory classVehicle){
        MAP_ABSTRACT.put(typeVihicle, classVehicle);
    }

    public AbstractFactory getFactoryMethod(String enumVehicle){
        try {
            return  MAP_ABSTRACT.get(enumVehicle);
        }catch( Exception e) {
            return null;
        }
    }

    public static synchronized RegistryFunctionFactoryNonReflection getInstance(){
        if(registryFunctionFactory == null){
            return registryFunctionFactory = new RegistryFunctionFactoryNonReflection();
        }
        return registryFunctionFactory;
    }

}
