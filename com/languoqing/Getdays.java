package com.languoqing;

public class Getdays {

	
/**
 * 判断是否是闰年
 * @param year
 * @return
 */
	public static boolean isRunnian(int year){
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)){
			return true;
		}
		return false;
	}

/**
 * 获取月份的天数
 *
 */
   public static int getMonthDays(int year,int month){
	   
	   int months [] = new int []{1,3,5,7,8,10,12};
	   for (int i = 0; i < months.length; i++) {
		if (month == months[i]){
			return 31;
		}
		}
	   if (month == 2 && isRunnian(year) == true){
			return 29;
		}else if (month == 2 && isRunnian(year) == false){
			return 28;
		}else{
			return 30;
	}
   }
   
   /**获取年份的天数
    * 
    * @param year
    * @return
    */
   public static int getYearDays(int year){
	   
	   if(isRunnian(year)){
		   return 366;
	   }
	   return 365;
	   
   }
 
   /**
    *获取该月未满一月补全的天数
    */
   public static int restDays(int year,int month,int day){
	   int rest_Days =0;
	   rest_Days = getMonthDays(year, month) - day;
	   return rest_Days;
   }
   
   
   /**
    * 获取不足一年的天数
    */
   public static int getNotFulldays(int year,int month,int day){
	   
	   int rest_fullDays = 0;
	   for(int m = 1 ; m<month; m++){
		   rest_fullDays = rest_fullDays + getMonthDays(year, m);
	   }
	   rest_fullDays = rest_fullDays + day;
	   return rest_fullDays;
   }
   
   
  /**
   * 获取该年未满一年补全月的天数
   */
   public static int restMonthDays(int year,int month,int day){
	   //获取该年剩余月数
	   int restMonth = 0;
	   restMonth = 12 - month ;
	   
	   //求剩余月数的天数
	   int rest_MonthDays =0;
	   for (int m = 0;m <restMonth;m++,month++){
		   rest_MonthDays = rest_MonthDays + getMonthDays(year, month);
	   }
	   return rest_MonthDays;
	   
   }
   
 
   
   
/**
 * 获取结果,两个时间中间的差值
 */
   
   
   public static int getdays(int year1,int month1,int day1,int year2,int month2,int day2){
	   //year1 补全天数
	   int year1_Days = 0;
	   year1_Days = restMonthDays(year1,month1,day1) + restDays(year1,month1,day1);
	   
	   //year2补全天数
	   int year2_Days = 0;
	   year2_Days = restMonthDays(year2,month1,day1) + restDays(year2,month1,day1);
	   
	   //中间经过年份的天数
	   int CountYear = year1 - year2+1;
	   int CountYearDays = 0;
	   //System.out.println("year2"+year2+",year1"+year1);
	   for (int y = 0; y < CountYear; y++,year2++) {
		   
		   CountYearDays = CountYearDays + getYearDays(year2);
	} 
//	   if (year1 > year2){
	   //实际天数是全部天数减去多补全的天数
	   //判断月份
		   System.out.println("CountYearDays"+CountYearDays);
		   System.out.println("year1_Days"+year1_Days);
		   return CountYearDays-year1_Days-getNotFulldays( year2, month2, day2);
//	   }
//	   else {
		   
		   //System.out.println("CountYearDays"+CountYearDays);
		   //System.out.println("year2_Days"+year2_Days);
		   //return CountYearDays-year2_Days-getNotFulldays( year1, month1, day1);
	  
	   //}
	   
	   
   }
   
   
   
   
   
   
   public static void main(String [] args){
	   
	   System.out.println("中间差"+getdays(2016,6,5,1805,2,1));
	   System.out.println("小日期补全月数天"+getNotFulldays( 2015,12,20));
	   System.out.println("大日期补全月数天"+restMonthDays(2016,1,5));
	   
	   System.out.println("月数不足天数"+restDays(2019,1,5));
	   //System.out.println(getdays(2012,1,3,2011,12,29));
	   //System.out.println(getdays(2012,1,3,2011,12,29));
   }
   
   
}