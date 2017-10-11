import java.util.Scanner;

public class BinaryRepresentationOfInteger {
	private static final int noOFBits = 14;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = Integer.parseInt(sc.nextLine());
		for(int i = 0 ; i <numOfTests ; i++ ){
			String binaryRep = getBinaryForInt(Integer.parseInt(sc.nextLine())); 
			System.out.println(binaryRep);
		}
		sc.close();
	}
	private static String getBinaryForInt(Integer num){
		if(num > Integer.parseInt("11111111111111", 2))
			throw new IllegalArgumentException("Input number is not valid. Input: " + num );
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<noOFBits ; i++, num /=2){
			switch(num % 2){
			case 0:
				sb.insert(0, "0");
				break;
			case 1:
				sb.insert(0,"1");
			}
		}
		return sb.toString();
	}}
