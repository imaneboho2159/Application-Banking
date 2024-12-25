
public class Account {
   private long number;
   private double sold;
   private Client client;

   public Account(long number, double sold, Client client) {
       this.number = number;
       this.sold = sold;
       this.client = client;
   }
   public long getNumber() {
       return number;
   }
   public double getSold() {
       return sold;
   }
   public Client getClient() {
       return client;
   }
   public void setNumber(){
       this.number = number;
   }
   public void setSold(double sold) {
       this.sold = sold;
   }
   public void setClient(Client client) {
       this.client = client;
   }

}
