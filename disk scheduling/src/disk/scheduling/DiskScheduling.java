/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disk.scheduling;

import static disk.scheduling.CSCAN.CSCAN;
import static disk.scheduling.FCFS.fcfs;
import static disk.scheduling.SCAN.scan;
import static disk.scheduling.SSTF.SSTF;
import static disk.scheduling.LOOK.LOOK;
import static disk.scheduling.CLOOK.CLOOK;
import java.util.Scanner;

/**
 *
 * @author mahmo
 */
public class DiskScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
System.out.println("Please enter the number of the algorithm to be calculated: "+"\n");
 System.out.println("1- FCFS"+"\n"
         + "2- SCAN" +"\n"+ "3- CSCAN"+"\n"+ "4- SSTF"+"\n"+ "5- LOOK"+"\n"+ "6- CLOOK" );
String msg = in.nextLine();
int algorithm = Integer.valueOf(msg);


            String algostring;
            switch (algorithm) {
                case 1:  algostring = "FCFS";
                         System.out.println("you've chosen first come first served"+"\n");
                        
                         fcfs();
                         break;
                         
                           case 2:  algostring = "scan";
                System.out.println("you've chosen SCAN"+"\n");
                
                         scan();
                        break;
                         case 3:  algostring = "c scan";
                 System.out.println("you've chosen CSCAN"+"\n");
                
                         CSCAN();
                        break;
                        
                            case 4:  algostring = "SSTF";
                 System.out.println("you've chosen SSTF"+"\n");
                
                         SSTF();
                        break;
                
                            case 5:  algostring = "LOOK";
                 System.out.println("you've chosen LOOK"+"\n");
                
                         LOOK();
                        break;
                        
                                  case 6:  algostring = "CLOOK";
                 System.out.println("you've chosen CLOOK"+"\n");
                
                         CLOOK();
                        break;
                
                  default: algostring = "Invalid input";
                         break;
            }
    }
}
