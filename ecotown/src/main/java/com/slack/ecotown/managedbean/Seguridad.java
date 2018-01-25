/**
 * 
 */
package com.slack.ecotown.managedbean;

import java.io.Serializable;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
public class Seguridad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5994929999374958023L;

	private String passwordOld;
	private String passwordNewOne;
	private String passwordNewTwo;

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getPasswordNewOne() {
		return passwordNewOne;
	}

	public void setPasswordNewOne(String passwordNewOne) {
		this.passwordNewOne = passwordNewOne;
	}

	public String getPasswordNewTwo() {
		return passwordNewTwo;
	}

	public void setPasswordNewTwo(String passwordNewTwo) {
		this.passwordNewTwo = passwordNewTwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passwordNewOne == null) ? 0 : passwordNewOne.hashCode());
		result = prime * result + ((passwordNewTwo == null) ? 0 : passwordNewTwo.hashCode());
		result = prime * result + ((passwordOld == null) ? 0 : passwordOld.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguridad other = (Seguridad) obj;
		if (passwordNewOne == null) {
			if (other.passwordNewOne != null)
				return false;
		} else if (!passwordNewOne.equals(other.passwordNewOne))
			return false;
		if (passwordNewTwo == null) {
			if (other.passwordNewTwo != null)
				return false;
		} else if (!passwordNewTwo.equals(other.passwordNewTwo))
			return false;
		if (passwordOld == null) {
			if (other.passwordOld != null)
				return false;
		} else if (!passwordOld.equals(other.passwordOld))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seguridad [passwordOld=" + passwordOld + ", passwordNewOne=" + passwordNewOne + ", passwordNewTwo=" + passwordNewTwo + "]";
	}

}
