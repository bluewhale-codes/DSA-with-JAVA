import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


class summer{

    public static int findMax(int arr[],int k){

    	int max_sum = 0;
    	int sum = 0;
    	int index=0;
    	while(index < arr.length && index < k){
    		sum += arr[index];
    		index++;
    	}
    	max_sum=sum;

    	for(int i=1;i<arr.length-k+1;i++){
    		int prev = arr[i-1];
            int next = arr[i+k-1];
            sum = sum - prev + next;
            max_sum = Math.max(sum,max_sum);
    	}

    	return max_sum;
    }


    public static void findNegative(int arr[],int k){
           Queue<Integer> q = new LinkedList<>();
           int n = arr.length;
           int index =0;
           while(index < k && index <arr.length){
           	    if(arr[index] < 0){
           	    	q.add(arr[index]);
           	    }
           	    index++;
           }

           ArrayList<Integer> newArr = new ArrayList<>();
           

           for(int i=0;i<n-k+1;i++){
               if(q.isEmpty()){
               	 newArr.add(0);
               }else{
               	  newArr.add(q.peek());
               	  if(arr[i] < 0 || arr[i]==q.peek()){
               	    q.remove();
               }
               if(arr[i+k] < 0){
               	q.add(arr[i+k]);
               }
               }

               
           }
          
           	System.out.print(newArr);
           
           




    }

    
	public static void main(String args[]){
          int arr[] = {12,-1,-7,8,-15,30,16,28};
          findNegative(arr,3);
	}
}