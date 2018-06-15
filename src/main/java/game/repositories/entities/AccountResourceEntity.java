package game.repositories.entities;

public class AccountResourceEntity {
    private Integer accountId;
    private Integer resourceId;
    private Integer quantity;
    private Integer numPerMinute;

    public AccountResourceEntity() {
    }

    public AccountResourceEntity(Integer accountId, Integer resourceId, Integer quantity, Integer numPerMinute) {
        this.accountId = accountId;
        this.resourceId = resourceId;
        this.quantity = quantity;
        this.numPerMinute = numPerMinute;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getNumPerMinute() {
        return numPerMinute;
    }

    public void setNumPerMinute(Integer numPerMinute) {
        this.numPerMinute = numPerMinute;
    }

    public String toString() {
        return "AccountResourceEntity{" +
                "accountId=" + accountId +
                ", resourceId=" + resourceId +
                ", quantity=" + quantity +
                ", numPerMinute=" + numPerMinute +
                '}';
    }
}
