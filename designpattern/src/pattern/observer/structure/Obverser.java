package pattern.observer.structure;

/**
 * Obverser Đóng vai trò là class nhận thông báo và thưc hiện trên hàm update
 * @param <T> generic class data
 */
public interface Obverser<T> {
    void Update(T data);
}
