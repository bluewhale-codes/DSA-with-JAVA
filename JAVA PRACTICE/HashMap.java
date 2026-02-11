import java.util.LinkedList;
import java.util.HashSet;
import java.util.*;


class MyHashMap<K,V>{ // Generics values
     
    private class Node{
         K key;
         V value;
         public Node(K key,V value){
            this.key = key;
            this.value = value;
         }
     }

         private int n=0;// no. of nodes
         private LinkedList<Node> bucket[];
         int N;

         @SuppressWarnings("unchecked")
         public MyHashMap(){
              this.N = 4;
              this.bucket = new LinkedList[4];
              for(int i=0;i<4;i++){
                 bucket[i]=new LinkedList<>();
              }
         }


         //put function;
         public void put(K key,V value){
               int bi = hashFunction(key);
               int di = searchInLL(key,bi);
               if(di != -1){
                    Node node = bucket[bi].get(di);
                    node.value = value;
               }else{
                   bucket[bi].add(new Node(key,value));
                   n++;
               }
         }

         //Now hash function
         private int hashFunction(K key){
             int hc = key.hashCode();
             return Math.abs(hc) % N;
         }

         //search function
         private int searchInLL(K key , int bi){
            LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key==key){
                    return di;
                } 
                di++;
            }
            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }

            return -1;
         }

         // rehash function;
         private void rehash(){
              LinkedList<Node> old[] = bucket;

              bucket = new LinkedList[N*2];
              N=N*2;

              for(int i=0;i<bucket.length;i++){
                   bucket[i]=new LinkedList<>();
              }

              for(int i=0;i<old.length;i++){
                 LinkedList<Node> ll = old[i];
                 for(int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                 }
              }
         }

         public V get(K key){
            int bi = hashFunction(key);
               int di = searchInLL(key,bi);
               if(di != -1){
                    Node node = bucket[bi].get(di);
                   return node.value;
               }else{
                   return null;
               }
         }
    }


public class HashMap{





	public static void main(String args[]){
         MyHashMap<String,Integer> hm = new MyHashMap<>();

         hm.put("India",40);
         hm.put("China",87);
         hm.put("USA",88);
         hm.put("Nepal",19);
         hm.put("pak",-7);


         HashSet<Integer> hs = new HashSet<>();
         hs.add(12);
         hs.add(32);
         hs.add(78);
         hs.add(87);

        for(int i:hs){
            System.out.println(i); 
	    }
        Iterator it = hs.iterator();
        while(it.hasNext())
             System.out.println(it.next());

        }
}