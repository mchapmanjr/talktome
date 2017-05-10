package com.capgroup.googhome.virtualwholesaler;

public class FundAllocation {
	public String fundName;
	public String percentage;
	
	public String toString() {
		return String.format("FundAllocation: [%s]=[%s]", fundName, percentage);
	}
}
