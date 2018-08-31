package md.springboot.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OffsetLimitHelper {
    public static final String PAGE = "0";
    public static final String SIZE = "10";
    public static final int MIN_SIZE = 1;
    public static final int MIN_PAGE = 0;
}
