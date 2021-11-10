package application.types.astractFactories.factorys;

public interface AbstractFactory<T> {
    T create(String type);
}
