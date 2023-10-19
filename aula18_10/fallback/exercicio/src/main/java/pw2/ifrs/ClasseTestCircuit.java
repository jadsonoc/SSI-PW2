package pw2.ifrs;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

public class ClasseTestCircuit {

    private AtomicLong counter = new AtomicLong(0);

    @CircuitBreaker(requestVolumeThreshold = 2)
    public int getMagicNumber() {
        maybeFail();
        return new Random().nextInt(30);
    }
    
    private void maybeFail() {
        final long invocationNumber = counter.getAndIncrement();
        if (invocationNumber % 4 > 1) {
            throw new RuntimeException("Falhou");
        }
    }
}
