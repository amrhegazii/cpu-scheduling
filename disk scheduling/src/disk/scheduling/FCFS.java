/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disk.scheduling;

import java.util.Scanner;

/**
 *
 * @author mahmo
 */

public class FCFS {
    
     public static void fcfs()
	{
		int StartHead,n,DiskSize;
                //two varible intial head el betbda2 mno w n 3adad el location el betrohaa
                
		System.out.println("Enter start header location: ");
		Scanner sc = new Scanner(System.in);
		StartHead = sc.nextInt();  
                // hanbda2 mn anhy rakam  
                System.out.println("Enter disk size: ");
		DiskSize = sc.nextInt();
                
		System.out.println("Enter number of disk locations: ");
		n = sc.nextInt();
                // yakhod number of disc locations
                
		int[] disk_location = new int[n];
                // 3arraf array lel disk location 3shan n save feh
                
		int dl=0,seek_time=0,i = 0;
                
		System.out.println("Enter the disk locations: ");
		   while(i<n){
                             disk_location[i]=sc.nextInt() ;
                 if(DiskSize<disk_location[i]){
                               
                     System.out.println("invalid enter this location again");
                     disk_location[i]=sc.nextInt() ;
                        
                     
                   
                    
             }
                 i++;
             }
                // to3od tdakhal arkam 
                
		System.out.println("Order \t Seek Time");
		dl = StartHead;
                //haybadel el dl b el initial head   
              
		for(i=0;i<n;i++)
		{
			System.out.print(disk_location[i]+" \t ");
			dl = Math.abs(dl - disk_location[i]);
			System.out.println(dl);
			seek_time+=dl;
			dl = disk_location[i];
		}
		System.out.println();
		System.out.println("Total Seek Time is:"+seek_time);
	}
}
