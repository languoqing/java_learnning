package com.languoqing;

public class Dengyao {
	
	public static void main(String [] args){
		//getZhijiao(4,1);
		printXing(4);
	}
	
/**
 * 打印 **
 */
	public static void printXing(int changdu){
		int m = 0;
		for ( m = 1; m<changdu;m++){
			
			for(int xing = 0; xing<m;xing++){
				//打印空格
				System.out.print("*");
				System.out.print("m"+m);
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 打印空格
	 */
	
	public static void printSpace(int changdu){
		
		for (int m = changdu; m>0;m--){
			
			for(int space = m-1; space>0;space--){
				//打印空格
				System.out.print("+");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param changdu
	 * @param type 1:直角；2：倒直角
	 */
	public static void getZhijiao(int changdu,int type){
		
		//等腰三角形 4*4
		//控制循环层数 ->高
		if(type == 1){
			for (int m = 1; m<=changdu;m++){
				//打印*
				for(int xing=m;xing>0;xing--){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		if(type == 2){
			for (int m = changdu; m>0;m--){
				//打印*
				for(int xing=0;xing<m;xing++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
	}
	
	/**
	 * 等边
	 * @param changdu
	 * @param type 1:正等边；2倒等边
	 */
	
	public static void getDengyao(int changdu,int type){
		
		if(type == 1){
			//控制循环层数->高
			for(int high=0;high<=changdu;high++){
				//打印每行空格
				for(int a =changdu-high;a>0;a--){
					System.out.print(" ");
				
				}
				//打印*
				for(int xing =high;xing>0;xing--){
				System.out.print("*"+" ");
	
				}
			System.out.println();
			}
		}
		if (type == 2){
			for(int high=changdu;high>0;high--){
				for(int a =changdu-high;a>0;a--){
					System.out.print(" ");
				
				}
				for(int xing =high;xing>0;xing--){
				System.out.print("*"+" ");
	
				}
			System.out.println();
			}
			
		}
	}
			
		/**
		 * 
		 * @param changdu
		 * @param type 区分去重拿个等边三角形的重边
		 */
	public static void getLengxing(int changdu,int type){
		//正等边三角形
		getDengyao(changdu,type);
		//倒等边三角形，把重复边去掉
		for(int high=changdu-1;high>0;high--){
			for(int a =changdu-high;a>0;a--){
				System.out.print(" ");
			
			}
			for(int xing =high;xing>0;xing--){
			System.out.print("*"+" ");

			}
		System.out.println();
		}
		
	}
	
	
	
	public static void getPingxingSibian(int changdu) {
		//控制高度
		for(int high = changdu ; high>0;high-- ){
			//打印空格
			for(int space = high;space >0;space--){
				System.out.print(" ");
				
			}
			for(int xing = changdu;xing>0;xing--){
				System.out.print("*"+" ");
			}
			System.out.println();
		}
		
	}		
		
		
		
	}
	
	
	
	
	
	
	
	
	

