import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    private int id;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  phoneNumber;
    private String  address;
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Client> client=new ArrayList<Client>();

    public Client(int id, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(?:06|07|05)[0-9]{8}$";
        return Pattern.matches(regex, phoneNumber);
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        return Pattern.matches(regex, email);
    }

    public static void addClient (){
        boolean valid=false;

        System.out.print("Enter Client ID: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Client First Name: ");
        String firstName=scanner.next();
        scanner.nextLine();
        System.out.print("Enter Client Last Name: ");
        String lastName=scanner.next();
        scanner.nextLine();
        String phoneNumber=null,email=null;
        while(!valid) {
            System.out.print("Enter Client Email: ");
            email = scanner.next();
            scanner.nextLine();
            System.out.print("Enter Client Phone Number: ");
            phoneNumber = scanner.next();
            scanner.nextLine();
            valid = isValidEmail(email) && isValidPhoneNumber(phoneNumber);
        }
        System.out.print("Enter Client Address: ");
        String address=scanner.next();
        scanner.nextLine();

        try {
            Client client = new Client(id, firstName, lastName, email, phoneNumber, address);
            System.out.println("Client added successfully: " + client);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void displayClient(){
        if(client.isEmpty()) {
            System.out.println("No client found");
        }
        System.out.println(" ------list of Clients -----");
        for(Client c:client) {
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
