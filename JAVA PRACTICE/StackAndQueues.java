import java.util.Stack;

class summer{

	public static void pushAtBottom(Stack<Integer> s,int item){

		  if(s.isEmpty()){
		  	 s.push(item);
		  	 return;
		  }
          int elem = s.peek();
		  s.pop();
		  pushAtBottom(s,item);
		  s.push(elem);
	}

	public static void reverse(String s){

		  Stack<Character> stack = new Stack<>();
      for(int i=0;i<s.length();i++){
      	  stack.push(s.charAt(i));
      }

      for(int i=0;i<s.length();i++){
      	  System.out.print(stack.peek());
      	  stack.pop();
      }

	}
	public static void reverseStack(Stack<Integer> s){
       if(s.isEmpty()){
       	return;
       }

      int item = s.peek();
      s.pop();
      reverseStack(s);
      pushAtBottom(s,item);

	}

	public static void stockSpan(int stocks[],int span[]){
       Stack<Integer> stack = new Stack<>();
		   span[0]=1;
       stack.push(0);


       for(int i=1;i<stocks.length;i++){

       	   int curr = stocks[i];
       	   while(!stack.isEmpty() && curr > stocks[stack.peek()]){
                  
                  stack.pop();
       	   }
           
           if(stocks[stack.peek()]==stocks[i]){
           	  span[i]=i-stack.peek()+1;
           }else{
             span[i]=i-stack.peek();
           } 
           stack.push(i);
       	   
       }
	}

	public static void nextGreatest(int arr[]){
       int newArr[] = new int[arr.length];


       Stack<Integer> s = new Stack<>();
       
       for(int i=arr.length-1;i>=0;i--){
           int curr = arr[i];
           while(!s.isEmpty() && curr >= arr[s.peek()]){
           	   s.pop();
           }

           if(s.isEmpty()){
           	  newArr[i]=-1;
           }else{
           	 newArr[i]=arr[s.peek()];
           }

            s.push(i);
       }


       for(int i:newArr){
       	  System.out.print(i+" ");
       }
	}

    
    public static void main(String args[]){
          Stack<Integer> stack = new Stack<>();


          stack.push(1);
          stack.push(2);
          stack.push(3);
          stack.push(4);
          stack.push(5);
       
          reverseStack(stack);
         
          for(int i=0;i<5;i++){
          	System.out.println(stack.peek());
          	stack.pop();
          }


          // Stock span Problem;

          int stocks[] = {100,80,60,70,60,85,100};
          int span[] = new int[stocks.length];


          stockSpan(stocks,span);

          for(int i:span){
          	System.out.print(i+" ");
          }

          // Next greater Element

         System.out.println("");

         System.out.println("Next Greater Element");
         int arr[] = {6,8,0,1,3};
         nextGreatest(arr);
         


    }
}