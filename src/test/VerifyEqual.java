package test;

public class VerifyEqual {
	int size = 1000;
	
	int num[];	
	
	public static void main(String[] args) {
		int total=0;
		VerifyEqual ve = new VerifyEqual();
		if(ve.powIntAdd(3, 5) == ve.num[6]) {
			System.out.println("��ʽ 3^3+4^3+5^3=6^3 ����");
		}else {
			System.out.println("��ʽ 3^3+4^3+5^3=6^3 ������");
		}
		if(ve.powIntAdd(6, 69)==ve.num[180]) {
			System.out.println("��ʽ 6^3+7^3+...+69^3=180^3 ����");
		}else {
			System.out.println("��ʽ 6^3+7^3+...+69^3=180^3 ������");
		}
		
		for(int i=0;i<ve.num.length;i++) {
			for(int j=i+1;j<ve.num.length;j++) {
				for(int k=j+1;k<ve.num.length;k++) {
					if(ve.powIntAdd(i, j) == ve.num[k]) {
						total++;
						System.out.println("��ʽ "+i+"^3+...+"+j+"^3="+k+"^3 ����");
					}
				}
			}
		}
		System.out.println("ƥ��ɹ���"+total+" ����ʽ");
	}
	public VerifyEqual() {
		num = new int[size];
		for(int i=0;i<num.length;i++) {
			num[i] = i*i*i;			
		}
	}
	
	public int powIntAdd(int a, int b) {
		int res = 0;
		for(int i=a;i<=b;i++) {
			res += num[i];
		}		
		return res;
	}

}












