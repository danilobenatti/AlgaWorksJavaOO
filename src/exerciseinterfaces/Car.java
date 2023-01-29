package exerciseinterfaces;

public class Car implements Insurable {
	
	private double marketValue;
	private int yearManufacture;
	
	public Car() {
	}
	
	public Car(double marketValue, int yearManufacture) {
		this.marketValue = marketValue;
		this.yearManufacture = yearManufacture;
	}
	
	@Override
	public double calculatePolicyValue() {
		double policyValue = this.marketValue * 0.04;
		if (yearManufacture < 2000) {
			policyValue = policyValue * 0.90;
		}
		return policyValue;
	}
	
	@Override
	public String getDescription() {
		return String.format("%nYear of manufacture: %d", this.yearManufacture);
	}
	
	public double getMarketValue() {
		return marketValue;
	}
	
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	
	public int getYearManufacture() {
		return yearManufacture;
	}
	
	public void setYearManufacture(int yearManufacture) {
		this.yearManufacture = yearManufacture;
	}
}
