public class Device extends BaseObject {
	private String deviceType;
	private double purchasePrice, condition;

	Device(String personName, String deviceType, double condition,
			double purchasePrice) {
		this.deviceType = deviceType;
		this.condition = condition;
		this.purchasePrice = purchasePrice;
		this.personName = personName;

	}

	public int getWorth() {

		int worth = 0;

		if (condition > 10) {
			condition = 10;
		}

		double calcWorth = (condition / 10);
		calcWorth = calcWorth * purchasePrice;
		worth = (int) calcWorth;
		return worth;

	}

	public String getOwner() {

		return personName;
	}

	public String getDeviceType() {

		return deviceType;
	}

}
