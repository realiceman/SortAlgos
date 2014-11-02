package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int []numbers ={10,5,3,7,2};
		
		selectionSort(numbers);
		printArray(numbers);

	}
	
	public static int[] selectionSort(int[]A){
		for(int i=0;i<A.length-1;i++){
			int minIndex = i;
			for(int j = i+1; j<A.length;j++){
				if(A[j]<A[minIndex]){
					minIndex = j;
				}
			}
			
			int temp = A[minIndex];
			A[minIndex]=A[i];
			A[i]=temp;
			
		}
		return A;
	}
	

	public static void printArray(int[]A){
		for(int i = 0; i<A.length;i++){
			System.out.println(A[i]);
		}

   }
	
}
