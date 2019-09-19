# InNOut
POS system for in n out

lines 53-57 can be its own function:

    public static void getTotal(double totalGross, double totalNet, int ticket){
  
       totalGross = totalNet * TAX_RATE;

       System.out.printf("\n\n\nTotal Revenue including tax: \t$%,.2f", totalGross);
       System.out.printf("\nTotal Revenue without tax: \t$%,.2f", totalNet);
       System.out.println("\nTotal number of orders: \t" + (ticket - 1));
    }


switch statement:


    case 8: getTotal(totalGross, totalNet, ticket); break;


