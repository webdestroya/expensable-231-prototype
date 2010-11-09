package expensable.shared.models;

public class ExpenseType {

  private String name;

  public ExpenseType() {

  }

  public ExpenseType(String name) {
    this.name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}
