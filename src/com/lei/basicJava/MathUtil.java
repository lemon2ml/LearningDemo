package com.lei.basicJava;
import java.util.*;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
public class MathUtil {
	public static double sum(final List<? extends Number> list) {
		double sum = 0;
		for(Number number : list) {
			sum += number.doubleValue();
		}
		return sum;
	}
	public static double[] listToArray(final List<? extends Number> list) {
		double[] array = new double[list.size()];
		for(int i=0; i<array.length;i++) {
			array[i] = list.get(i).doubleValue();			
		}
		return array;
	}
	public static double medium(final double[] list) {
		return getStatistics(list).getPercentile(50);
	}
	public static double median(final List<Double> list) {
		return getStatistics(list).getPercentile(50);
	}
	public static DescriptiveStatistics getStatistics(final List<Double> list) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(Double number : list) {
			stats.addValue(number.doubleValue());
		}
		return stats;
	}
	public static DescriptiveStatistics getStatistics(final double[] list) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(int i=0;i<list.length;i++) {
			stats.addValue(list[i]);			
		}
		return stats;		
	}
	public static double mean(final List<Double> list) {
		double sum = 0;
		for(Double number : list) {
			sum += number;
		}
		return sum / list.size();
	}
	
	
	
}
