package com.yaoming.mxt.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaoming.mxt.entity.Income;

import com.yaoming.mxt.util.MXTUtil;

@Controller
public class GreetingController {

	@RequestMapping("/getReport")
	public String greeting(@RequestParam(value = "type", required = false, defaultValue = "3") Integer type,
			Model model) {
		
		Income report = getReport(type);
		
		model.addAttribute("date_begin", report.getDate_begin());
		model.addAttribute("outcome_sum", report.getOutcome_sum());
		model.addAttribute("outcome_map", report.getOutcome_map());
		model.addAttribute("income_sum", report.getIncome_sum());
		model.addAttribute("income_map", report.getIncome_map());
		model.addAttribute("recharge_sum", report.getRecharge_sum());
		model.addAttribute("recharge_map", report.getRecharge_map());
		model.addAttribute("tp_sum", report.getTp_sum());
		model.addAttribute("other_sum", report.getOther_sum());
		model.addAttribute("payout_sum", report.getPayout_sum());
		model.addAttribute("remaining_sum", report.getRemaining_sum());
		model.addAttribute("totalincome", report.getTotalincome());
		model.addAttribute("clock_item_detail", report.getClock_item_detail());
		model.addAttribute("clock_mode_detail", report.getClock_mode_detail());
		model.addAttribute("goods_detail", report.getGoods_detail());
		model.addAttribute("visitor_detail", report.getVisitor_detail());

		return "greeting";
	}

	public Income getReport(Integer type) {

		// type = 3 当月
		// type = 2 昨日
		// type = 1 今日

		try {

			// 创建连接
			Connection con = DriverManager.getConnection(MXTUtil.getDBConnectionUrl());

			// 创建存储过程的对象
			CallableStatement c = con.prepareCall("{call p_butler_sn_income2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// 给存储过程的输入参数设置值
			c.setString(1, "老板");
			c.setString(2, "jxdisking");
			c.setInt(3, type);

			// 注册存储过程的输出参数

			// 统计起始日期
			c.registerOutParameter(4, java.sql.Types.VARCHAR);
			// 非收入合计
			c.registerOutParameter(5, java.sql.Types.DECIMAL);
			// 非收入明细
			c.registerOutParameter(6, java.sql.Types.VARCHAR);
			// 收入合计
			c.registerOutParameter(7, java.sql.Types.DECIMAL);
			// 收入明细
			c.registerOutParameter(8, java.sql.Types.VARCHAR);
			// 充值合计
			c.registerOutParameter(9, java.sql.Types.DECIMAL);
			// 充值明细
			c.registerOutParameter(10, java.sql.Types.VARCHAR);

			// 套票总和
			c.registerOutParameter(11, java.sql.Types.DECIMAL);
			// 其他收入总和
			c.registerOutParameter(12, java.sql.Types.DECIMAL);
			// 总支出
			c.registerOutParameter(13, java.sql.Types.DECIMAL);
			// 会员卡消费总余额
			c.registerOutParameter(14, java.sql.Types.DECIMAL);
			// 总收入
			c.registerOutParameter(15, java.sql.Types.DECIMAL);

			// 上钟项目详情
			c.registerOutParameter(16, java.sql.Types.VARCHAR);
			// 上钟方式详情
			c.registerOutParameter(17, java.sql.Types.VARCHAR);
			// 商品销售情况
			c.registerOutParameter(18, java.sql.Types.VARCHAR);
			// 客流量情况
			c.registerOutParameter(19, java.sql.Types.VARCHAR);

			// 执行存储过程
			c.execute();

			// 保存存储过程返回的各项输出参数
			String date_begin = c.getString(4);
			Double outcome_sum = c.getBigDecimal(5).doubleValue();
			String outcome_detail = c.getString(6);
			Double income_sum = c.getBigDecimal(7).doubleValue();
			String income_detail = c.getString(8);
			Double recharge_sum = c.getBigDecimal(9).doubleValue();
			String recharge_detail = c.getString(10);

			Double tp_sum = c.getBigDecimal(11).doubleValue();
			Double other_sum = c.getBigDecimal(12).doubleValue();
			Double payout_sum = c.getBigDecimal(13).doubleValue();
			Double remaining_sum = c.getBigDecimal(14).doubleValue();
			Double totalincome = c.getBigDecimal(15).doubleValue();

			String clock_item_detail = c.getString(16);
			String clock_mode_detail = c.getString(17);
			String goods_detail = c.getString(18);
			String visitor_detail = c.getString(19);

			// 涉及详情的字段进行转换
			Map<String, Double> outcome_map = MXTUtil.convert2DetailStringToMap(outcome_detail);
			Map<String, Double> income_map = MXTUtil.convert2DetailStringToMap(income_detail);
			Map<String, Double> recharge_map = MXTUtil.convert2DetailStringToMap(recharge_detail);

			Map<String, Map<Double, Double>> clock_item_map = MXTUtil.convert3DetailStringToMap(clock_item_detail);
			Map<String, Map<Double, Double>> clock_mode_map = MXTUtil.convert3DetailStringToMap(clock_mode_detail);
			Map<String, Map<Double, Double>> goods_map = MXTUtil.convert3DetailStringToMap(goods_detail);
			Map<String, Double> visitor_map = MXTUtil.convert2DetailStringToMap(visitor_detail);

			// 得到存储过程的输出参数值
			Income income = new Income(date_begin, outcome_sum, outcome_map, income_sum, income_map, recharge_sum,
					recharge_map, tp_sum, other_sum, payout_sum, remaining_sum, totalincome, clock_item_map,
					clock_mode_map, goods_map, visitor_map);

			// 关闭连接
			con.close();

			return income;

		} catch (Exception ex) {

			System.out.println(ex.toString());
			
			return new Income();
		}

	}

}
