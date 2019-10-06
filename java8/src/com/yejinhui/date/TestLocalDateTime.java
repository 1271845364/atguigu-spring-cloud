package com.yejinhui.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月13日
 */
public class TestLocalDateTime {
	
	//6.ZonedDate、 ZonedTime、 ZonedDateTime
	@Test
	public void test8() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
		System.out.println(localDateTime);
		
		LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zonedDateTime = localDateTime2.atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(zonedDateTime);
	}
	
	@Test
	public void test7() {
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		availableZoneIds.forEach(System.out::println);
	}
	
	//5.DateTimeFormatter:格式化时间/日期
	@Test
	public void test6() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
		LocalDateTime localDateTime = LocalDateTime.now();
		
		String strDate = localDateTime.format(dateTimeFormatter);
		System.out.println(strDate);
		System.out.println("----------------------------------");
		
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2 = dateTimeFormatter2.format(localDateTime);
		System.out.println(strDate2);
		
		LocalDateTime localDateTime2 = LocalDateTime.parse(strDate2, dateTimeFormatter2);
		System.out.println(localDateTime2);
	}
	
	//4.TemporalAdjuster : 时间校正器
	@Test
	public void test5() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(10);
		System.out.println(localDateTime2);
		
		LocalDateTime localDateTime3 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(localDateTime3);
		
		//因为TemporalAdjusters是接口，所以可以自定义：下一个工作日
		LocalDateTime localDateTime5 = localDateTime.with((l)->{
			LocalDateTime localDateTime4 = (LocalDateTime) l;
			DayOfWeek dayOfWeek = localDateTime4.getDayOfWeek();
			
			if(dayOfWeek.equals(DayOfWeek.SUNDAY)) {
				return localDateTime4.plusDays(3);
			}else if(dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return localDateTime4.plusDays(2);
			}else{
				return localDateTime4.plusDays(1);
			}
		});
		System.out.println(localDateTime5);
	}
	
	//3.
	//Duration:用于计算两个“时间”间隔
	//Period:用于计算两个“日期”间隔
	@Test
	public void test4() {
		LocalDate localDate = LocalDate.of(2015, 1, 1);
		LocalDate localDate2 = LocalDate.now();
		Period period = Period.between(localDate, localDate2);
		System.out.println(period);
		
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
	}
	
	@Test
	public void test3() {
		Instant instant = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		Instant instant2 = Instant.now();
		Duration duration = Duration.between(instant, instant2);
		System.out.println(duration.toNanos());
		System.out.println(duration.toMillis());
		
		System.out.println("-------------------------------------");
		
		LocalTime localTime = LocalTime.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		LocalTime localTime2 = LocalTime.now();
		System.out.println(Duration.between(localTime, localTime2).toMillis());
	}

	//2.Instant:时间戳
	@Test
	public void test2() {
		Instant instant = Instant.now();//默认获取UTC时区 = 格林威治时间
		System.out.println(instant);
		
		OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		
		System.out.println(instant.getNano());
		System.out.println(instant.toEpochMilli());
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
		
		Instant instant2 = Instant.ofEpochSecond(1);
		System.out.println(instant2);
	}
	
	//1.LocalDate LocalTime LocalDateTime
	@Test
	public void test1() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 22,33);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.plusYears(2);
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = ldt.minusMonths(2);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}
}
