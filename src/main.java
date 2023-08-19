import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		System.out.print("Question 1 : ");
		String number1 = Keyboard.nextLine();
		System.out.println("=> " + findCountString(number1));
		System.out.print("Question 2 : ");
		String data2 = Keyboard.nextLine();
		System.out.println("=> " + findPalindrome(data2));
		System.out.print("Question 3 : ");
		int temperature = Keyboard.nextInt();
		System.out.println("=> " + convertToTime(temperature));
	}

	public static int findCountString(String inputString) {
		int max = 0;
		HashSet<Character> data = new HashSet<Character>();
		for (int i = 0; i < inputString.length(); i++) {
			data.add(inputString.charAt(i));
		}
		
		for (Character character : data) {
			int count = 0;
			for (int i = 0; i < inputString.length(); i++) {
				if (character == inputString.charAt(i)) {
					count++;
				}
				max = max > count ? max : count;
			}
		}
		return max;
	}
	
	public static boolean findPalindrome(String inputString) {
		boolean result = false;
		String newString = "";
		for (int i = inputString.length()-1; i >= 0 ;i--) {
			newString += Character.toString(inputString.charAt(i));
		}
		if(inputString.equals(newString)) {
			result = true;
		}
		return result;
	}
	
	public static String convertToTime(int dataTemperature) {
		double result ;
		String resultTime = "";     
		DecimalFormat df = new DecimalFormat("#.00");
		String hour = "";  
		if(dataTemperature<=0) {
			resultTime = "00:00";
		}else {
			result = dataTemperature * 2;
			if(60 > result) {
				resultTime = Double.toString(result/100);
				resultTime = "0"+resultTime.replace(".", ":");
			}else {
				String resultString = df.format(result/60);
				String[] spiltResult = resultString.split("\\.");
				if(Integer.parseInt(spiltResult[0]) <10) {
					hour = "0"+spiltResult[0];
				}else {
					hour = spiltResult[0];
				}
				double resultMin =  (Integer.valueOf(spiltResult[1])*60.00)/100.00;
				if(Math.round(resultMin) < 10) {
					resultTime = hour + ":0" + Math.round(resultMin);
				}else {
					resultTime = hour + ":" + Math.round(resultMin);
				}
				
			}
		}
		return resultTime;
	}
	
	
	
}
