package clothe_management.controller.enumVar;

public enum Size {
    NA, S, M, L, XL, NONE;

    public static Size StringToEnum(String value) {
        Size size_e = NONE;
        try {
            size_e = valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.print("Invalid enum");
            return null;
        }
        return size_e;
    }
}
