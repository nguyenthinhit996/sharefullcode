package pattern.observer.structure;

import java.util.List;

/**
 * IObserverable đóng vai trò là nơi thông báo cho tất cả các Observer
 * T là generic data object trao đổi lúc thông báo
 */
public interface IObserverable<T> {
    List<Obverser<T>> getListObserver();
    void attackObserver(Obverser<T> observer);
    void setChange(T data);
}
