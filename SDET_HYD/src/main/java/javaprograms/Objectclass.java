package javaprograms;

public class Objectclass {

		String name;
		int age;
		String sname;
		int sage;
		public void displayinfo()
		{
		System.out.println("i am" +name);
		System.out.println("my age is" +age);
		System.out.println("i am" +sname);
		System.out.println("my age is" +sage);
		}
		public static void main(String args[]){
		Objectclass personone = new Objectclass();
		personone.name="sandeep";
		personone.age=24;
	
		personone.sname="Sandeep";
		personone.sage=25;
		personone.displayinfo();
		}
		}


