/*
 * Algorithm sorting
 * 
 * Author: Xin He (xh2176@columbia.edu)
 */
public class BubbleSort {
	public static void bubbleSort(int[] nums){
		if(nums==null||nums.length<2) return;
		for(int i=nums.length-2; i>=0; i--){
			for(int j=0; j<=i; j++){
				if(nums[j]>nums[j+1]){
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
	}
	public static void print(int[] array){
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] array1={};
		int[] array2={1};
		int[] array3={1, 2, 3, 4};
		int[] array4={4, 3, 2, 1};
		int[] array5={1, 4, 2, 3};
		int[] array6={1, 1, 1, 1};
		
		bubbleSort(array1);
		bubbleSort(array2);
		bubbleSort(array3);
		bubbleSort(array4);
		bubbleSort(array5);
		bubbleSort(array6);
		
		print(array1);
		print(array2);
		print(array3);
		print(array4);
		print(array5);
		print(array6);
	}
}
