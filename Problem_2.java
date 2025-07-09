package cpcs204_a1;

import java.util.Scanner;

public class Problem_2 {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Enter your list, enter -1 to stop: "); int listFiller = in.nextInt();
        
        LinkedListP2 nmbrs = new LinkedListP2();
        
        nmbrs.head = new nodeP2(listFiller);
        nodeP2 current = nmbrs.head;
             
        listFiller = in.nextInt();
        
        while (listFiller != -1){
            
            nodeP2 temp = new nodeP2(listFiller);
            current.next = temp;
            current = temp;
            listFiller = in.nextInt();

        }
        
        System.out.print("\nThe list before swapping: ");nmbrs.printAllNodes();
        
        System.out.print("\nWhich node to swap ? "); int index = in.nextInt(); 
        
        nmbrs.head = swapNodes(nmbrs.head, index);
        System.out.print("\nAfter swapping: ");nmbrs.printAllNodes();
        
    }
    
    public static nodeP2 swapNodes(nodeP2 head, int index){
         
        if(head == null)                                                        //Checks if list is empty.
            return head;
            
        nodeP2 firstNumber = head, prevF = head;
        nodeP2 secondNumber = head, prevS = head;
        nodeP2 current = head, pointer = head;
        
        for(int i = 1; i < index ; i++){                                        //Loops thorugh the list until it finds the previous of the k-th node.
            
            prevF = current;
            current = current.next;                                             //Current here is after the prevF intialization because we want the next current (after the current in prevF) to be intialized in firstNumber. 
            
            firstNumber = (i == index -1)?current:firstNumber;                  //If the previous k-th was found, intialize firstNumber.
        }
        
         while(current.next != null){
            
            prevS = pointer;                                                    //Same idea as the first loop. However, the pointer here is for prevS and its next is for secondNumber.
            pointer = pointer.next;                                             
            current = current.next;                                             //The idea here is to continue from where counter left off.
            
            secondNumber = (current.next == null)?pointer:secondNumber;         //If the next current is null, intialize firstNumber.
        }
       
        if(firstNumber.next == secondNumber){                                   //Both condtions checks if the sawpped nodes are next to each other.
            
            firstNumber.next = secondNumber.next;                               
            secondNumber.next = firstNumber;
 
            if(prevF != null && prevF != firstNumber)                           //This condtion is specifically to avoid the 2 nodes only lists from being infinite.
                prevF.next = secondNumber;
            else
                head = secondNumber;
            
        }else                                                                   
            if(secondNumber.next == firstNumber){                               //Same idea as the one above.
            
            secondNumber.next = firstNumber.next;
            firstNumber.next = secondNumber;
 
            if(prevS != null && prevS != secondNumber)
                prevS.next = firstNumber;
            else
                head = firstNumber;
            
        }else 
            if (firstNumber == head){                                           //Checks if the node is the first one.
                
            head = secondNumber;
            secondNumber.next = firstNumber.next;
            prevS.next = firstNumber;
            firstNumber.next = null;
            
        }else 
            if (secondNumber == head){                                          //Checks if the node is the last one.
                
            head = firstNumber;
            firstNumber.next = secondNumber.next;
            prevF.next = secondNumber;
            secondNumber.next = null;
        
        }else{
            pointer = secondNumber.next;                                        //This one is for all case scenarios other than the ones above.
            secondNumber.next = firstNumber.next;
            firstNumber.next = pointer;
 
            prevF.next = secondNumber;
            prevS.next = firstNumber;
        }
        
    return head ;
    }
}

class LinkedListP2{
    
    public nodeP2 head;
    public nodeP2 pointer;

    public LinkedListP2() {
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
}

class nodeP2{
    
    public int data;
    public nodeP2 next;

    public nodeP2(int data) {
        this.data = data;
    }
 } 
