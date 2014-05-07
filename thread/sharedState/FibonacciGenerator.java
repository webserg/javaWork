package thread.sharedState;

public interface FibonacciGenerator<T> {
    /**
     * Следующее сгенерированное значение
     */
    T next();

    /**
     * Текущее значение в генераторе
     */
    public T val();
}
