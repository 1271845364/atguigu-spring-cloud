package com.yejinhui.java8;

public class Man {

	private Godness godness;

	public Godness getGodness() {
		return godness;
	}

	public void setGodness(Godness godness) {
		this.godness = godness;
	}

	public Man(Godness godness) {
		super();
		this.godness = godness;
	}

	public Man() {
		super();
	}

	@Override
	public String toString() {
		return "Man [godness=" + godness + "]";
	}

}
