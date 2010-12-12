package expensable.shared.models;

import java.util.Date;

public class ExpenseItem implements NewsItem {

  /** The cost of the item in cents */
  private int amount;
  private Date purchaseDate;
  private String location;
  private String merchant;
  private String description;

  public ExpenseItem() {

  }

  /**
   * @return the amount
   */
  @Override
  public int getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

  /**
   * @return the purchaseDate
   */
  public Date getPurchaseDate() {
    return purchaseDate;
  }

  /**
   * @param purchaseDate the purchaseDate to set
   */
  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  @Override
  public Date getLastModified() {
    return getPurchaseDate();
  }

  @Override
  public String getName() {
    return getDescription();
  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * @return the merchant
   */
  public String getMerchant() {
    return merchant;
  }

  /**
   * @param merchant the merchant to set
   */
  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

}
