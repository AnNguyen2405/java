package clothe_management.controller.enumVar;

public enum PaymentMethod {
    CASH,
    BANKING,
    CARD,
    NONE;

    public static PaymentMethod StringToEnum(String value) {
        PaymentMethod method_e = NONE;
        try {
            method_e = valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.print("Invalid enum");
            return null;
        }
        return method_e;
    }
}
