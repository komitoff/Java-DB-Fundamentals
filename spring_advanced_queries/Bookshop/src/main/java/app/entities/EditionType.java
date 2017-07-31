package app.entities;

public enum EditionType {
    NORMAL(0),
    PROMO(1),
    GOLD(2);

    private final int value;

    EditionType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

