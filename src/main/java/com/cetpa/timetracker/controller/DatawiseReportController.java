package com.cetpa.timetracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.TimeInfo;
import com.cetpa.timetracker.service.ReportService;
@Controller
@RequestMapping("timetracker/report/datewise")
public class DatawiseReportController 
{
	@Autowired private ReportService reportService;
	
	@RequestMapping("")
	public String getDataChoiceView(Model model)
	{
		model.addAttribute("cdate",LocalDate.now());
		return "timetracker/reports/date/choose-date";
	}
	@RequestMapping("current")
	public String getCurrentDateReport(Model model)
	{
		List<TimeInfo> list=reportService.getCurrentDateList();
		model.addAttribute("clist",list);
		return "timetracker/reports/date/current-date";
	}
	@RequestMapping("any")
	public String getAnyDateReport(Model model,String date)
	{
		List<TimeInfo> list=reportService.getAnyDateList(date);
		model.addAttribute("clist",list);
		model.addAttribute("date",date);
		return "timetracker/reports/date/any-date";
	}
	@RequestMapping("date-between")
	public String getDateBetweenReport(Model model,String date1,String date2)
	{
		List<TimeInfo> list=reportService.getDateBetweenList(date1,date2);
		model.addAttribute("clist",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "timetracker/reports/date/date-between";
	}
}
