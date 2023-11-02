package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
import static roles.User.loggedIngetEmail;


public class Customer {
    private String username;
    private String email;
    private String password;
    private String userType;
    private List<roles.Order> orders;
    private static List<Customer> customers = new ArrayList<>();

    public Customer(String username, String email, String password,String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = "customer";
        this.orders = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public List<Order> getOrders() {
        return orders;
    }

    private static void manageCustomers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Customer Management");
            System.out.println("1. Register Customer");
            System.out.println("2. List Customers");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    listCustomers();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void registerCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer's username: ");
        String username = scanner.nextLine();

        System.out.print("Enter customer's email: ");
        String email = scanner.nextLine();

        System.out.print("Enter customer's password: ");
        String password = scanner.nextLine();

        customers.add(new Customer(username, email, password,"customer"));
        System.out.println("Customer registration successful!");
    }

    private static void listCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println("Username: " + customer.getUsername() + ", Email: " + customer.getEmail());
        }
    }

    //String loggedInUsername = customerUser.getUsername();
    public static Customer getLoggedInCustomer() {
        for (Customer customer : customers) {

            if (customer.getEmail().equals("customer@customer.com")) {
                return customer;
            }

        }
        return null ;
    }





}