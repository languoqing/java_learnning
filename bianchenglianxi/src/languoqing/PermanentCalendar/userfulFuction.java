package com.languoqing.PermanentCalendar;


public class userfulFuction {
	/**
	 * �ж��Ƿ�������
	 * @author Jor
	 * @since 2016-06-25
	 * @param year
	 */
	public static boolean isLeapYear(int year){
		//�����ж�
		if(year%400 == 0 || (year%4 == 0 && year%100 !=0)){
			return true;
		}
		return false;
	}

	/**
	 *�����������
	 */
	public static int countYearDays(int year){
		//�����ж�
		if(isLeapYear(year)){
			return 366;
		}
		return 365;
	}
	
	/**
	 * ������������
	 * @param month
	 * 
	 */
	public static int countMonthDays(int year,int month) {
		//����{1��3��5��7��8��10��12}
		int[] arrayMonth = new int[]{1,3,5,7,8,10,12};
		for(int m=0; m<arrayMonth.length; m++){
			if(month == arrayMonth[m]){
				return 31;
			}
		}
		//����2����29��
		if(month == 2){
			if(isLeapYear(year)){
				return 29;
			}else return 28;
		}
		else return 30;
	}
	/**
	 * �����������ڼ������
	 */
	public static int countDateToDateDays(int year1,int month1,int day1,int year2,int month2,int day2){
		if(year1 > year2){
			System.out.print("����������year1С��year2��");
		}
		//����year1��year2���������
		int sumYearDays = 0;
		for(int year = year1; year<year2; year++){
			sumYearDays = sumYearDays + countYearDays(year);
		}
		//year1����һ����ʱ���ಹ�������
		int sumMonthDays = 0;
		for(int month = 1 ;month <month1 ;month++){
			sumMonthDays = sumMonthDays + countMonthDays(year1,month);
		}
		int beforMonthDays = sumMonthDays + day1;
		
		//����year2���������
		int sumMonth2Days = 0;
		for(int month =1; month<month2; month++){
			sumMonth2Days = sumMonth2Days + countMonthDays(year2,month);
		}
		int afterMonthDays = sumMonth2Days + day2;
		
		//���ڲ�
		return sumYearDays - beforMonthDays + afterMonthDays;
	}
		
		
	//����
	public static void main(String[] args){
		System.out.print(getWeekDay(2016,6,26));
//		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		printWeekDate(2016,6);
	}
		/**
		 * �����ڵľ���
		 * ��Ҫ֪������һ������ڼ� 1990��1��1��������һ
		 * 7:������ 1������һ 2�����ڶ� 3�������� 4�������� 5�������� 6��������
		 */
	public static int getWeekDay(int year,int month,int day){
		//�����1990��1��1�յ�����
		int dayToDay = countDateToDateDays(1990,1,1,year,month,day);//��Ҫ���ԣ��߽�ֵ
		//1990��1��1��������һ
		int weekDay = 1+dayToDay%7;
		return weekDay;
	}
	
	/**
	 * ��ӡ����
	 */
	public static void printWeekDate(int year,int month){
		//�жϸ����Ƿ�������
		int monthDays = countMonthDays(year,month);
		//�жϸ��µĵ�һ�������ڼ�
		int monthDaysFristDay = getWeekDay(year,month,1);
		//���д�ӡʱ��
		int dayCount = 0;
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		if(monthDaysFristDay != 0){
			for(int a=0 ; a<monthDaysFristDay; a++){
				System.out.print("\t");
				dayCount++;
			}
			//��ӡ���ڿ�ʼ
			for(int a=1; a<=monthDays; a++){
				System.out.print(a+"\t");
				dayCount++;
				//��ӡ7������
				if(dayCount%7 == 0){
					System.out.println();
				}
			}
		}
	}	
}
