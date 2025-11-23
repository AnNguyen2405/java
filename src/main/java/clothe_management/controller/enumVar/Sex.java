package clothe_management.controller.enumVar;

public enum Sex {
    MALE, FEMALE, NONE;

    public static Sex StringToEnum(String value) {
        Sex sex_e = MALE;
        try {
            sex_e = valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.print("Invalid enum");
            return null;
        }
        return sex_e;
    }
};
