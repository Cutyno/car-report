package me.kuehle.carreport.util;

import java.util.Vector;

import android.content.Context;
import android.util.TypedValue;

public class Calculator {
	private Context context;

	public Calculator(Context context) {
		this.context = context;
	}

	public int dpToPx(float dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				context.getResources().getDisplayMetrics());
	}

	public int spToPx(float sp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
				context.getResources().getDisplayMetrics());
	}

	public float pxToSp(int px) {
		float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
		return px / scaledDensity;
	}

	@SuppressWarnings("unchecked")
	public static <E extends Number> E avg(Vector<E> numbers) {
		if (numbers.get(0) instanceof Double) {
			return (E) (Double) ((Double) sum(numbers) / numbers.size());
		} else if (numbers.get(0) instanceof Float) {
			return (E) (Float) ((Float) sum(numbers) / numbers.size());
		} else if (numbers.get(0) instanceof Integer) {
			return (E) (Integer) ((Integer) sum(numbers) / numbers.size());
		} else { // if (numbers.get(0) instanceof Long) {
			return (E) (Long) ((Long) sum(numbers) / numbers.size());
		}
	}

	@SuppressWarnings("unchecked")
	public static <E extends Number> E max(Vector<E> numbers) {
		if (numbers.get(0) instanceof Double) {
			Double max = Double.MIN_VALUE;
			for (E num : numbers) {
				max = Math.max(max, (Double) num);
			}
			return (E) max;
		} else if (numbers.get(0) instanceof Float) {
			Float max = Float.MIN_VALUE;
			for (E num : numbers) {
				max = Math.max(max, (Float) num);
			}
			return (E) max;
		} else if (numbers.get(0) instanceof Integer) {
			Integer max = Integer.MIN_VALUE;
			for (E num : numbers) {
				max = Math.max(max, (Integer) num);
			}
			return (E) max;
		} else { // if (numbers.get(0) instanceof Long) {
			Long max = Long.MIN_VALUE;
			for (E num : numbers) {
				max = Math.max(max, (Long) num);
			}
			return (E) max;
		}
	}

	@SuppressWarnings("unchecked")
	public static <E extends Number> E min(Vector<E> numbers) {
		if (numbers.get(0) instanceof Double) {
			Double min = Double.MAX_VALUE;
			for (E num : numbers) {
				min = Math.min(min, (Double) num);
			}
			return (E) min;
		} else if (numbers.get(0) instanceof Float) {
			Float min = Float.MAX_VALUE;
			for (E num : numbers) {
				min = Math.min(min, (Float) num);
			}
			return (E) min;
		} else if (numbers.get(0) instanceof Integer) {
			Integer min = Integer.MAX_VALUE;
			for (E num : numbers) {
				min = Math.min(min, (Integer) num);
			}
			return (E) min;
		} else { // if (numbers.get(0) instanceof Long) {
			Long min = Long.MAX_VALUE;
			for (E num : numbers) {
				min = Math.min(min, (Long) num);
			}
			return (E) min;
		}
	}

	@SuppressWarnings("unchecked")
	public static <E extends Number> E sum(Vector<E> numbers) {
		if (numbers.get(0) instanceof Double) {
			Double sum = Double.valueOf(0);
			for (E num : numbers) {
				sum += (Double) num;
			}
			return (E) sum;
		} else if (numbers.get(0) instanceof Float) {
			Float sum = Float.valueOf(0);
			for (E num : numbers) {
				sum += (Float) num;
			}
			return (E) sum;
		} else if (numbers.get(0) instanceof Integer) {
			Integer sum = Integer.valueOf(0);
			for (E num : numbers) {
				sum += (Integer) num;
			}
			return (E) sum;
		} else { // if (numbers.get(0) instanceof Long) {
			Long sum = Long.valueOf(0);
			for (E num : numbers) {
				sum += (Long) num;
			}
			return (E) sum;
		}
	}
}