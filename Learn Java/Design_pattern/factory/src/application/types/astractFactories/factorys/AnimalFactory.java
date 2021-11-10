package application.types.astractFactories.factorys;

import application.types.astractFactories.model.animals.IAnimal;

import java.util.HashMap;
import java.util.Map;

public class AnimalFactory implements AbstractFactory<IAnimal>{

    // map registry for abstract factory
    private static Map<String, IAnimal> mapStoreTypeAnimal = new HashMap<>();

    //add new animal into map
    public static void registryAnimal(String type, IAnimal animal){
        mapStoreTypeAnimal.put(type, animal);
    }

    @Override
    public IAnimal create(String type) {
        IAnimal animal = mapStoreTypeAnimal.get(type);
        if(animal != null ){
            return animal.createInstance();
        }
        return null;
    }
}
