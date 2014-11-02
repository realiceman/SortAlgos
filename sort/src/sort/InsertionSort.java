package sort;

public class InsertionSort {

	public static void main(String[] args) {
		int []numbers ={10,5,3,7,2};
		
		InsertionSort(numbers);
		System.out.println("sorted array:");
		printArray(numbers);

	}
	
	
	public static int[] InsertionSort(int[]A){
		for(int i = 0; i<A.length;i++){
			int key= A[i];
			int j = i -1;
			
			while(j>=0 && A[j]>key){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
		
		return A;
	}
	
	
	public static void printArray(int[]A){
		for(int i = 0; i<A.length;i++){
			System.out.println(A[i]);
		}

    }
	
}
