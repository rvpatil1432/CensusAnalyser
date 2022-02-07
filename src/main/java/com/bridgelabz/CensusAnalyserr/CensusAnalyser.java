package com.bridgelabz.CensusAnalyserr;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	

	public int loadIndiaCensusData(String csvPath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvPath));
//			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
//			csvToBeanBuilder.withType(IndiaCensusCSV.class);
//			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
//			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			Iterator<IndiaCensusCSV> censusCSVIterator = getCsvIterator(reader,IndiaCensusCSV.class);
//			int numOfIntries = 0;
//			 while (censusCSVIterator.hasNext()) {
//				 numOfIntries++;
//	                IndiaCensusCSV censusData = censusCSVIterator.next();
//	            }
//	            return numOfIntries;
			return getCount(censusCSVIterator);
		} catch (Exception e) {
			 throw new CensusAnalyserException(e.getMessage(),
	                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	public int loadIndiaStateCode(String csvPath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvPath));
//			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
//			csvToBeanBuilder.withType(IndiaCensusCSV.class);
//			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
//			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			Iterator<IndiaStateCode> censusCSVIterator = getCsvIterator(reader,IndiaStateCode.class);
//			int numOfIntries = 0;
//			 while (censusCSVIterator.hasNext()) {
//				 numOfIntries++;
//	                IndiaCensusCSV censusData = censusCSVIterator.next();
//	            }
//	            return numOfIntries;
			return getCount(censusCSVIterator);
		} catch (Exception e) {
			 throw new CensusAnalyserException(e.getMessage(),
	                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	private<E> Iterator getCsvIterator(Reader reader, Class<E> csvClass) {
		CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
		csvToBeanBuilder.withType(IndiaCensusCSV.class);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
		return csvToBean.iterator();
	}

	private<E> int getCount(Iterator<E> censusCSVIterator) {
		int numOfIntries = 0;
		Iterable<E> csvIterator = () -> censusCSVIterator;
		numOfIntries = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
//		 while (censusCSVIterator.hasNext()) {
//			 numOfIntries++;
//                IndiaCensusCSV censusData = censusCSVIterator.next();
//            }
		return numOfIntries;
	}

}
