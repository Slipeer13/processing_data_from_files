package sorting;

public enum DirectSorting {
    ASK("-a"),DESK("-d");

    DirectSorting(String value) {

    }

    public static DirectSorting getDirect(String value) {
        if ("-d".equals(value)) {
            return DESK;
        }
        return ASK;
    }
}
