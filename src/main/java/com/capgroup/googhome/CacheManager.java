package com.capgroup.googhome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgroup.googhome.virtualwholesaler.FundAllocation;
import com.capgroup.googhome.virtualwholesaler.News;

public class CacheManager {

	public static Map<String, List<FundAllocation>> portfolioCache = new HashMap<String, List<FundAllocation>>();
	

	public static Map<String, List<News>> newsCache = new HashMap<String, List<News>>();
	
}
