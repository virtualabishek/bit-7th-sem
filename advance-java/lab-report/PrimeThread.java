class PrimeeCheck {
	public static boolean isPrime(int n) {
		if(n<=1) return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i ==0) return false;
		} return true;
	}
}
class EvenThread extends Thread {
	int limit;
	EvenThread(int limit) {
		this.limit = limit;
	}
	public void run() {
		for(int i =2; i<=limit; i+=2) {
			if(PrimeeCheck.isPrime(i)) {
				System.out.println("Even Thread prime: " + i);
			}
		}
	}
}
class OddThread extends Thread {
	int limit;
	OddThread(int limit) {
		this.limit = limit;
	}
	public void run() {
		for(int i = 1; i<=limit; i+=2) {
			if(PrimeeCheck.isPrime(i)) {
				System.out.println("Odd thread prime: "+ i);
			}
		}
	}
}
public  class PrimeThread {
	public static void main(String[] args) {
		int limit = 50;
		EvenThread t1 = new EvenThread(limit);
		OddThread t2 = new OddThread(limit);
		t1.start();
		t2.start();
	}
}