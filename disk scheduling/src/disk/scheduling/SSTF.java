/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disk.scheduling;

/**
 *
 * @author mahmo
 */
import java.util.*;


public class SSTF {
    
	public static void  SSTF()
	{ 
		int StartHead,n,DiskSize;
		
		System.out.println("Enter initial header location: ");
		Scanner sc = new Scanner(System.in);
		StartHead = sc.nextInt();
                
                
		
                		System.out.println("Enter disk size: ");
		DiskSize = sc.nextInt();
                
		System.out.println("Enter number of disk locations: ");
		n = sc.nextInt();
		
		int[] disk_location = new int[n];
		int dl=0,seek_time=0,i = 0,j;
		
		System.out.println("Enter disk locations: ");
		        
                    while(i<n){
                             disk_location[i]=sc.nextInt() ;
                 if(DiskSize<disk_location[i]){
                               
                     System.out.println("invalid enter this location again");
                     disk_location[i]=sc.nextInt() ;
                        
                     
                   
                    
             }
                 i++;
             }
		int[] visited = new int[n+1];
		
		System.out.println("Disk Location \t Seek Time");
		
		for(i=0;i<n;i++)
		{
			int min = 100000;
			int pos = 0;
			for(j=0;j<n;j++)
			{
				if(Math.abs(disk_location[j] - StartHead) < min)
				{
					if(visited[j]==0)
					{
						min = Math.abs(disk_location[j] - StartHead);
						pos = j;
					}
				}
			}
			visited[pos]=1;
			seek_time += Math.abs(disk_location[pos] - StartHead);
			System.out.println(disk_location[pos]+"\t\t "+seek_time);
                       
			StartHead = disk_location[pos];
		}
		
		System.out.println();
               
		System.out.println("Total Seek Time :"+seek_time);
	}
}
