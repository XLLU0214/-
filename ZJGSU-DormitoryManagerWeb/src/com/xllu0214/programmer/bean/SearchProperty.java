package com.xllu0214.programmer.bean;

/**
 * 封装查询字段
 * @author XLLU
 *
 */
public class SearchProperty {
	//查询属性
	private String key;//查询的字段名称
	private Object value;//查询的字段值
	private Operator operator;//操作符
	
	public SearchProperty(String key,Object value,Operator operator) {
		this.key = key;
		this.value = value;
		this.operator = operator;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}