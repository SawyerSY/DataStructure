package neusoft.sawyer.learn.exception;

/**
 * Created by sawyer on 2019-02-11.
 */
public class OutOfCapacityException extends RuntimeException {

    public OutOfCapacityException(int maxCapacity, int targetCapacity) {
        super("target capacity: " + targetCapacity + ", out of max capacity: " + maxCapacity);
    }
}
