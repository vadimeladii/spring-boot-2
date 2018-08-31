package md.springboot.expression;

import java.util.function.Supplier;

public class ExpressionAsserts {

    public static <T extends RuntimeException> void verify(Boolean value, Supplier<T> supplier) {
        if (value) {
            throw supplier.get();
        }
    }
}
