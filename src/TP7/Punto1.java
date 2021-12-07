package TP7;

public class Punto1 {
	public static void main(String[] args) {
		System.out.println(dummyRecurrent(5));
	}
	
	public static int dummyRecurrent(int n) {
		int result=0;
		if(n==0) {
			result=0;
		}else {
			result+= dummyRecurrent(n-1)+dummyRecurrent(n-1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result++;
				}
			}
		}
		return result;
	}
}
