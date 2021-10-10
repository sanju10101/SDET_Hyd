package javaprograms;

public class Duplicate {
	
		public static void main(String args[])
		{
		int a[]={1,2,4,6,4,7,6,9};
		for(int i=0;i<a.length-1;i++){
		for(int j=i+1;j<a.length;j++){
		if(a[i]==a[j]){
		System.out.println("duplicate element:"+a[j]);
		}
		}
		}
		}
		}

