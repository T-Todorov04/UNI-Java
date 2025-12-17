public class orderMustHaves {
    int orderID;
    int orderQuantity;
    String Status;
    public orderMustHaves(int orderID, int orderQuantity, String status) {
        this.orderID = orderID;
        this.orderQuantity = orderQuantity;
        this.Status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
