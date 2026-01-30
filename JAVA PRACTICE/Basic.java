class summer{

	static void binarySearch(int arr[] ,int item, int left, int right){
             if(left <= right){
             	   int mid = left + (right-left)/2;

            if(arr[mid]==item){
            	System.out.print(mid+"element found");
            	return;
            }
            if(arr[mid] > item){
                binarySearch(arr,item,left,mid-1);
              }else{
              	binarySearch(arr,item,mid+1,right);
              }
             }
        }

 
    public static void main(String args[]){
    	
    	int a[] = {12,34,55,78,89,90};

         
        binarySearch(a,432423,0,a.length-1);
    }
}