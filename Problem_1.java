package cpcs204_a1;

import java.util.Scanner;

public class Problem_1 {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Enter your list, enter -1 to stop: "); int listFiller = in.nextInt();
        
        LinkedListP1 nmbrs = new LinkedListP1();
        
        nmbrs.head = new nodeP1(listFiller);
        nodeP1 current = nmbrs.head;
             
        listFiller = in.nextInt();
        
        while (listFiller != -1){
            
            nodeP1 temp = new nodeP1(listFiller);
            current.next = temp;
            current = temp;
            listFiller = in.nextInt();

        }
        
        System.out.print("\nThe list before deletetion: ");nmbrs.printAllNodes();
        
        System.out.print("\nHow many steps ? "); int steps = in.nextInt(); 
        System.out.print("How many skips ? "); int skips = in.nextInt(); 
        
        nmbrs.head = nmbrs.deleteNodes(steps, skips);
        System.out.print("\nAfter deletetion: ");nmbrs.printAllNodes();

    }
}

class LinkedListP1{
    
    public nodeP1 head;
    public nodeP1 pointer;

    public LinkedListP1() {
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
    
    public nodeP1 deleteNodes(int steps, int skips){
        
        if(!isEmpty()){                                              //checks if the list is empty.
            pointer = head;
            
            while(pointer != null){                                 //Reapeats the loop until the ebdof the list.
                
                for (int i = 1; i < skips; i++)                     //Skips the number of nodes required.
                    if(pointer.next != null)                        
                        pointer = pointer.next;
                
                for (int i = 0; i < steps; i++)                     //Deletes the number of nodes required.
                    if(pointer.next != null)
                        pointer.next = pointer.next.next;
                
                pointer = pointer.next;                             
            }
        }
    return head;}
}

class nodeP1{
    
    public int data;
    public nodeP1 next;

    public nodeP1(int data) {
        this.data = data;
    }
 } 

