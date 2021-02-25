import java.util.Scanner;
/**
 * Write a description of class JeffreyGrockowskiProject05 here.
 *
 * @author Jeff Grockowski
 * @version 10/02/2019
 */
public class JeffreyGrockowskiProject05
{
    //calculates monthly payment for mortgage schedule
    public static double calculateMonthlyPayment(double loanAmount, int termInYears, double interestRate){
        int termInMonth = termInYears * 12;
        double monthInterestRate = interestRate / 100.0 / 12;
        double x = Math.pow(1 + monthInterestRate, termInMonth);
        return loanAmount * monthInterestRate * x / (x - 1);
        
    }
    // calculates the principle balance change over the course of repayment
    public static double balanceAtEndOfMonth(double loanAmount, double monthsPayment, double interestRate, int n){
        double monthsInterestRate = interestRate / 100.0 / 12;
        double x = Math.pow(1 + monthsInterestRate, n);
        return x * loanAmount - (x - 1) * monthsPayment / monthsInterestRate;
    }
    public static void main(String [] args){
        // input variables for mortgage detials
        double principal, interestRate;
        int termInYears;
        char repeat = 'Y';
        //create scanner to take input from user
        Scanner input = new Scanner(System.in);
        
        System.out.println("This program will output your mortgage schedule");
        // loop body allows user to repeat program via char input "repeat"
        do{
            System.out.println("Enter the Loan amount: ");
            principal = input.nextDouble();
            System.out.print("Enter your interest rate as percent: ");
            interestRate = input.nextDouble();
            System.out.println("Enter your term in years: ");
            termInYears = input.nextInt();
            
            System.out.printf("%10s\t%15s\t%20s\t%15s\n","Month","Month Payment","Total Interest Paid","Balance");
            
            //monthly payment is static does not need to be recalculated 
            double monthlyPayment = calculateMonthlyPayment(principal, termInYears, interestRate);
            /*
             * 
             *int n = 1;
            while (n <= (termInYears * 12)){
                
                double balance= balanceAtEndOfMonth(principal, monthlyPayment, interestRate, n);
                
                double totalInterestPaid = monthlyPayment * n -(principal - balance);
                
                System.out.printf("%10d\t$%13.2f\t$%18.2f\t$%13.2f\n", n, monthlyPayment, totalInterestPaid, balance);
                n++;
            }
            */
           // loop prints entire mortgage payment schedule
           for(int n = 1 ; n <= (termInYears * 12); n++){
                double balance= balanceAtEndOfMonth(principal, monthlyPayment, interestRate, n);
                
                double totalInterestPaid = monthlyPayment * n -(principal - balance);
                
                System.out.printf("%10d\t$%13.2f\t$%18.2f\t$%13.2f\n", n, monthlyPayment, totalInterestPaid, balance);
            }
            
            System.out.print("Would you like to run again?(y or n): ");
            repeat = input.next(".").charAt(0);
        } while(repeat == 'y' || repeat == 'Y');
    }
}
/*Sample while loop output
 * 
 * This program will output your mortgage schedule
Enter the Loan amount: 
50000
Enter your interest rate as percent: 5
Enter your term in years: 
2
     Month	  Month Payment	 Total Interest Paid	        Balance
         1	$      2193.57	$            208.33	$     48014.76
         2	$      2193.57	$            408.39	$     46021.26
         3	$      2193.57	$            600.15	$     44019.44
         4	$      2193.57	$            783.56	$     42009.29
         5	$      2193.57	$            958.60	$     39990.76
         6	$      2193.57	$           1125.23	$     37963.81
         7	$      2193.57	$           1283.41	$     35928.43
         8	$      2193.57	$           1433.12	$     33884.56
         9	$      2193.57	$           1574.30	$     31832.18
        10	$      2193.57	$           1706.94	$     29771.24
        11	$      2193.57	$           1830.98	$     27701.72
        12	$      2193.57	$           1946.41	$     25623.57
        13	$      2193.57	$           2053.17	$     23536.77
        14	$      2193.57	$           2151.24	$     21441.27
        15	$      2193.57	$           2240.58	$     19337.04
        16	$      2193.57	$           2321.15	$     17224.04
        17	$      2193.57	$           2392.92	$     15102.24
        18	$      2193.57	$           2455.84	$     12971.59
        19	$      2193.57	$           2509.89	$     10832.07
        20	$      2193.57	$           2555.03	$      8683.64
        21	$      2193.57	$           2591.21	$      6526.25
        22	$      2193.57	$           2618.40	$      4359.87
        23	$      2193.57	$           2636.57	$      2184.47
        24	$      2193.57	$           2645.67	$        -0.00
Would you like to run again?(y or n): y
Enter the Loan amount: 
100000
Enter your interest rate as percent: 6
Enter your term in years: 
4
     Month	  Month Payment	 Total Interest Paid	        Balance
         1	$      2348.50	$            500.00	$     98151.50
         2	$      2348.50	$            990.76	$     96293.75
         3	$      2348.50	$           1472.23	$     94426.72
         4	$      2348.50	$           1944.36	$     92550.35
         5	$      2348.50	$           2407.11	$     90664.60
         6	$      2348.50	$           2860.43	$     88769.42
         7	$      2348.50	$           3304.28	$     86864.76
         8	$      2348.50	$           3738.61	$     84950.58
         9	$      2348.50	$           4163.36	$     83026.83
        10	$      2348.50	$           4578.49	$     81093.46
        11	$      2348.50	$           4983.96	$     79150.43
        12	$      2348.50	$           5379.71	$     77197.68
        13	$      2348.50	$           5765.70	$     75235.16
        14	$      2348.50	$           6141.88	$     73262.84
        15	$      2348.50	$           6508.19	$     71280.65
        16	$      2348.50	$           6864.59	$     69288.55
        17	$      2348.50	$           7211.04	$     67286.49
        18	$      2348.50	$           7547.47	$     65274.42
        19	$      2348.50	$           7873.84	$     63252.29
        20	$      2348.50	$           8190.10	$     61220.04
        21	$      2348.50	$           8496.20	$     59177.64
        22	$      2348.50	$           8792.09	$     57125.03
        23	$      2348.50	$           9077.72	$     55062.15
        24	$      2348.50	$           9353.03	$     52988.96
        25	$      2348.50	$           9617.97	$     50905.40
        26	$      2348.50	$           9872.50	$     48811.42
        27	$      2348.50	$          10116.56	$     46706.98
        28	$      2348.50	$          10350.09	$     44592.01
        29	$      2348.50	$          10573.05	$     42466.47
        30	$      2348.50	$          10785.38	$     40330.30
        31	$      2348.50	$          10987.03	$     38183.44
        32	$      2348.50	$          11177.95	$     36025.86
        33	$      2348.50	$          11358.08	$     33857.48
        34	$      2348.50	$          11527.37	$     31678.27
        35	$      2348.50	$          11685.76	$     29488.16
        36	$      2348.50	$          11833.20	$     27287.10
        37	$      2348.50	$          11969.64	$     25075.03
        38	$      2348.50	$          12095.01	$     22851.90
        39	$      2348.50	$          12209.27	$     20617.66
        40	$      2348.50	$          12312.36	$     18372.24
        41	$      2348.50	$          12404.22	$     16115.60
        42	$      2348.50	$          12484.80	$     13847.68
        43	$      2348.50	$          12554.04	$     11568.41
        44	$      2348.50	$          12611.88	$      9277.75
        45	$      2348.50	$          12658.27	$      6975.64
        46	$      2348.50	$          12693.15	$      4662.01
        47	$      2348.50	$          12716.46	$      2336.82
        48	$      2348.50	$          12728.14	$         0.00
Would you like to run again?(y or n): n
 * 
 * Sample for loop output
 *  This program will output your mortgage schedule
Enter the Loan amount: 
50000
Enter your interest rate as percent: 5
Enter your term in years: 
2
     Month	  Month Payment	 Total Interest Paid	        Balance
         1	$      2193.57	$            208.33	$     48014.76
         2	$      2193.57	$            408.39	$     46021.26
         3	$      2193.57	$            600.15	$     44019.44
         4	$      2193.57	$            783.56	$     42009.29
         5	$      2193.57	$            958.60	$     39990.76
         6	$      2193.57	$           1125.23	$     37963.81
         7	$      2193.57	$           1283.41	$     35928.43
         8	$      2193.57	$           1433.12	$     33884.56
         9	$      2193.57	$           1574.30	$     31832.18
        10	$      2193.57	$           1706.94	$     29771.24
        11	$      2193.57	$           1830.98	$     27701.72
        12	$      2193.57	$           1946.41	$     25623.57
        13	$      2193.57	$           2053.17	$     23536.77
        14	$      2193.57	$           2151.24	$     21441.27
        15	$      2193.57	$           2240.58	$     19337.04
        16	$      2193.57	$           2321.15	$     17224.04
        17	$      2193.57	$           2392.92	$     15102.24
        18	$      2193.57	$           2455.84	$     12971.59
        19	$      2193.57	$           2509.89	$     10832.07
        20	$      2193.57	$           2555.03	$      8683.64
        21	$      2193.57	$           2591.21	$      6526.25
        22	$      2193.57	$           2618.40	$      4359.87
        23	$      2193.57	$           2636.57	$      2184.47
        24	$      2193.57	$           2645.67	$        -0.00
Would you like to run again?(y or n): y
Enter the Loan amount: 
100000
Enter your interest rate as percent: 6
Enter your term in years: 
3
     Month	  Month Payment	 Total Interest Paid	        Balance
         1	$      3042.19	$            500.00	$     97457.81
         2	$      3042.19	$            987.29	$     94902.90
         3	$      3042.19	$           1461.80	$     92335.22
         4	$      3042.19	$           1923.48	$     89754.70
         5	$      3042.19	$           2372.25	$     87161.28
         6	$      3042.19	$           2808.06	$     84554.90
         7	$      3042.19	$           3230.83	$     81935.48
         8	$      3042.19	$           3640.51	$     79302.96
         9	$      3042.19	$           4037.03	$     76657.28
        10	$      3042.19	$           4420.31	$     73998.38
        11	$      3042.19	$           4790.30	$     71326.17
        12	$      3042.19	$           5146.94	$     68640.61
        13	$      3042.19	$           5490.14	$     65941.62
        14	$      3042.19	$           5819.85	$     63229.13
        15	$      3042.19	$           6135.99	$     60503.09
        16	$      3042.19	$           6438.51	$     57763.41
        17	$      3042.19	$           6727.32	$     55010.03
        18	$      3042.19	$           7002.37	$     52242.89
        19	$      3042.19	$           7263.59	$     49461.91
        20	$      3042.19	$           7510.90	$     46667.02
        21	$      3042.19	$           7744.23	$     43858.17
        22	$      3042.19	$           7963.52	$     41035.26
        23	$      3042.19	$           8168.70	$     38198.24
        24	$      3042.19	$           8359.69	$     35347.04
        25	$      3042.19	$           8536.43	$     32481.58
        26	$      3042.19	$           8698.84	$     29601.80
        27	$      3042.19	$           8846.84	$     26707.61
        28	$      3042.19	$           8980.38	$     23798.96
        29	$      3042.19	$           9099.38	$     20875.76
        30	$      3042.19	$           9203.76	$     17937.94
        31	$      3042.19	$           9293.45	$     14985.44
        32	$      3042.19	$           9368.37	$     12018.17
        33	$      3042.19	$           9428.46	$      9036.07
        34	$      3042.19	$           9473.64	$      6039.06
        35	$      3042.19	$           9503.84	$      3027.06
        36	$      3042.19	$           9518.97	$         0.00
Would you like to run again?(y or n): n
 */