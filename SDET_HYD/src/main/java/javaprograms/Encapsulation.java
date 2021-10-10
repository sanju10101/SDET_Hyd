package javaprograms;

public class Encapsulation {
	private String productcode;
	private String productname;
	private double productprice;
	public void setsandeep_product(String productcode,String productname,double productprice){//BY USING ENCAPUSLATION SETTER AND GETTER METHODS
	this.productcode=productcode;
	this.productname=productname;
	this.productprice=productprice;
	}
	public String getsandeep_product(){
	if(productcode=="p101"&&productname=="laptopproduct"&&productprice==45000.00){
	display(); //if condition true executing display method
	return "valid";
	}else{
	return "invalid";
	}
	}
	public void display(){
	System.out.println(productcode+" "+productname+" "+productprice);
	}
	public static void main(String args[]){
	Encapsulation sp=new Encapsulation();
	sp.setsandeep_product("p101","laptopproduct",45000.00);
	System.out.println(sp.getsandeep_product());
	}
}
