package localhost.milestonenet;

import java.time.LocalDateTime;

public class purchases {
    private String id;
    private String drugName;
    private String userid;
    private float price;
    private float quantity;
    private LocalDateTime purchasedDateTime;
    private float totalMoneySpent;

    public purchases() {}

    public purchases(String id, String drugName, String userid, float price, float quantity, LocalDateTime purchasedDateTime, float totalMoneySpent) {
        this.id = id;
        this.drugName = drugName;
        this.userid = userid;
        this.price = price;
        this.quantity = quantity;
        this.purchasedDateTime = purchasedDateTime;
        this.totalMoneySpent = totalMoneySpent;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDrugName() { return drugName; }
    public void setDrugName(String drugName) { this.drugName = drugName; }
    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public float getQuantity() { return quantity; }
    public void setQuantity(float quantity) {  this.quantity = quantity; }
    public LocalDateTime getPurchasedDateTime() { return purchasedDateTime; }
    public void setPurchasedDateTime(LocalDateTime purchasedDateTime) { this.purchasedDateTime = purchasedDateTime; }
    public float getTotalMoneySpent() { return totalMoneySpent; }
    public void setTotalMoneySpent(float totalMoneySpent) { this.totalMoneySpent = totalMoneySpent;}

}
