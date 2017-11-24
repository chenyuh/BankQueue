package com.cyh.model;

public enum CustomerType {
	COMMON, FAST, VIP;
	
	@Override
	public String toString() {
		switch (this) {
		case COMMON:
			return "ÆÕÍ¨";
		case FAST:
			return "¿ìËÙ";
		case VIP:
			return "VIP";
		}
		return null;
	}
}
