package com.bridgelabz.CensusAnalyserr;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCode {
//SrNo,State,Name,TIN,State Code
	
	@CsvBindByName(column = "Sr.No")
	private int srNo;
	@CsvBindByName(column = "State Name")
	private String state;
	@CsvBindByName(column = "TIN")
	private int tin;
	@CsvBindByName(column = "State Code")
	private String stateCode;
}
