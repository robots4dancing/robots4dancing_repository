package hexDecConverter;

import java.util.Scanner;

public class HexDecConverter {
	private String hex = "";
	private int dec = 0;

	public void setHex(String hex)
	{
		this.hex = hex;
	}

	public void setDec(int dec)
	{
		this.dec = dec;
	}

	public void outputHex()
	{
		System.out.println(hex);
	}

	public void outputDec()
	{
		System.out.println(dec);
	}

	public int hexToDec(String hex)
	{
		int count1 = 0, count2 = 0, decNum = 0, power = 1;
		char hexNum = '\n';

		count1 = hex.length();
		this.hex = hex.toLowerCase();
		for(int i = 0; i < count1; i++)
		{
			hexNum = this.hex.charAt(i);
			switch(hexNum)
			{
			case '0': decNum = 0;
			break;
			case '1': decNum = 1;
			break;
			case '2': decNum = 2;
			break;
			case '3': decNum = 3;
			break;
			case '4': decNum = 4;
			break;
			case '5': decNum = 5;
			break;
			case '6': decNum = 6;
			break;
			case '7': decNum = 7;
			break;
			case '8': decNum = 8;
			break;
			case '9': decNum = 9;
			break;
			case 'a': decNum = 10;
			break;
			case 'b': decNum = 11;
			break;
			case 'c': decNum = 12;
			break;
			case 'd': decNum = 13;
			break;
			case 'e': decNum = 14;
			break;
			case 'f': decNum = 15;
			break;
			}
			count2 = count1 - 1;
			while(i < count2)
			{
				power *= 16;
				count2--;
			}
			decNum *= power;
			dec += decNum;
			power = 1;
		}
		return dec;
	}

	public String decToHex(int dec)
	{
		int count1 = 0, count2 = 0, decNum = 0, power = 1;
		String hexNum = "";

		this.dec = dec;
		while(this.dec >= 0)
		{
			if(dec == 0)
			{
				hex = "0";
				break;
			}
			else if(dec == this.dec)
			{
				while(this.dec >= power)
				{
					power *= 16;
					count1++;
				}
					power /= 16;
			}
			else if(count1 != 0)
			{
				while(count2 > 1)
				{
					power *= 16;
					count2--;
				}
			}
			else
				break;
			if(this.dec != 0)
				decNum = this.dec / power;
			else
				decNum = this.dec;
			switch(decNum)
			{
			case 0: hexNum = "0";
			break;
			case 1: hexNum = "1";
			break;
			case 2: hexNum = "2";
			break;
			case 3: hexNum = "3";
			break;
			case 4: hexNum = "4";
			break;
			case 5: hexNum = "5";
			break;
			case 6: hexNum = "6";
			break;
			case 7: hexNum = "7";
			break;
			case 8: hexNum = "8";
			break;
			case 9: hexNum = "9";
			break;
			case 10: hexNum = "A";
			break;
			case 11: hexNum = "B";
			break;
			case 12: hexNum = "C";
			break;
			case 13: hexNum = "D";
			break;
			case 14: hexNum = "E";
			break;
			case 15: hexNum = "F";
			break;
			}	
			this.dec -= decNum * power;
			hex += hexNum;
			count1--;
			count2 = count1;
			power = 1;
		}
		return hex;
	}

	public static void main(String[] args) {
		String inputHex = "";
		int inputDec = 0;

		Scanner keyboard = new Scanner(System.in);
		HexDecConverter htc1 = new HexDecConverter();
		HexDecConverter cth1 = new HexDecConverter();

		System.out.println("Please input Hexadecimal to convert to Decimal: ");
		inputHex = keyboard.next();
		htc1.setHex(inputHex);
		htc1.hexToDec(inputHex);
		htc1.outputDec();

		System.out.println("Please input Decimal to convert to Hexadecimal: ");
		inputDec = keyboard.nextInt();
		cth1.setDec(inputDec);
		cth1.decToHex(inputDec);
		cth1.outputHex();


	}

}
