package com.sebas.taller.model.person;

/**
 * Auxiliary class for the special queries performed by the daos.
 *
 */
public class StateprovinceAndAddresses {
    private Stateprovince sp;
    private long addresses;
	
	public Stateprovince getSp() {
		return sp;
	}
	public void setSp(Stateprovince sp) {
		this.sp = sp;
	}
	public long getAddresses() {
		return addresses;
	}
	public void setAddresses(long addresses) {
		this.addresses = addresses;
	}

}
