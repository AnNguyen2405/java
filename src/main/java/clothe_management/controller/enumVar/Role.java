package clothe_management.controller.enumVar;

public enum Role {
    CASHIER,
    MANAGER,
    INVENTORY_STAFF,
    NONE;

    public static Role StringToEnum(String value) {
        Role role_e = CASHIER;
        try {
            role_e = valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.print("Invalid enum");
            return null;
        }
        return role_e;
    }
}
