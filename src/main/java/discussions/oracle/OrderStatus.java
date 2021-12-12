package discussions.oracle;

public enum OrderStatus {
    PLACED("Placed", 0),
    APPROVED("Placed", 0),
    READY_TO_SHIP("Placed", 0),
    PACKED("Placed", 0),
    SHIPPED("Placed", 0),
    DELIVERED("Placed", 0);

    private String uiLabel;
    private int numericStatus;

    OrderStatus(String uiLabel, int numericStatus) {
        this.uiLabel = uiLabel;
        this.numericStatus = numericStatus;
    }
}
