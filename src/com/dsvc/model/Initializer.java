package com.dsvc.model;

public class Initializer {
	private int dk0;
	private char dk1;
	private boolean dk2;
	private short dk3;
	private long dk4;
	private double dk5;
	private float dk6;
	private byte dk7;
	
	
	@Override
	public String toString() {
		return "Initializer [int默认值=" + dk0 + ", char默认值=" + dk1 + ", boolean默认值=" + dk2 + ", short默认值=" + dk3 + ", long默认值=" + dk4 + ", double默认值="
				+ dk5 + ", float默认值=" + dk6 + ", byte默认值=" + dk7 + "]";
	}

	public Initializer(){
		
	}
	
	public int getDk0() {
		return dk0;
	}
	public void setDk0(int dk0) {
		this.dk0 = dk0;
	}
	public char getDk1() {
		return dk1;
	}
	public void setDk1(char dk1) {
		this.dk1 = dk1;
	}
	public boolean isDk2() {
		return dk2;
	}
	public void setDk2(boolean dk2) {
		this.dk2 = dk2;
	}
	public short getDk3() {
		return dk3;
	}
	public void setDk3(short dk3) {
		this.dk3 = dk3;
	}
	public long getDk4() {
		return dk4;
	}
	public void setDk4(long dk4) {
		this.dk4 = dk4;
	}
	public double getDk5() {
		return dk5;
	}
	public void setDk5(double dk5) {
		this.dk5 = dk5;
	}
	public float getDk6() {
		return dk6;
	}
	public void setDk6(float dk6) {
		this.dk6 = dk6;
	}
	public byte getDk7() {
		return dk7;
	}
	public void setDk7(byte dk7) {
		this.dk7 = dk7;
	}
	
	
}
