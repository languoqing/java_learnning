package languoqing;


/*��Ŀ����ӡ����������Σ�Ҫ���ӡ��10������ͼ�� 
 *1 
 *1 1 
 *1 2 1 
 *1 3 3 1 
 *1 4 6 4 1 
 *1 5 10 10 5 1 
 */

//ÿһ�е�Ԫ�ص�����һ�е�ǰ����Ԫ��֮��,�������ߵ�1���м����Ϊ����ǰ����Ԫ��֮��

public class Yanghuisanjiang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ����ά���飬�����к�������ĵ���Ԫ��
		getResult(6);
	
	}
	
	
	/**
	 * @param arg
	 */
	
	//��Ҫ�������ʼ������
	public static void getResult(int arg){
		
		int [][] arry = new int [arg][arg];
		
		//��������
		for(int hang =0;hang <=arg;hang++){
			
			//ȡ�������Ԫ��
			for(int yuansu=0;yuansu<=hang;yuansu++){
				if(yuansu == 0){
					arry[hang][yuansu] = 1;
				}else if(hang == yuansu){
					arry[hang][yuansu] = 1;
				}else {
					arry[hang][yuansu] = arry[hang-1][yuansu-1] + arry[hang-1][yuansu];
				}
				System.out.print(arry[hang][yuansu]+" ");
				
			}
			System.out.println();
		}
	}	

}