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

    public class CSCAN
{
	 public static void CSCAN()
	{
		int StartHead,n,PrevHead = 0,DiskSize;
		
		System.out.println("Enter initial header location: ");
		Scanner sc = new Scanner(System.in);
		StartHead = sc.nextInt();
		
//		System.out.println("Enter previous header location: ");
//		prev_head = sc.nextInt();
                         Scanner input = new Scanner(System.in);
System.out.println("Please choose 1 FOR LEFT  2 FOR RIGHT direction: "+"\n");
 
String msg = input.nextLine();
int algorithm = Integer.valueOf(msg);
     

            String algostring;
            switch (algorithm) {
                case 1:  algostring = "L";
                 PrevHead=StartHead+1;
                         System.out.println("you've chosen LEFT"+"\n");
                        
                         break;
                         
                case 2:  algostring = "R";
                 PrevHead=StartHead-1;
                         System.out.println("you've chosen RIGHT"+"\n");
                        
                         break;
                
            }
		
		System.out.println("Enter disk size: ");
		DiskSize = sc.nextInt();
		
		System.out.println("Enter number of disk locations: ");
		n = sc.nextInt();
		
		int[] disk_location = new int[n];
		int dl=0,seek_time=0,i = 0,j,f=0;
		
		System.out.println("Enter disk locations: ");
		   while(i<n){
                             disk_location[i]=sc.nextInt() ;
                 if(DiskSize<disk_location[i]){
                               
                     System.out.println("invalid enter this location again");
                     disk_location[i]=sc.nextInt() ;
                        
                     
                   
                    
             }
                 i++;
             }
		
		//Arrays.sort(disk_location);
		
		int[] visited = new int[n+1];
		
		System.out.println("Disk Location \t Seek Time");
		
                
                
                
                
                

                
  
        if(PrevHead<=StartHead) f=0;
		else f=1;
		
		for(i=0;i<n;i++)
		{
			int pos = -1;
			int min = 10000;
			for(j=0;j<n;j++)
			{
				if(f==0)
				{
					if(disk_location[j]>StartHead && min>disk_location[j]-StartHead && visited[j]==0)
					{
						min = disk_location[j] - StartHead;
						pos = j;
					}
				}
				
				else if(f==1)
				{
					if(disk_location[j]<=StartHead && min>StartHead-disk_location[j] && visited[j]==0)
					{
						pos = j;
						min = StartHead-disk_location[j];
					}
				}
			}
			//System.out.println(pos);
			if(pos==-1)
			{
				if(f==0)
				{
					seek_time += Math.abs(DiskSize - StartHead);
					System.out.println(DiskSize+"\t\t "+seek_time);
					StartHead = 0;
				}
				else 
				{
					seek_time += Math.abs(0 - StartHead);
					System.out.println(0+"\t\t "+seek_time);
					StartHead = DiskSize;
				}
				System.out.println("-------------------------------------------------");
				System.out.println("Changing Directions");
				System.out.println("-------------------------------------------------");
				System.out.println("Disk Location \t Seek Time");
				i--;
				continue;
			}
			visited[pos] = 1;
			seek_time += Math.abs(disk_location[pos] - StartHead);
			System.out.println(disk_location[pos]+"\t\t "+seek_time);
			StartHead = disk_location[pos];
		}
		
		System.out.println();
		System.out.println("Total Seek Time :"+seek_time);
	}
}





