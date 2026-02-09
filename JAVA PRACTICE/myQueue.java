import java.util.LinkedList;
import java.util.Queue;


public class myQueue{

	public static void find(String s){

       Queue<Character> q = new LinkedList<>();
	   int freq[] = new int[26];

	   for(int i=0;i<s.length();i++){

	   	   char  ch = s.charAt(i);
           q.add(ch);

	   	   freq[ch-'a']++;

	   	   while(!q.isEmpty() && freq[q.peek()-'a']>1){
	   	   	  q.remove();
	   	   }
	   	   if(q.isEmpty()){
	   	   	 System.out.println(-1);
	   	   }else{
             System.out.println(q.peek());
	   	   }
	   }



	}

	public static void interLeave(Queue<Integer> q){
           
           Queue<Integer> q2 = new LinkedList<>();
           int size = q.size();
           for(int i =0;i<size/2;i++){
           	   q2.add(q.remove());
           }

           while(!q2.isEmpty()){
           	    q.add(q2.remove());
           	    int elem = q.remove();
           	    q.add(elem);
           }


	}
	public static void main(String args[]){
      
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        while(!q.isEmpty()){
        	System.out.println(q.remove());
        }


	}
}