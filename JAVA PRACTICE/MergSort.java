public class MergSort{


	  public static void mergeSort(int arr[],int start,int end){
	  	if(start < end){
	  		int mid = start + (end-start)/2;

	  		mergeSort(arr,start,mid);
	  		mergeSort(arr,mid+1,end);

	  		merge(arr,start,end,mid);
	  	}
	  }
      
      public static void merge(int arr[],int low,int hight,int mid){
      	  int lindex = low;
      	  int rindex = mid+1;

      	  int newArr[] = new int[hight-low+1];

      	  int index=0;


      	  while(lindex <= mid && rindex <= hight){

      	  	   if(arr[lindex]<=arr[rindex]){
      	  	   	    newArr[index++]=arr[lindex++];
      	  	   }else{
      	  	   	   newArr[index++]=arr[rindex++];
      	  	   }
      	  }
      	  while(lindex <= mid){
      	  	 newArr[index++]=arr[lindex++];
      	  }
      	  while(rindex <= hight){
      	  	newArr[index++]=arr[rindex++];
      	  }

      	  for(int i=0,j=low;i<newArr.length;i++,j++){
                arr[j]=newArr[i];
      	  }

      }


      public static void main(String args[]){
            int arr[]= {12,11,4,15,66,68,88,90,16,99};
            mergeSort(arr,0,arr.length-1);
            for(int s:arr){
               System.out.print(s+" ");
            }

      }
}