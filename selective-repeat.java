import java.util.*;
public class sr {

	public static void main(String[] args) 
	{		
		int ws ;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the sender/receiver window size (ws > 1): ");
		ws=sc.nextInt();
		
		
		while(true)
		{
			int []pkt = new int [ws+ws];
			String rpl;
			int c=0;
			for(int i=0;i<ws;i++)
			{
				System.out.println("Packet "+ (c+1)+" sent , ACK received ? ");
				rpl=sc.next();
				c+=1;
				if(rpl.equals("y"))
				{
					pkt[i]=i+1;
				}
				else
				{
					pkt[i]=0;
				}
				
				System.out.println("More packets to send ?");
				rpl=sc.next();
				if(rpl.equals("n"))
				{
					for(int j=0;j<c;j++)
					{
						if(pkt[j]==0)
						{
							System.out.println("Resending packet "+ (j+1) );
							pkt[j+ws]=j+1;
						}
					}
					
					sc.close();
					System.exit(0);
				}
			}

			for(int j=0;j<ws*2;j++)
			{
				for(int k=1;k<c+1;k++)
				{
					if(pkt[j]==k)
						break;
					else if(k==c+1 && pkt[j]!=k)
						System.out.println("Resending packet "+(k));
				}
			}
			
			
			System.out.println("More packets to send ?");
			rpl=sc.next();
			
			if(rpl.equals("n"))
			{
				sc.close();
				System.exit(0);
			}
			
			
		}

	}

}
