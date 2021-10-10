package javaprograms;

public class MinandMaxArrays {
	
		public static void main(String args[]){
		int a[]={4,8,9,6,5,7};
		int min=a[0];
		int max=a[0];
		int minloc=0;
		int maxloc=0;
		for(int i=0;i<a.length;i++){
		if(a[i]<min){
		min=a[i];
		minloc=i;
		}
		if(a[i]>max){
		max=a[i];
		maxloc=i;
		}
		}
		System.out.println("maximum="+max+"location="+maxloc);
		System.out.println("minimum="+min+"location="+minloc);
		}
		}

