public class Operation {
public String type;
public Double amount;
public String date;
public Account account;
public Operation(String type, Double amount, String date, Account account) {
    this.type = type;
    this.amount = amount;
    this.date = date;
    this.account = account;
}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
