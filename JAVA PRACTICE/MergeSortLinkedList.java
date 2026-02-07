public class MergeSortLinkedList{
  
    public static class Node{
        int data;
        Node next;
        Node(int data){
        	this.data=data;
            this.next = null;
        }
    }

	private static Node findMid(Node head){
           if(head==null || head.next==null){
           	return head;
           }
           Node slow=head;
           Node fast =head.next;
          
           while(fast!=null && fast.next!=null){
           	    slow = slow.next;
           	    fast = fast.next.next;
           }

           return slow;

	}

	public static Node merge(Node left, Node right){
          
          Node newNode = new Node(-1);
          Node temp = newNode;

          while(left != null && right != null){

          	   if(left.data<=right.data){
          	   	   temp.next = left;
          	   	   left = left.next;
          	   	   temp=temp.next;
          	   }else{
          	   	   temp.next = right;
          	   	   right = right.next;
          	   	   temp=temp.next;
          	   }
          }

          while(left != null){
          	       temp.next = left;
          	   	   left = left.next;
          	   	   temp=temp.next;
          }
           while(right != null){
          	       temp.next = right;
          	   	   right = right.next;
          	   	   temp=temp.next;
          }


          return newNode.next;


	}

   public static Node mergeSort(Node head){

   	    if(head==null || head.next==null){
   	    	  return head;
   	    }

   	    Node mid = findMid(head);
   	    Node rightHead = mid.next;
   	    mid.next=null;
   	    Node newLeft  = mergeSort(head);
   	    Node newRight = mergeSort(rightHead);
   	   

   	   

   	    return  merge(newLeft,newRight);
   }


   public static void main(String args[]){
   	  Node head =  new Node(34);
   	  head.next = new Node(67);
   	  head.next.next = new Node(23);
   	  head.next.next.next = new Node(12);
   	  head.next.next.next.next = new Node(89);

   	  head = mergeSort(head);

      Node temp = head;
   	  while(temp != null){

   	  	System.out.print(temp.data+" ");
        temp=temp.next;
   	  }


   }


}