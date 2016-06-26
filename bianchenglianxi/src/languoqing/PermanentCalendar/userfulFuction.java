package com.languoqing.PermanentCalendar;


public class userfulFuction {
	/**
	 * 判断是否是闰年
	 * @author Jor
	 * @since 2016-06-25
	 * @param year
	 */
	public static boolean isLeapYear(int year){
		//闰年判断
		if(year%400 == 0 || (year%4 == 0 && year%100 !=0)){
			return true;
		}
		return false;
	}

	/**
	 *计算年的天数
	 */
	public static int countYearDays(int year){
		//闰年判断
		if(isLeapYear(year)){
			return 366;
		}
		return 365;
	}
	
	/**
	 * 计算闰月天数
	 * @param month
	 * 
	 */
	public static int countMonthDays(int year,int month) {
		//闰月{1、3、5、7、8、10、12}
		int[] arrayMonth = new int[]{1,3,5,7,8,10,12};
		for(int m=0; m<arrayMonth.length; m++){
			if(month == arrayMonth[m]){
				return 31;
			}
		}
		//闰年2月是29天
		if(month == 2){
			if(isLeapYear(year)){
				return 29;
			}else return 28;
		}
		else return 30;
	}
	/**
	 * 计算两个日期间的天数
	 */
	public static int countDateToDateDays(int year1,int month1,int day1,int year2,int month2,int day2){
		if(year1 > year2){
			System.out.print("请输入的年份year1小于year2！");
		}
		//计算year1到year2整年的天数
		int sumYearDays = 0;
		for(int year = year1; year<year2; year++){
			sumYearDays = sumYearDays + countYearDays(year);
		}
		//year1不足一整年时，多补充的天数
		int sumMonthDays = 0;
		for(int month = 1 ;month <month1 ;month++){
			sumMonthDays = sumMonthDays + countMonthDays(year1,month);
		}
		int beforMonthDays = sumMonthDays + day1;
		
		//超过year2整年的天数
		int sumMonth2Days = 0;
		for(int month =1; month<month2; month++){
			sumMonth2Days = sumMonth2Days + countMonthDays(year2,month);
		}
		int afterMonthDays = sumMonth2Days + day2;
		
		//日期差
		return sumYearDays - beforMonthDays + afterMonthDays;
	}
		
		
	//测试
	public static void main(String[] args){
		System.out.print(getWeekDay(2016,6,26));
//		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		printWeekDate(2016,6);
	}
		/**
		 * 求日期的具体
		 * 需要知道具体一天的星期几 1990年1月1日是星期一
		 * 7:星期日 1：星期一 2：星期二 3：星期三 4：星期四 5：星期五 6：星期六
		 */
	public static int getWeekDay(int year,int month,int day){
		//求距离1990年1月1日的天数
		int dayToDay = countDateToDateDays(1990,1,1,year,month,day);//需要调试，边界值
		//1990年1月1日是星期一
		int weekDay = 1+dayToDay%7;
		return weekDay;
	}
	
	/**
	 * 打印日期
	 */
	public static void printWeekDate(int year,int month){
		//判断该月是否是闰月
		int monthDays = countMonthDays(year,month);
		//判断该月的第一天是星期几
		int monthDaysFristDay = getWeekDay(year,month,1);
		//顶行打印时间
		int dayCount = 0;
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		if(monthDaysFristDay != 0){
			for(int a=0 ; a<monthDaysFristDay; a++){
				System.out.print("\t");
				dayCount++;
			}
			//打印日期开始
			for(int a=1; a<=monthDays; a++){
				System.out.print(a+"\t");
				dayCount++;
				//打印7个后换行
				if(dayCount%7 == 0){
					System.out.println();
				}
			}
		}
	}	
}
