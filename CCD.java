import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CCD {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int ch, qty;
    private int[] item_id = new int[10];
    private int[] quantity = new int[10];
    private int[] rate = new int[10];
    private String[] item_name = new String[10];
    private int total_price;
    private double tax_price;
    private double tax;
    private int choice;
    private int admin_choice;
    private String[] item = new String[5];
    private int[] ad_price = new int[5];
    private int sizes;
    private int siz;
    private String u_name, pass;
    private int loyaltyPoints = 0;
    private void changeColor(int desiredColor) {
        System.out.print("\u001B[38;5;" + desiredColor + "m");
    }
    //******************Starting page function****************************
    private void index() {
        clearConsole();
        drawLine();
        System.out.println("\t\t!! Welcome to CCD !!");
        drawLine();
        System.out.println("1. Admin Login");
        System.out.println("2. Let's go to Shop->");
        drawLine();
        System.out.print("Enter your choice (no.): ");
        choice = scanner.nextInt();
    
        if (choice == 1) {
            clearConsole();
            auth();
        } else {
            clearConsole();
            e_name();
            howmany();
            menu();
            order();
            
            
            
        }
    }

    private void drawLine() {
        for (int i = 1; i < 70; i++)
            System.out.print("=");
        System.out.println();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    

    

    private void calculateLoyaltyPoints() {
        int spentAmount = (int) tax_price;
        int pointsEarned = spentAmount / 10;
        System.out.println("Earned " + pointsEarned + " loyalty points!");
        loyaltyPoints += pointsEarned;
    }

    private void showbill() {
        clearConsole();
        changeColor(2);

        char men;
        drawLine();
        System.out.println("     || Bill ||    |  Thanks '" + name + "' for Visiting Our Shop |");
        drawLine();
        System.out.println("NO:\t\tOrder ID\tItem name\tQuantity\tRate");
        drawLine();

        for (int i = 0; i < sizes; i++) {
            System.out.println(i + 1 + "\t\t" + item_id[i] + "\t\t" + item_name[i] + "\t\t" + quantity[i] + "\t\t" + rate[i]);
            total_price += rate[i];
        }

        tax = (0.18 * total_price);
        tax_price = total_price + tax;

        drawLine();
        System.out.println("Gross Amount :\t\t" + total_price);
        System.out.println("GST @18% :\t\t" + tax);
        System.out.println("Total Amount :\t\tRs. " + tax_price);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        drawLine();
        System.out.print("Do you want to back to Main Menu for New Order (Y/N): ");
        men = scanner.next().charAt(0);

        if (men == 'y' || men == 'Y') {
            calculateLoyaltyPoints();
            index();
        } else {
            clearConsole();
            drawLine();
            System.out.println("\t\t!! |Thanks for Visiting Us| !!");
            drawLine();
        }
    }

    private void e_name() {
        drawLine();
        System.out.println("\t\t| Welcome To CCD Online Order |");
        drawLine();
        System.out.print("To Place order please Enter your Name : ");
        name = scanner.next();
    }

    private void howmany() {
        clearConsole();
        changeColor(3);
        drawLine();
        System.out.println("\t\t| Welcome ' " + name + " ' To Our Shop | ");
        drawLine();
        System.out.println("Items Available\t\tRate");
        drawLine();
        System.out.println("0. Exit");
        System.out.println("1. Coffee\t\t50.00");
        System.out.println("2. Tea\t\t\t30.00");
        System.out.println("3. Soda\t\t\t20.00");
        System.out.println("4. Juice\t\t100.00");
        System.out.println("5. Special Combo\t150.00");
        upmenu();
        System.out.print("How many Items would you like to Order : ");
        sizes = scanner.nextInt();
    }

    private void menu() {
        clearConsole();
        drawLine();
        System.out.println("\t\t| Welcome '" + name + "' To Our Shop |");
        drawLine();
        System.out.println("Items Available\t\tRate");
        drawLine();
        System.out.println("1. Coffee\t\t50.00");
        System.out.println("2. Tea\t\t\t30.00");
        System.out.println("3. Soda\t\t\t20.00");
        System.out.println("4. Juice\t\t100.00");
        System.out.println("5. Special Combo\t150.00");
        upmenu();
    }

    private void order() {
        changeColor(2);
        for (int i = 0; i < sizes; i++) {
            System.out.print("Enter your " + (i + 1) + " Choice (no.): ");
            ch = scanner.nextInt();

            if (ch == 1) {
                System.out.print("How Many Coffee's do you want : ");
                qty = scanner.nextInt();
                item_id[i] = 1;
                quantity[i] = qty;
                rate[i] = qty * 50;
                item_name[i] = "Coffee";
            } else if (ch == 2) {
                System.out.print("How Many Tea's do you want : ");
                qty = scanner.nextInt();
                item_id[i] = 2;
                quantity[i] = qty;
                rate[i] = qty * 30;
                item_name[i] = "Tea";
            } else if (ch == 3) {
                System.out.print("How Many Soda's do you want : ");
                qty = scanner.nextInt();
                item_id[i] = 3;
                quantity[i] = qty;
                rate[i] = qty * 20;
                item_name[i] = "Soda";
            } else if (ch == 4) {
                System.out.print("How Many Juice's do you want : ");
                qty = scanner.nextInt();
                item_id[i] = 4;
                quantity[i] = qty;
                rate[i] = qty * 100;
                item_name[i] = "Juice";
            } else if (ch == 5) {
                System.out.print("How Many combo's do you want : ");
                qty = scanner.nextInt();
                item_id[i] = 5;
                quantity[i] = qty;
                rate[i] = qty * 150;
                item_name[i] = "combo";
            } else if (ch == (i + 6)) {
                System.out.print("| How Many " + item[i] + " do you want | : ");
                qty = scanner.nextInt();
                item_id[i] = (i + 6);
                quantity[i] = qty;
                rate[i] = qty * ad_price[i];
                item_name[i] = item[i];
            } else {
                System.out.println("Wrong Input, try again!!");
                i--;
            }
        }
        showbill();
    }

    private void upmenu() {
        for (int i = 0; i < siz; i++) {
            System.out.println(i + 6 + ". " + item[i] + "\t\t" + ad_price[i]);
        }
    }

    private void animation() {
        clearConsole();
        drawLine();
        drawLine();
        System.out.println("\t!!! --Welcome to CCD-- !!! ");
        drawLine();
        drawLine();

        System.out.print("\u001B[?25l");

        int bar1 = 177, bar2 = 219;

        System.out.print("\n\n\tLoading...");
        System.out.print("\n\n\t");

        for (int i = 0; i < 25; i++) {
            System.out.print((char) bar1);
        }

        System.out.print("\r");
        System.out.print("\t");

        for (int i = 0; i < 25; i++) {
            System.out.print((char) bar2);
            try {
                Thread.sleep(130);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void login() {
        drawLine();
        System.out.println("\t!! Welcome ADMIN please Authenticate yourself !!");
        drawLine();

        System.out.print("Enter Your |USERNAME| : ");
        u_name = scanner.next();
        System.out.print("Enter Your |PASSWORD| : ");
        pass = scanner.next();
    }

    private void auth() {
        changeColor(3);
        login();
        if (u_name.equals("admin") && pass.equals("admin")) {
            admin();
        } else {
            System.out.println("!! -----Wrong Password or Username------ !!");
            auth();
        }
    }

    private void additem() {
        System.out.print("How many Items do you want to Add : ");
        siz = scanner.nextInt();

        for (int i = 0; i < siz; i++) {
            System.out.print("Enter " + (i + 1) + " Item Name : ");
            item[i] = scanner.next();
            System.out.print("Enter " + (i + 1) + " Item Prize : ");
            ad_price[i] = scanner.nextInt();
        }
        System.out.println("!! Items were Added |Successfully| !!");
        admin();
        drawLine();
        drawLine();
    }

    private void admin() {
        clearConsole();
        drawLine();
        System.out.println("\t\t\t!! WELCOME Admin !!");
        drawLine();
        System.out.println("1. Add Items");
        System.out.println("2. View Order");
        System.out.println("3. Back to Main Menu");
        drawLine();
        System.out.print("Enter your choice (no.) : ");
        admin_choice = scanner.nextInt();

        if (admin_choice == 3) {
            index();
        } else if (admin_choice == 2) {
            clearConsole();
            showbill();
        } else {
            additem();
        }
    }

    private void start() {
        animation();
        index();
    }

    public static void main(String[] args) {
        CCD ob = new CCD();
        ob.start();
    }
}
