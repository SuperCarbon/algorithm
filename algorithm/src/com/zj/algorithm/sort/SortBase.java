package com.zj.algorithm.sort;

/**
 * @ClassName: SortBase
 * @Description: 排序的基本方法
 * @author zJun
 * @date Jun 27, 2013 10:20:34 PM
 * 
 */
public class SortBase {
	/**
	 * @Title: isSorted
	 * @Description: 确定数组是否是有序的
	 * @param: array 待检验的数组
	 * @return: 有序则返回true，否则返回false
	 * @throws
	 */
	public boolean isSorted(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			if (less(array[i], array[i - 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @Title: less
	 * @Description: 比较a和b两个元素的大小
	 * @return: 如果a<b则返回true，否则返回false
	 * @throws
	 */
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void sort(Comparable[] array) {

	}

	/**
	 * @Title: show
	 * @Description: 打印输出数组
	 * @throws
	 */
	public static void show(Comparable[] array) {
		System.out.print("The array is:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * @Title: exchange
	 * @Description: 交换数组中两个元素的位置
	 * @throws
	 */
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
