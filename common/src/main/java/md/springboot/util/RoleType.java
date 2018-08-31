package md.springboot.util;

/**
 * Created by veladii on 31.08.2018
 */
public enum RoleType {
    SIMPLE("SIMPLE"), ADMIN("ADMIN");

    private String type;

    RoleType(String type) {
        this.type = type;
    }
}
