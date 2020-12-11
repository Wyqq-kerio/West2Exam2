package question2;

public class MulThread1 {

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// int x = scanner.nextInt();
		int x = 9;
		double a = System.currentTimeMillis();
		
		  //for (long i = 1; i < 1000000000; i++) { if (contain(i, x)) ans += i; }
		 
		System.out.println((System.currentTimeMillis() - a) + "ms");
		System.out.println(ans);
		ans = 0;
		a = System.currentTimeMillis();
		MyThread myThread = new MyThread(0, 500, x, 0);
		myThread.start();
		MyThread myThread1 = new MyThread(501, 1000000000, x, 1);
		myThread1.start();
		
//		  //System.out.println(myThread.isInterrupted());
//		  while(!(myThread.isInterrupted()&&myThread1.isInterrupted())){
//			  //System.out.println(ans + ans2);
//		  }
		boolean flag=false;
		 boolean flag1=false;
		 while(!(flag&&flag1)){
			 //System.out.println(ans + ans2);
			 flag=myThread.isInterrupted();
			 flag1=myThread1.isInterrupted();
		 }
		 System.out.print(ans+ans2);
		System.out.println((System.currentTimeMillis() - a) + "ms");
		System.out.println(ans + ans2);

	}

	private static boolean contain(long num, int x) {
		return String.valueOf(num).contains(String.valueOf(x));
	}

	static long ans;
	static long ans2;

	static class MyThread extends Thread {
		private int start;
		private int end;
		private int x;
		private int check;

		@Override
		public void run() {
			long res = 0;
			for (int i = start; i <= end; i++) {
				if (contain(i, x)) {
					res += i;
					//System.out.println(res);
				}
			}
			if (check == 0)
				ans = res;
			else
				ans2 = res;
			//System.out.println("finish");
			this.interrupt();
			//System.out.println("int");
		}

		public MyThread(int start, int end, int x, int check) {
			this.start = start;
			this.end = end;
			this.x = x;
			this.check = check;
		}

	}

}
