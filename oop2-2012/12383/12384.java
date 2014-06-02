public abstract class BaseObject {

	String personName;

	public abstract int getWorth();

	public String getOwner() {

		return personName;
	}

	public String getDeviceType() {

		return "";
	}

	public String getJeweleryType() {

		return "";
	}

	public String getCompanyName() {

		return "";
	}

	public void stockCrash() {

	}

}
