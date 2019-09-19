/*Dylan Rossi
*CS4A 9.18.19
*In Class POS System for IN N OUT
*/
import java.util.*;

public class Menu{
     final static double TAX_RATE = 1.0825;
public static void main(String[] args){

     displayMenu();
}

//this function will display the menu choices and allow user to make a choice
public static void displayMenu(){
Scanner in = new Scanner(System.in);
     //Money
     double subTotal = 0, totalGross = 0, totalNet = 0;
     //Menu Items
     double hamburger = 2.50, cheeseburger = 3.10, doubleDouble = 4.10, fries = 2.00, milkshake = 2.50, soda = 1.75;
     //Counter, user input
     int ticket = 1, choice = 0;

     while (choice != 8){
               //update menu with borders and correct alignment
          System.out.println("\t\tMENU:\n");
          System.out.println("\t1: Hamburger\t\t\t$" + hamburger);
          System.out.println("\t2: Cheeseburger\t\t\t$" + cheeseburger);
          System.out.println("\t3: Double Double\t\t$" + doubleDouble);
          System.out.println("\t4: Fries\t\t\t$" + fries);
          System.out.println("\t5: Milkshake\t\t\t$" + milkshake);
          System.out.println("\t6: Soda\t\t\t\t$" + soda);
          System.out.println("\t7: End of Order");
          System.out.println("\t8: Quit");
          System.out.println("\t\t\t\t\tTicket No.: " + ticket);
          System.out.printf("\t\t\t\t\tSubtotal: $ %,.2f", subTotal);
          System.out.print("\n\n\t\tCHOICE:\t");

          choice = in.nextInt();

          switch(choice){
               case 1: subTotal += getSub(hamburger, in); break;
               case 2: subTotal += getSub(cheeseburger, in); break;
               case 3: subTotal += getSub(doubleDouble, in); break;
               case 4: subTotal += getSub(fries, in); break;
               case 5: subTotal += getSub(milkshake, in); break;
               case 6: subTotal += getSub(soda, in); break;
               case 7: getOrder(subTotal, ticket, in); ticket++; totalNet += subTotal; subTotal = 0; break;
               case 8: getTotal(totalGross, totalNet, ticket); break;
          }//switch
     }//while loop
     in.close();
}//method

public static double getSub(double menuChoice, Scanner in){

     System.out.print("\n\t\tHow many?: ");
     int howMany = in.nextInt();
     System.out.println("\n\n");

     double cost = menuChoice * howMany;
     return cost;
}

public static void getOrder(double cost, int ticketNum, Scanner in){

     double totalCost = cost * TAX_RATE;
     
     System.out.printf("\n\nThe total cost of the order is: $%,.2f", totalCost);
     System.out.println("\nYour order number is: " + ticketNum);
     System.out.print("\nAny number + ENTER to continue: ");
     int nullVar = in.nextInt();
     System.out.println("\n\n\n\n");
}

public static void getTotal(double totalGross, double totalNet, int ticket){

     totalGross = totalNet * TAX_RATE;
     System.out.printf("\n\n\nTotal Revenue including tax: \t$%,.2f", totalGross);
     System.out.printf("\nTotal Revenue without tax: \t$%,.2f", totalNet);
     System.out.println("\nTotal number of orders: \t" + (ticket - 1));
}
}
