package cpcs204_a1;

import java.util.Scanner;

public class Problem_4 {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {

        LinkedListP4 list = new LinkedListP4();
        
        System.out.println("Enter the list you want to sort, input -100 to stop: "); int listFiller = in.nextInt();
        
        nodeP4 head = list.head = new nodeP4(listFiller);
        nodeP4 currentlist = head;
        nodeP4 prevcurrentlist = head;
        
        listFiller = in.nextInt();
        
        while (listFiller != -100){
            
            nodeP4 temp = new nodeP4(listFiller);
            currentlist.next = temp;
            currentlist = temp;
            currentlist.prev = prevcurrentlist;
            prevcurrentlist = prevcurrentlist.next;
            listFiller = in.nextInt();

        }
        
        System.out.print("----------------------------------------------------\n----------------------------------------------------");
        System.out.println("\nBefore sorting: ");list.printAllNodes();
        
        list.head = list.sort(head);
        System.out.println("After sorting: ");list.printAllNodes();
    

    }  
}

class LinkedListP4{
    
    public nodeP4 head;
    public nodeP4 pointer;

    public LinkedListP4() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void printAllNodes(){
        pointer = head;

        while (pointer != null){
            if (pointer.next == null)
                System.out.println(pointer.data+" <-> null");
            else
                System.out.print(pointer.data+" <-> ");
            
            pointer = pointer.next;
        }  
    }
    
    public void printAllNodesPrev(){
        pointer = head;
        
        while(pointer.next != null)
                pointer = pointer.next;

        while (pointer != null){
            
            if (pointer.prev == null)
                System.out.println(pointer.data+" <-> null");
            else
                System.out.print(pointer.data+" <-> ");
            
            pointer = pointer.prev;
        }  
    }
    
    public nodeP4 sort(nodeP4 head){
        
       nodeP4 outter, inner;
       int temp;
       
       for(outter = head; outter != null ; outter = outter.next)                //Outter loop which will hold the first node.
           
           for(inner = outter.next; inner != null ; inner = inner.next){        //Inner loop which will hold the node after and used for comparission.
               
               if(outter.data  > inner.data){                                   //This (>) would allow the list to be sorted ascendingly.
                   temp = inner.data;
                   inner.data = outter.data;
                   outter.data = temp;                  
               }   
           }    
    return head;}
}

class nodeP4{
    
    public int data;
    public nodeP4 next;
    public nodeP4 prev;

    public nodeP4(int data) {
        this(data, null);
    }

    public nodeP4(int data, nodeP4 next) {
        this.data = data;
        this.next = next;
    }
    
    
 } 
