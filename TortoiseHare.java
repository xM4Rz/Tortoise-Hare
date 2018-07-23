package OneDArrays;

import java.util.Arrays;
import java.util.Random;

public class TortoiseHare {
	static char hare[] = new char[60];
	static char tortoise[] = new char[60];
	
	
	
	static Random h = new Random();
	static Random t = new Random();
	static int posH = 1;
	static int posT = 1;
	public static void runFastT(){
		tortoise[posT] = '-';
		if (posT+3<59){
		tortoise[posT+3] = 'T';
		posT = posT +3;
		}else{
			posT = 59;
			tortoise[59] = 'T';
		}
	}
	public static void runSlowT(){
		tortoise[posT] = '-';
		if (posT+1<59){
		tortoise[posT+1] = 'T';
		posT = posT +1;
		}else{
		posT = 59;
		tortoise[59] = 'T';
		}
	}
	public static void misstepT(){
		tortoise[posT] = '-';
		if (posT-6>0){
		tortoise[posT-6] = 'T';
		posT = posT -6;
		}
		else{
			tortoise[posT] = '-';
			posT = 0;
			tortoise[posT] = 'T';
		}
	}
	public static void runFastH(){
		hare[posH] = '-';
		if (posH+9<59){
		hare[posH+9] = 'H';
		posH = posH +9;
		}else{
		posH = 59;
		hare[59] = 'H';
		}
	}
	public static void runSlowH(){
		hare[posH] = '-';
		if (posH+3<59){
		hare[posH+3] = 'H';
		posH = posH +3;
		}else{
		posH = 59;
		hare[59] = 'H';
		}
	}
	public static void stopH(){
		hare[posH] = 'H';
	}
	public static void smallMisstepH(){
		hare[posH] = '-';
		if (posH-2>0){
		hare[posH-2] = 'H';
		posH = posH -2;
		}
		else{
			hare[posH] = '-';
			posH = 0;
			hare[posH] = 'H';
		}
	}
	public static void bigMisstepH(){
		hare[posH] = '-';
		if (posH-12>0){
		hare[posH-12] = 'H';
		posH = posH -12;
		}
		else{
			hare[posH] = '-';
			posH = 0;
			hare[posH] = 'H';
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Arrays.fill(hare, '-');
		Arrays.fill(tortoise, '-');
		while(posT < 59 || posH<59){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
			float chance = t.nextFloat();
			if (chance<=.5f){
				runFastT();
				for(int i = 0; i<59; i++){
					System.out.print(tortoise[i]);
				}
				
				Thread.sleep(500);
			}
			else if (chance<=.8f || chance >=.5f){
				runSlowT();
				for(int i = 0; i<59; i++){
					System.out.print(tortoise[i]);
				}
				Thread.sleep(500);
			}
			else if (chance<=1f || chance >=.8f){
				misstepT();
				for(int i = 0; i<59; i++){
					System.out.print(tortoise[i]);
				}
			}
			Thread.sleep(500);
			System.out.println();
			float chanceH = h.nextFloat();
			System.out.println("\n");
			if (chanceH<=.2f){
				runFastH();
				for(int i = 0; i<59; i++){
					System.out.print(hare[i]);
					
				}
				Thread.sleep(500);
				
			}
			else if (chanceH<=.5f || chance >=.2f){
				runSlowH();
				for(int i = 0; i<59; i++){
					System.out.print(hare[i]);
				}
				
			}

			else if (chanceH<=.5f || chance >=.7f){
				stopH();
				for(int i = 0; i<59; i++){
					System.out.print(hare[i]);
				}
				Thread.sleep(500);
			}

			else if (chanceH<=.7f || chance >=.9f){
				smallMisstepH();
				for(int i = 0; i<59; i++){
					System.out.print(hare[i]);
				}
				Thread.sleep(500);
			}


			else if (chanceH<=.9f || chance >=1f){
				bigMisstepH();
				for(int i = 0; i<59; i++){
					System.out.print(hare[i]);
				}
				Thread.sleep(500);
			}
			

		}
		
	}
	
	
}
