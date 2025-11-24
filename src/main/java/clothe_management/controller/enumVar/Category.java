package clothe_management.controller.enumVar;

public enum Category {
    MEN, WOMEN, UNISEX, NONE;

    public static Category StringToEnum(String value) {
        Category cat_e = NONE;
        try {
            cat_e = valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.print("Invalid enum");
            return null;
        }
        return cat_e;
    }
}
