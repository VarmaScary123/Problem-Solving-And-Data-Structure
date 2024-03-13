package DataStructures.List;

import java.util.*;

class Node {
    Node prev;
    int coefficient;
    int exponent;
    Node next;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
}

public class PolynomialUsingDLL {
    Node head;
    Node tail;

    public void insert(int coefficient, int exponent) {
        Node new_node = new Node(coefficient, exponent);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    public void display() {
		Node current = head;
		if(current==null) {
			System.out.println("List is Empty");
		}
		else {
			boolean isHead = true;
			while(current!=null) {
				if(current.coefficient!=0) {
					if(current.coefficient<0) {
						System.out.print(" - ");
					}
					else if(!isHead) {
						System.out.print(" + ");
					}
					System.out.print(Math.abs(current.coefficient));
					if(current.exponent>0) {
						System.out.print("x");
						if(current.exponent>1) {
							System.out.print(current.exponent);
						}
					}
					isHead = false;
				}
				current = current.next;
			}
			System.out.println();
		}
	}

    public PolynomialUsingDLL addPolynomial(PolynomialUsingDLL p1, PolynomialUsingDLL p2) {
        PolynomialUsingDLL result = new PolynomialUsingDLL();
        Node current1 = p1.head;
        Node current2 = p2.head;
    
        while (current1 != null || current2 != null) {
            int exp1 = (current1 != null) ? current1.exponent : Integer.MIN_VALUE;
            int exp2 = (current2 != null) ? current2.exponent : Integer.MIN_VALUE;
    
            if (exp1 == exp2) {
                result.insert(current1.coefficient + current2.coefficient, exp1);
    
                if (current1 != null) current1 = current1.next;
                if (current2 != null) current2 = current2.next;
            } else if (exp1 > exp2) {
                result.insert(current1.coefficient, current1.exponent);
                current1 = current1.next;
            } else {
                result.insert(current2.coefficient, current2.exponent);
                current2 = current2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PolynomialUsingDLL p1 = new PolynomialUsingDLL();
        int size1 = sc.nextInt();
        for (int i = 0; i < size1 / 2; i++)
            p1.insert(sc.nextInt(), sc.nextInt());

        PolynomialUsingDLL p2 = new PolynomialUsingDLL();
        int size2 = sc.nextInt();
        for (int i = 0; i < size2 / 2; i++)
            p2.insert(sc.nextInt(), sc.nextInt());

        PolynomialUsingDLL result = new PolynomialUsingDLL();
        result = result.addPolynomial(p1, p2);
        result.display();
        sc.close();
    }
}