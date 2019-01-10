package com.ust.claimfaker.core.util;


public class X12FileProcessing {

	public static String[] parseSegment (String segment) {

		if(segment.endsWith("~")) segment = segment.substring(0, segment.length()-1);
		
		String[] segmentArray = segment.split("\\*",-1);
		
		return segmentArray;
	}
	
	public static String rebuildSegment(String[] segmentArray) {
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
		
		return segment;
		
	}

}
