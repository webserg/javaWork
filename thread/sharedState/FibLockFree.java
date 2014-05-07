package thread.sharedState;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by webserg on 12.04.2014.
 */
public class FibLockFree implements FibonacciGenerator<BigInteger> {

    // Инкапсулируем состояние генератора в класс
    private static class State {
        final BigInteger next;
        final BigInteger curr;

        public State(BigInteger curr, BigInteger next) {
            this.next = next;
            this.curr = curr;
        }
    }

    // Сделаем состояние класса атомарным
    private final AtomicReference<State> atomicState = new AtomicReference<>(new State(BigInteger.ONE, BigInteger.ONE));

    public BigInteger next() {
        BigInteger value = null;
        while (true) {
            // сохраняем состояние класса
            State state = atomicState.get();
            // то что возвращаем если удалось изменить состояние класса
            value = state.curr;
            // конструируем новое состояние
            State newState = new State(state.next, state.curr.add(state.next));
            // если за время пока мы конструировали новое состояние
            // оно осталось прежним, то заменяем состояние на новое,
            // иначе пробуем сконструировать еще раз
            if (atomicState.compareAndSet(state, newState)) {
                break;
            }
        }
        return value;
    }

    @Override
    public BigInteger val() {
        return atomicState.get().curr;
    }
}
