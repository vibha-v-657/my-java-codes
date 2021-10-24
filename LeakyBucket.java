package leakybucket;
import java.util.*;
public class code 
{
	public static void main(String[] args)
	{
		int x,lct,l,i,dr,x_;
		int []ta;
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bucket size:");
		l=sc.nextInt();
		System.out.println("Enter the Drain rate:");
		dr=sc.nextInt();
		System.out.println("Enter the bucket increase size:");
		i=sc.nextInt();
		System.out.println("Enter the number of packets:");
		n=sc.nextInt();
		ta=new int[n];
		System.out.println("Enter the packet arrival times:");                 
		for(int z=0;z<n;z++)
			ta[z]=sc.nextInt();
		int temp=l;
		lct=ta[0];
		x=0;
		for(int z=0;z<n;z++)
		{
			x_=x-(ta[z]-lct);
			if(x_<0)
				x_=0;
			if(x_ > l)
			{
				System.out.println("Packet arrived at "+ta[z]+" Not Confirmed!! \n");
				l=l+(ta[z]-lct)*dr;
			}
			else
			{
				System.out.println("Packet arrived at "+ta[z]+" Confirmed!! \n");
				
				l-=1;
				l=l+(ta[z]-lct)*dr;
				if(l>temp)
					l=temp;
				lct=ta[z];
				x=x_+i;
			}
			
		}	
		
		sc.close();
		
		
	}

}
