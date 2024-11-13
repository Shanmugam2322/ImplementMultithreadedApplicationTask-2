package com.example.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.opencsv.CSVReader;

public class CsvDataProcessingWithMultitherading {
	
	 private static final int THREAD_POOL_SIZE = 10;

	    public static void main(String[] args) throws InterruptedException, ExecutionException {
	        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

	        // Read CSV file
	        List<String[]> data = readCSV("data.csv");

	        List<Callable<Void>> tasks = new ArrayList<>();

	        for (String[] row : data) {
	            tasks.add(() -> {
	                // Process each row
	                processRow(row);
	                return null;
	            });
	        }

	        // Execute tasks in parallel
	        executorService.invokeAll(tasks);
	        executorService.shutdown();
	    }

	    private static List<String[]> readCSV(String fileName) {
	        List<String[]> data = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                data.add(line.split(","));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

	    private static void processRow(String[] row) {
	        
	        System.out.println(Arrays.toString(row));
	    }
	    
	    
 }
	    
	    
	   