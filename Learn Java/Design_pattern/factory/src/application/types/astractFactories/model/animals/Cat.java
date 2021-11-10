package application.types.astractFactories.model.animals;

import application.types.astractFactories.factorys.AnimalFactory;

public class Cat implements IAnimal {

    static{
        AnimalFactory.registryAnimal("CAT", new Cat());
    }

    @Override
    public String makeSound() {
        return "CAT";
    }

    @Override
    public Float getWeight() {
        return 4f;
    }

    @Override
    public IAnimal createInstance() {
        return new Cat();
    }
}
