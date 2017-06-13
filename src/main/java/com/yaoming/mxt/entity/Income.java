package com.yaoming.mxt.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Income extends U2OEntity {

	@JsonProperty(value = "起始日期")
	private String date_begin;
	@JsonProperty(value = "非收入总额")
	private Double outcome_sum;
	@JsonProperty(value = "非收入明细")
	private Map<String, Double> outcome_map;
	@JsonProperty(value = "收入总额")
	private Double income_sum;
	@JsonProperty(value = "收入明细")
	private Map<String, Double> income_map;
	@JsonProperty(value = "充值合计")
	private Double recharge_sum;
	@JsonProperty(value = "充值明细")
	private Map<String, Double> recharge_map;

	@JsonProperty(value = "套票总和")
	private Double tp_sum;
	@JsonProperty(value = "其他收入总和")
	private Double other_sum;
	@JsonProperty(value = "总支出")
	private Double payout_sum;
	@JsonProperty(value = "会员卡消费总余额")
	private Double remaining_sum;
	@JsonProperty(value = "总收入")
	private Double totalincome;

	@JsonProperty(value = "上钟项目详情(首钟钟数:加钟钟数)")
	private Map<String, Map<Double, Double>> clock_item_detail;
	@JsonProperty(value = "上钟方式详情(首钟钟数:加钟钟数)")
	private Map<String, Map<Double, Double>> clock_mode_detail;
	@JsonProperty(value = "商品销售情况商品项目(数量:金额)")
	private Map<String, Map<Double, Double>> goods_detail;
	@JsonProperty(value = "客流量情况(客人类型:数量)")
	private Map<String, Double> visitor_detail;

	public Income() {
		super();
	};

	public Income(String date_begin, Double outcome_sum, Map<String, Double> outcome_map, Double income_sum,
			Map<String, Double> income_map, Double recharge_sum, Map<String, Double> recharge_map, Double tp_sum,
			Double other_sum, Double payout_sum, Double remaining_sum, Double totalincome,
			Map<String, Map<Double, Double>> clock_item_detail, Map<String, Map<Double, Double>> clock_mode_detail,
			Map<String, Map<Double, Double>> goods_detail, Map<String, Double> visitor_detail) {
		super();
		this.date_begin = date_begin;
		this.outcome_sum = outcome_sum;
		this.outcome_map = outcome_map;
		this.income_sum = income_sum;
		this.income_map = income_map;
		this.recharge_sum = recharge_sum;
		this.recharge_map = recharge_map;
		this.tp_sum = tp_sum;
		this.other_sum = other_sum;
		this.payout_sum = payout_sum;
		this.remaining_sum = remaining_sum;
		this.totalincome = totalincome;
		this.clock_item_detail = clock_item_detail;
		this.clock_mode_detail = clock_mode_detail;
		this.goods_detail = goods_detail;
		this.visitor_detail = visitor_detail;
	}

	public String getDate_begin() {
		return date_begin;
	}

	public void setDate_begin(String date_begin) {
		this.date_begin = date_begin;
	}

	public Double getOutcome_sum() {
		return outcome_sum;
	}

	public void setOutcome_sum(Double outcome_sum) {
		this.outcome_sum = outcome_sum;
	}

	public Map<String, Double> getOutcome_map() {
		return outcome_map;
	}

	public void setOutcome_map(Map<String, Double> outcome_map) {
		this.outcome_map = outcome_map;
	}

	public Double getIncome_sum() {
		return income_sum;
	}

	public void setIncome_sum(Double income_sum) {
		this.income_sum = income_sum;
	}

	public Map<String, Double> getIncome_map() {
		return income_map;
	}

	public void setIncome_map(Map<String, Double> income_map) {
		this.income_map = income_map;
	}

	public Double getRecharge_sum() {
		return recharge_sum;
	}

	public void setRecharge_sum(Double recharge_sum) {
		this.recharge_sum = recharge_sum;
	}

	public Map<String, Double> getRecharge_map() {
		return recharge_map;
	}

	public void setRecharge_map(Map<String, Double> recharge_map) {
		this.recharge_map = recharge_map;
	}

	public Double getTp_sum() {
		return tp_sum;
	}

	public void setTp_sum(Double tp_sum) {
		this.tp_sum = tp_sum;
	}

	public Double getOther_sum() {
		return other_sum;
	}

	public void setOther_sum(Double other_sum) {
		this.other_sum = other_sum;
	}

	public Double getPayout_sum() {
		return payout_sum;
	}

	public void setPayout_sum(Double payout_sum) {
		this.payout_sum = payout_sum;
	}

	public Double getRemaining_sum() {
		return remaining_sum;
	}

	public void setRemaining_sum(Double remaining_sum) {
		this.remaining_sum = remaining_sum;
	}

	public Double getTotalincome() {
		return totalincome;
	}

	public void setTotalincome(Double totalincome) {
		this.totalincome = totalincome;
	}

	public Map<String, Map<Double, Double>> getClock_item_detail() {
		return clock_item_detail;
	}

	public void setClock_item_detail(Map<String, Map<Double, Double>> clock_item_detail) {
		this.clock_item_detail = clock_item_detail;
	}

	public Map<String, Map<Double, Double>> getClock_mode_detail() {
		return clock_mode_detail;
	}

	public void setClock_mode_detail(Map<String, Map<Double, Double>> clock_mode_detail) {
		this.clock_mode_detail = clock_mode_detail;
	}

	public Map<String, Map<Double, Double>> getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(Map<String, Map<Double, Double>> goods_detail) {
		this.goods_detail = goods_detail;
	}

	public Map<String, Double> getVisitor_detail() {
		return visitor_detail;
	}

	public void setVisitor_detail(Map<String, Double> visitor_detail) {
		this.visitor_detail = visitor_detail;
	}

}