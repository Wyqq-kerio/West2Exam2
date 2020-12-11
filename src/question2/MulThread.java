package question2;
// ������ֵ����ݻ�û��ѧ�ú����ף������еĲ��������������ͬѧTAT�����ʱ������ú�ѧϰ�ģ�����

import java.util.*;
public class MulThread {
	
	static long ans1,ans2;
	
	public static void main(String[] args) {
		// �������ַ�Χ
		System.out.println("�����룺");
	    Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		
		double a = System.currentTimeMillis(); 
		//System.out.println((System.currentTimeMillis() - a) + "ms");
		System.out.println(ans1);
		ans1=0;
		a = System.currentTimeMillis();
		// �ֳ�����
		MyThread myThread1 = new MyThread(0, 500, x, 0);
		myThread1.start();
		MyThread myThread2 = new MyThread(501, 1000000000, x, 1);
		myThread2.start();
		
		boolean flag1=false;
		 boolean flag2=false;
		 while(!(flag1&&flag2)){
			 flag1=myThread1.isInterrupted();
			 flag2=myThread2.isInterrupted();
		 }
		System.out.print(ans1+ans2);
		//System.out.println((System.currentTimeMillis()-a) + " ms");
		System.out.println(ans1+ans2);

	}

	private static boolean contain(long n, int x) {
		
		boolean result=String.valueOf(n).contains(String.valueOf(x));
		return result;
	}

	static class MyThread extends Thread {
		private int start;
		private int end;
		private int x;
		private int check;

		public void run() {
			long res = 0;
			for (int i = start; i <= end; i++) {
				if (contain(i, x)) {
					res += i;
					//System.out.println(res);
				}
			}
			if (check == 0){
				ans1 = res;
			}else{
				ans2 = res;
			}
			System.out.println("finish");
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