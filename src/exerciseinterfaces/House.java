package exerciseinterfaces;

import java.text.NumberFormat;

public class House implements Insurable {
	
	private double marketValue;
	private int constructedArea;
	
	public House() {
	}
	
	public House(double marketValue, int constructedArea) {
		this.setMarketValue(marketValue);
		this.setConstructedArea(constructedArea);
	}
	
	@Override
	public double calculatePolicyValue() {
		double policyValue = this.marketValue * 0.003;
		policyValue = policyValue + this.constructedArea * 0.5;
		return policyValue;
	}
	
	@Override
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nConstructed area: " + this.constructedArea);
		builder.append("\nMarket value: "
				+ NumberFormat.getCurrencyInstance().format(this.marketValue));
		return builder.toString();
	}
	
	public double getMarketValue() {
		return marketValue;
	}
	
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	
	public int getConstructedArea() {
		return constructedArea;
	}
	
	public void setConstructedArea(int constructedArea) {
		this.constructedArea = constructedArea;
	}
	
}
