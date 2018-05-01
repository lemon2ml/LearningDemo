package test;

public class Test5 implements Runnable{
	String flagStr;

	public Test5(String flagStr) {
		this.flagStr = flagStr;
	}
	public static void main(String[] args) {
		//start()将就绪线程排队，在cpu空闲时调用线程，前后两个之间调用顺序混合。
//		new Thread(new Test5("Thread 11111111111111111 running state...")).start();
//		new Thread(new Test5("Thread 22222222222222222 running state...")).start();
		//直接调用run()函数，相当于普通函数，顺序执行完前一个调用后才执行第二个。
		new Test5("Thread 11111111111111111 running state...").run();
		new Test5("Thread 22222222222222222 running state...").run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10000000;i++) {
			System.out.println(flagStr);
		}

		
	}

}
