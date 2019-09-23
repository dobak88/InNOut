/*        CS4A 9.23.19
*         In-Class Assignment
*         POS System for IN N OUT
*/
import java.util.*;

public class Menu{

     final static double TAX_RATE = 1.0825;

     public static void main(String[] args){

          displayMenu();
     }

     public static void displayMenu(){
          Scanner in = new Scanner(System.in);
          double subTotal = 0, totalGross = 0, totalNet = 0;                                                                 //Money
          double hamburger = 2.50, cheeseburger = 3.10, doubleDouble = 4.10, fries = 2.00, milkshake = 2.50, soda = 1.75;    //Menu Items
          int ticket = 1, choice = 0;                                                                                        //Order No., User Input
          char saveOrder = 'N';                                                                                              //save order upon quit?

          while (choice != 9){
               System.out.println("\t\tMENU:\n");
               System.out.printf("\t1: Hamburger\t\t\t$%.2f\n", hamburger);
               System.out.printf("\t2: Cheeseburger\t\t\t$%.2f\n", cheeseburger);
               System.out.printf("\t3: Double Double\t\t$%.2f\n", doubleDouble);
               System.out.printf("\t4: Fries\t\t\t$%.2f\n", fries);
               System.out.printf("\t5: Milkshake\t\t\t$%.2f\n", milkshake);
               System.out.printf("\t6: Soda\t\t\t\t$%.2f\n", soda);
               System.out.println("\t7: End of Order");
               System.out.println("\t8: Cancel Order");
               System.out.println("\t9: Quit");
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
                    case 8: subTotal = 0; System.out.println("\n\n\n"); break;                                //resets subtotal to zero, keep same ticket number
                    case 9: if (subTotal > 0){                                                                //save current order before quitting
                                   System.out.print("\nSave current order? Y/N: ");
                                   saveOrder = in.next().charAt(0);
                                   if (saveOrder == 'Y' || saveOrder == 'y'){
                                        getOrder(subTotal, ticket, in); ticket++; totalNet += subTotal; subTotal = 0;
                                   }
                                   else {subTotal = 0;}
                            }
                            else {}
                            getTotal(totalGross, totalNet, ticket); in.close();
               }
          }
     }

     public static double getSub(double menuChoice, Scanner in){

          System.out.print("\n\t\tHow many?: ");
          int howMany = in.nextInt();
          System.out.println("\n\n");
          double cost = menuChoice * howMany;
          return cost;
     }

     public static void getOrder(double subTotal, int ticket, Scanner in){

          double totalCost = subTotal * TAX_RATE;
          System.out.println("\n\n******************************************");
          System.out.printf("* The total cost of the order is: $%,.2f", totalCost);
          System.out.println("\n* Your order number is: " + ticket);
          System.out.println("******************************************");
          System.out.print("\n\n\n\n");
     }

     public static void getTotal(double totalGross, double totalNet, int ticket){

          totalGross = totalNet * TAX_RATE;
          System.out.println("\n\n\n********************************************");
          System.out.printf("* Total Revenue including tax: \t$%,.2f", totalGross);
          System.out.printf("\n* Total Revenue without tax: \t$%,.2f", totalNet);
          System.out.println("\n* Total number of orders: \t" + (ticket - 1));
          System.out.println("********************************************");
     }
}
