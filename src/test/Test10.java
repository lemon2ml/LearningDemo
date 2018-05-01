package test;
public class Test10 {
	
	public static void main(String[] args) {
		int [] array = {};
		new Test10().reOrderArray(array);
	}
	
	
    public void reOrderArray(int [] array) {
        int odd1 = 0, odd2 = 0;
        int [] array1 = array;
        boolean flag = true;
        if(array[0]%2==0){
            for(int i=1;i<array.length;i++){
                int tmp = array[i];
                array[i] = array[i-1];
                if(tmp % 2 == 1) {
                    array[0]=tmp;
                    odd2 = i;
                    break;
                }
                if(i ==array.length-1) {
                    array = array1;
                    flag = false;
                }
            }
        }
        
        if(flag){
            for(int i=odd2+1;i<array.length;i++){
                if(array[i]%2==1){
                    odd2 = i;
                    int tmp = array[odd2];
                    for(int j=odd2;j>odd1;j--){
                        array[j] = array[j-1];
                    }
                    array[++odd1] = tmp;
                }
            }
        }
        
    }
}