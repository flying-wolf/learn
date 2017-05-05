package com.flyingwolf.javacode.arrays.arraycopy;

import java.util.Arrays;

/** 
 * @ClassName: ArrayCopyTest 
 * @Description: 测试数组copy方式的性能
 * @author: Ma.Chao
 * @date: 2017年5月5日 上午10:35:02  
 */
public class ArrayCopyTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int length = 100000;
		int[] a = new int[length];
		int[] b = new int[length];
		int[] c = new int[length];
		int[] d = new int[length];
		int[] e = new int[length];
		int[] f = null;
		for (int i = 0; i < length; i++) {
			a[i] = i;
			c[i] = i;
			e[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			//第一种方式,循环
			long startA = System.nanoTime();
			for (int j = 0; j < a.length; j++) {
				b[j] = a[j];
			}
			long endA = System.nanoTime();
			System.out.println("for循环copy       100000条用时:"+(endA - startA));
			
			//第二种方式,system.arraycopy
			long startB = System.nanoTime();
			System.arraycopy(c, 0, d, 0, length);
			long endB = System.nanoTime();
			System.out.println("system.arraycopy 100000条用时:"+(endB - startB));
			
			//第三种方式,arrays.copy
			long startC = System.nanoTime();
			f = Arrays.copyOf(e, length);
			long endC = System.nanoTime();
			System.out.println("arrays.copyOf    100000条用时:"+(endC - startC));
			System.out.println();
			
		}
	}

}
