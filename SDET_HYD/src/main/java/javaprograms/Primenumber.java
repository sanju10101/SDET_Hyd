package javaprograms;

public class Primenumber {
	
		public static void main(String args[]){
		int i;
		int j;
		int count=0;
		int n=20;
		for(i=2;i<=n;i++)
		{
		count=0;
		for(j=1;j<=i;j++)
		{
		if(i%j==0){
		count=count+1;
		}
		}
		}
		if(count==2)
		{
		System.out.println(i+"is prime");
		}
		else
		{
		System.out.println(i+"is non-prime");
		}
		}
		}

