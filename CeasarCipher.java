import java.util.*;
import java.lang.*;
class CeasarCipher{
	
	private static String encrypt(String s, int e){
		char[] ch = s.toCharArray();
		for(int i=0; i<ch.length; i++){
			if(ch[i]>=65 && ch[i]<=90){
				ch[i]+=e;
				if(ch[i]>90)
					ch[i]-=26;
			}
			else if(ch[i]>=97 && ch[i]<=122){
				ch[i]+=e;
				if(ch[i]>122)
					ch[i]-=26;
			}
		}
		return String.valueOf(ch);
	}
	
	private static String decrypt(String s, int d){
		char[] ch = s.toCharArray();
		for(int i=0; i<ch.length; i++){
			if(ch[i]>=65 && ch[i]<=90){
				ch[i]-=d;
				if(ch[i]<65)
					ch[i]+=26;
			}
			else if(ch[i]>=97 && ch[i]<=122){
				ch[i]-=d;
				if(ch[i]<97)
					ch[i]+=26;
			}
		}
		return new String(ch);
	}
	
	public static void main(String []args){
		Scanner sc =  new Scanner(System.in);
		System.out.println("Type 1 to encrypt, 2 to decrypt");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter your message: ");
		String s = sc.nextLine();
		if(n==1){
			System.out.print("Enter the key: ");
			int e = sc.nextInt();
			if(e>26 || e<-26)
				e%=26;
			if(e>0)
				System.out.print("\n" + encrypt(s, e));
			else if(e<0){
				e=Math.abs(e);
				System.out.print("\n" + decrypt(s, e));
			}
		}
		else if(n==2){
			System.out.print("Enter the key: ");
			int d = sc.nextInt();
			if(d>26 || d<-26)
				d%=26;
			if(d>0)
				System.out.print("\n" + decrypt(s, d));
			else if(d<0){
				d=Math.abs(d);
				System.out.print("\n" + encrypt(s, d));
			}
		}
		else{
			System.out.println("Invalid Input");
		}
	}
}
