class sortingAlgo{

	public static void BubbleSort(int arr[]){

	  int n = arr.length;
	  for(int i=1;i<=n-1;i++){
          for(int j=0;j<=n-1-i;j++){
          	  if(arr[j+1] < arr[j] ){
          	  	int temp;
          	  	temp = arr[j+1];

          	  	arr[j+1]=arr[j];
          	  	arr[j]=temp;
          	  }
          }
	  }
	}

	public static void SelectionSort(int arr[]){

        int n = arr.length;
		for(int i=0;i<n-1;i++){

			for(int j=i+1;j<=n-1;j++){
				int min=i;
               if(arr[min]>arr[j]){
               	  min=j;
               }
               int temp = arr[min];
               	  arr[min]=arr[i];
               	  arr[i]=temp;
			}
		}
	}

	public static void InsertionSort(int arr[]){
		int n = arr.length;

		for(int i=0;i<n-1;i++){
			int curr = arr[i+1];
			int prev = i;

			while(prev >=0 && curr < arr[prev]){
				  arr[prev+1]=arr[prev];
				  prev--;
			}
			arr[prev+1]=curr;
		}
	}

	public static void main(String args[]){
          int arr[] = {34,6,12,90,45,11,67,23,1,89};
         InsertionSort(arr);

          for(int s:arr){
          	 System.out.print(s+" ");
          }
	}
}