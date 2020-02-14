package objectstructures;

public class Partner {
	String name;
	Partner partner;
	public Partner(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner newPartner) {
		Partner oldPartner = this.partner;
		if(newPartner == null) {
			this.partner = null;
			if(oldPartner != null) {
				oldPartner.setPartner(null);
			}
		}else {
			if(oldPartner != null){
				oldPartner.setPartner(null);
			}
			this.partner = newPartner;
			if(!(newPartner.getPartner() == this)){
				newPartner.setPartner(this);
			}
		}
	}
	public String toString() {
		return "Name: " + name + "\nPartner: " + partner.getPartner();
	}
}
