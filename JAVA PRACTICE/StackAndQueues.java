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

    
    public static void main(String args[]){
          Stack<Integer> stack = new Stack<>();


          stack.push(1);
          stack.push(2);
          stack.push(3);
          stack.push(4);


          pushAtBottom(stack , 667);


          for(int i=0;i<5;i++){
          	System.out.println(stack.peek());
          	stack.pop();
          }

    }
}