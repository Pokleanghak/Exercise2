interface DiscountRate {
    double getServiceDiscountRate(String type);
    double getProductDiscountRate(String type);
}

class Sale {
    private Customer customer;
    private double totalAmount;

    public Sale(Customer customer, double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public double calculateServiceDiscount() {
        return totalAmount * customer.getServiceDiscountRate();
    }

    public double calculateProductDiscount() {
        return totalAmount * customer.getProductDiscountRate();
    }
}

class Customer implements DiscountRate {
    private String type;

    public Customer(String type) {
        this.type = type;
    }

    @Override
    public double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Premium");
        Customer goldCustomer = new Customer("Gold");
        Customer silverCustomer = new Customer("Silver");
        Customer normalCustomer = new Customer("Normal");

        Sale sale1 = new Sale(premiumCustomer, 100.0);
        Sale sale2 = new Sale(goldCustomer, 100.0);
        Sale sale3 = new Sale(silverCustomer, 100.0);
        Sale sale4 = new Sale(normalCustomer, 100.0);

        System.out.println("Premium Customer - Service Discount: " + sale1.calculateServiceDiscount() + ", Product Discount: " + sale1.calculateProductDiscount());
        System.out.println("Gold Customer - Service Discount: " + sale2.calculateServiceDiscount() + ", Product Discount: " + sale2.calculateProductDiscount());
        System.out.println("Silver Customer - Service Discount: " + sale3.calculateServiceDiscount() + ", Product Discount: " + sale3.calculateProductDiscount());
        System.out.println("Normal Customer - Service Discount: " + sale4.calculateServiceDiscount() + ", Product Discount: " + sale4.calculateProductDiscount());
    }
}