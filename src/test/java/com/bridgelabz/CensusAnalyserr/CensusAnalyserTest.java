package com.bridgelabz.CensusAnalyserr;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.pdf";
    private static final String INDIA_CENSUS_FILE_PATH_WRONG = "./src/test/resources/IndiaStateCensusData";
    private static final String INDIA_CENSUS_FILE_DATA_Del = "./src/main/resource/IndiaCensusDataForDelimete.csv";
    private static final String CSV_HEADER_INCORRECT = "./src/main/resource/CensusFileIncorrectHeader.csv";
    
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }


    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData( WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void whenGivenCsvFileCorrectButTypeIncorrect_ShouldThrowCustomExce() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData( INDIA_CENSUS_FILE_PATH_WRONG);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void whenGivenCSVFileInCorrectDelimeter_ShouldThrowCustomeException() {
        int numOfRecords = 0;
        try
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            numOfRecords=censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_FILE_DATA_Del);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e)
        {
            System.out.println(numOfRecords);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }

    @Test
    public void WhenGivenCSVFileHeaderIncorrect_ShouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CSV_HEADER_INCORRECT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA, e.type);
       
 }
    }

}
