package design.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Demo{
    private static Map<Integer,Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1,2200);
        priceOnProducts.put(2,1850);
        priceOnProducts.put(3,1100);
        priceOnProducts.put(4,890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()){
            int cost;

            String continueChoice;
            do {
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.println("Count:");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                continueChoice = reader.readLine();
            }while (continueChoice.equalsIgnoreCase("y"));

            if (strategy == null){
                System.out.println("select payment method");
                String paymentMethod = reader.readLine();

                if (paymentMethod.equalsIgnoreCase("1")){
                    strategy = new PayByPayPal();
                }else {
                    strategy = new PayByCreditCard();
                }
            }

            order.processOrder(strategy);

            System.out.println("Pay "+order.getTotalCost());
            String proceed = reader.readLine();
            if (proceed.equals("P")){
                if (strategy.pay(order.getTotalCost())){
                    System.out.println("Payment has been successful");
                }else {
                    System.out.println("FAIL! Please check your data");
                }
                order.setClosed();
            }
        }
    }
}

class Order {
    private int totalCost = 0;
    private boolean isClosed = false;
    public void processOrder(PayStrategy payStrategy){
        payStrategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost){
        this.totalCost+=cost;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(){
        isClosed = true;
    }
}

public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    public CreditCard(int amount, String number, String date, String cvv) {
        this.amount = amount;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}

class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("aaa", "aaa@ya.com");
        DATA_BASE.put("bbb", "bbb@ya.com");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using Paypal.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        while (!signedIn) {
            System.out.println("Enter the user's email:");
            try {
                email = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enter the password:");
            try {
                password = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (verify()) {
                System.out.println("校验成功");
            } else {
                System.out.println("校验失败");
            }
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}

class PayByCreditCard implements PayStrategy {

    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() {

    }
}

