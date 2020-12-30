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
public class CLOOK {
    public static void CLOOK()
	{
		int StartHead,n,PrevHead = 0,max_loc=0,min_loc=10000;
		
		System.out.println("Enter initial header location: ");
		Scanner sc = new Scanner(System.in);
		StartHead = sc.nextInt();
		
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

            
		
		System.out.println("Enter number of disk locations: ");
		n = sc.nextInt();
		
		int[] disk_location = new int[n];
		int dl=0,seek_time=0,i,j,f=0,d=0;
		
		System.out.println("Enter disk locations: ");
		for(i=0;i<n;i++) 
		{
			disk_location[i] = sc.nextInt();
			if(disk_location[i]<min_loc) min_loc = disk_location[i];
			if(disk_location[i]>max_loc) max_loc = disk_location[i];
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
				if(d==1)
				{
					if(disk_location[j] == StartHead) 
					{
						pos=j;
						break;
					}
				}
				else
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
			}
			//System.out.println(pos);
			if(pos==-1)
			{
				if(f==0)
				{
					StartHead = min_loc;
					//System.out.println(ini_head);
					d=1;
				}
				else 
				{
					StartHead = max_loc;
					//System.out.println(ini_head);
					d=1;
				}
				System.out.println("-------------------------------------------------");
				System.out.println("Changing Directions");
				System.out.println("-------------------------------------------------");
				System.out.println("Disk Location \t Seek Time");
				i--;
				continue;
			}
			visited[pos] = 1;
			if(d==0) seek_time += Math.abs(disk_location[pos] - StartHead);
			else if(d==1) d=0;
			System.out.println(disk_location[pos]+"\t\t "+seek_time);
			StartHead = disk_location[pos];
		}
		
		System.out.println();
		System.out.println("Total Seek Time :"+seek_time);
	}
    
}
