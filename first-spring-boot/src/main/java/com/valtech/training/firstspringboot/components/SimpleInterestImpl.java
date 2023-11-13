package com.valtech.training.firstspringboot.components;

public class SimpleInterestImpl implements SimpleInterest{
	
	private Airthmetic airthmetic;
	
	
	
	public SimpleInterestImpl() {}

	public SimpleInterestImpl(Airthmetic airthmetic) {
		this.airthmetic=airthmetic;
	}

	public void setAirthmetic(Airthmetic airthmetic) {
		this.airthmetic = airthmetic;
	}

	@Override
	public double computeSimpleInterest(int principal, int roi, int duration) {
		int result=airthmetic.mul(principal, roi);
		result = airthmetic.mul(result, duration);
		return airthmetic.div(result, 100);
	}

	public static void main(String[] args) {
		Airthmetic airthmetic = new AirthmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(airthmetic);
		System.out.println(si.computeSimpleInterest(200, 3, 4));
	}
	
}
