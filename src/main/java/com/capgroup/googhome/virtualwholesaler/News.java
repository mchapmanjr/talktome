package com.capgroup.googhome.virtualwholesaler;

import java.util.Date;

public class News {
	public String teaserHeader = null;
	public Date teaserDate = null;
	public String teaserDateString = null;
	
	public String toString() {
		return String.format("News: [%s],[%s],[%s]", teaserHeader, teaserDateString, teaserDate);
	}
}
