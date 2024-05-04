package com.cetpa.utility;

import java.time.LocalTime;

public class TimeManager 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		String time=lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
		return time;
	}
	public static String getTotalTime(String intime, String outtime) 
	{
		int is=getSeconds(intime);
		int os=getSeconds(outtime);
		int total=is-os;
		int h=total/3600;
		int s=total%3600;
		int m=s/60;
		s=s%60;
		String time=h+"hr "+m+"min "+s+" sec";
		return time;
	}
	private static int getSeconds(String time)
	{
		String[] x=time.split(":");
		int h=Integer.parseInt(x[0]);
		int m=Integer.parseInt(x[1]);
		int s=Integer.parseInt(x[2]);
		int total=h*3600+m*60+s;
		return total;
	}
}
