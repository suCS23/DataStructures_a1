package cpcs204_a1;

import java.util.Scanner;

public class Problem_3 {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {

        LinkedListP3 list1 = new LinkedListP3();
        
        System.out.println("Enter your first list, enter -1 to stop: "); int list1Filler = in.nextInt();
        
        list1.head = new nodeP3(list1Filler);
        nodeP3 currentlist1 = list1.head;
        
        list1Filler = in.nextInt();
        
        while (list1Filler != -1){
            
            nodeP3 temp = new nodeP3(list1Filler);
            currentlist1.next = temp;
            currentlist1 = temp;
            list1Filler = in.nextInt();

        }
     
        LinkedListP3 list2 = new LinkedListP3();
        
        System.out.println("Enter your second list, enter -1 to stop: "); int list2Filler = in.nextInt();
        
        list2.head = new nodeP3(list2Filler);
        nodeP3 currentlist2 = list2.head;
        
        list2Filler = in.nextInt();
        
        while (list2Filler != -1){
            
            nodeP3 temp = new nodeP3(list2Filler);
            currentlist2.next = temp;
            currentlist2 = temp;
            list2Filler = in.nextInt();

        }
        
        LinkedListP3 list = new LinkedListP3();
        list.head = list.sortedIntersect(list1.head, list2.head);
        
        System.out.print("----------------------------------------------------");
        System.out.println("\nThe intersections between list 1 and list 2 are: ");list.printAllNodes();

    }
}

class LinkedListP3{
    
    public nodeP3 head;
    public nodeP3 pointer;

    public LinkedListP3() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void printAllNodes(){
        pointer = head;
        
        while (pointer != null){
            if (pointer.next == null)
                System.out.println(pointer.data+" -> null");
            else
                System.out.print(pointer.data+" -> ");
            
            pointer = pointer.next;
        }
    }
    
    public nodeP3 sortedIntersect(nodeP3 pointer1, nodeP3 pointer2){

     nodeP3 counter1 = pointer1, counter2 = pointer2;
        
        while(counter1 != null){                                                //Loops the list until its empty.
            counter2 = pointer2;                                                //After finishing looping of one node from counter 1 thorugh all nodes in counter 2,  
                                                                                //counter 2 needs to be reseted so the next node from counter 1 would go thorugh each node from counter 2 again.
            while(counter2 != null){

                 if(counter1.data == counter2.data){                            //If there is a match it will make a new list.
                     
                     if(head == null){                                          //Forms a linkedlist by making a new head.
                         head = new nodeP3(counter1.data);
                         pointer = head;
                     }else{                                                     
                         nodeP3 temp = new nodeP3(counter1.data);               //For after the head.
                         pointer.next = temp;
                         pointer = temp;
                     }
                     break;                                                     //To avoid false repeteion.
                 }
                 counter2 = counter2.next;
            }
            counter1 = counter1.next;
        }     
    return head;
    }
}

class nodeP3{
    
    public int data;
    public nodeP3 next;

    public nodeP3(int data) {
        this(data, null);
    }

    public nodeP3(int data, nodeP3 next) {
        this.data = data;
        this.next = next;
    }
 } 
