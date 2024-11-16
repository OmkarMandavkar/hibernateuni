package com.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {

	@Id
	private int eid;
	private int cc;

	@Override
	public String toString() {
		return "Engine [eid=" + eid + ", cc=" + cc + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
}