package com.languoqing;

public class maopao {
	
	static int [] shuzu = new int[]{2,4,5,1,9,1000,987,675,432,187,980};
	public static void maopaopaixu(int[] args){
		for(int i=0;i<args.length;i++){
			for(int j=i+1;j<args.length;j++){
				if(args[i]<args[j]){
					int temp = 0;
					temp = args[j];
					args[j] = args[i];
					args[i] = temp ;
				}
			
			}
			
		}
		for(int i=0;i<args.length;i++){
			System.out.print(args[i]+";");
		}
		
		//System.out.print(args);
	}
	
	public static void main(String[] args){
		maopaopaixu(shuzu);
	}
}
