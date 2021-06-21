import java.util.Scanner;

class node {
    int data;
    int freq;
    node left,right;

    public node(int x)
    {
        data = x;
        left = right =null;
        freq = 1;
    }

    public void set_data(int x)
    {
        data = x;
    }

    public int get_data()
    {
        return data;
    }
    
    public void set_left (node temp)
    {
        left = temp;
    }

    public void set_right(node temp)
    {
        right = temp;
    }

    public node get_left()
    {
        return left;
    }

    public node get_right()
    {
        return right;
    }

    public void add_freq()
    {
        freq++;
    }

    public void delete_freq()
    {
        freq--;
    }

    public int get_freq()
    {
        return freq;
    }
}

public class BST {

    node root;

    public BST()
    {
        root = null;
    }

    public boolean insert(int x)
    {
        if (root==null)
        {
            root = new node(x);
            return true;
        }

        node temp = root;
        boolean result = searchAdd(root,x);
        System.out.println(result);

        if(result == false)
        {
            System.out.println("I'm at the beginning");
            node newNode = new node(x);
            while(true)
            {
                if(temp.get_data() < x)
                {
                    if(temp.get_right() == null)
                    {
                        temp.set_right(newNode);
                        System.out.println("I'm here at if");
                        return true;
                    }
                    temp = temp.get_right();
                }
                else
                {
                    if(temp.get_left() == null)
                    {
                        temp.set_left(newNode);
                        System.out.println("I'm here at the else if");
                        return true;
                    }
                    temp = temp.get_left();
                }
            }
        }
        else
        {
            return false;
        }
    }

    public void search(node temp,int x)
    {
        boolean found = false;
        if(root==null)
        {
            System.out.println("Empty tree");
        }
        else
        {
            if(temp.get_data() == x)
            {
                found = true;
                System.out.println(x+"("+temp.get_freq()+")");
            }
            if(found == false && temp.get_left() != null)
            {
                search(temp.get_left(),x);
            }
            if (found == false && temp.get_right()!=null)
            {
                search(temp.get_right(),x);
            } 
        } 
    }
   
    public boolean searchAdd(node temp,int x)
    {
        boolean found = false;
        boolean result1 = false;  
        boolean result2 = false;

        if(temp.get_data() == x)
        {
            found = true;
            System.out.println(x+"("+temp.get_freq()+")");
            temp.add_freq();
            return found;
        }
        else if(found == false && temp.get_left() != null)
        {
            result1 = searchAdd(temp.get_left(),x);
        }

        if(result1 == false)
        {
            if(found == false && temp.get_right() != null)
            {
                result2 = searchAdd(temp.get_right(),x);
                if (result2)
                {
                    return result2;
                }
                else
                {
                    return false; 
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return result1;
        }
    }
    
    public node deletedSearch(node temp, int x)
    {
        boolean found = false;
        node result = null;
        if(temp.get_data() == x)
        {
            found = true;
            result = temp;
        }
        else if(found == false && temp.get_left() != null)
        {
            deletedSearch(temp.get_left(),x);
        }
        else if(found == false && temp.get_right() != null)
        {
            deletedSearch(temp.get_right(), x);
        }

        if(found== true)
        {
            return result;
        }
        else
        {
            return null;
        }
    }

    public void preorder(node node)
    {
        if(root == null)
        {
            System.out.println("Empty tree");
            return;
        }
        else 
        {  
            System.out.print(node.data +"("+node.get_freq()+")"+" ");
            if(node.get_left()!= null)  
                preorder(node.get_left());    
            if(node.get_right()!= null)  
                preorder(node.get_right());  
        }  
    }

    public void postorder(node node)
    {
        if(root == null)
        {
            System.out.println("Empty tree");
            return;
        }
        else 
        {  
            if(node.get_left()!= null)  
                postorder(node.get_left());    
            if(node.get_right()!= null)  
                postorder(node.get_right());
            System.out.print(node.data +"("+node.get_freq()+")"+" ");
        }  
    }

    public void inorder(node node)
    {
        if(root == null)
        {
            System.out.println("Empty tree");
            return;
        }
        else 
        {  
            if(node.get_left()!= null)  
                inorder(node.get_left());  
            System.out.print(node.data +"("+node.get_freq()+")"+" "); 
            if(node.get_right()!= null)  
                inorder(node.get_right());  
        }  
    }

    public node maxNode(node root)
    {
        if(root.get_right() !=null){
            return maxNode(root.get_right());
        }
        else
        {
            System.out.println(root.get_data()+" ");
            return(root);
        }
    }

    public node minNode(node root)
    {
        if(root.get_left() !=null)
        {
            return minNode(root.get_left());
        }
        else
        {
            System.out.println(root.get_data()+" ");
            return(root);
        }
    }

    public node delete(node node, int x)
    {
        if(node==null)
        {
           return null;
        }
    
        else
        {
            if(x < node.get_data())
            {
               node.left = delete(node.left,x);
            }
            else if(x > node.data)  
            {
                node.right = delete(node.right, x);  
            }

            else 
            {  
                if(node.left == null && node.right == null)
                {  
                    node = null;  
                    System.out.println("I'm at the second else if");
                }
                else if(node.left == null) {  
                    node = node.right;  
                    System.out.println("I'm at the third else if");
                }  
    
                else if(node.right == null) {  
                    node = node.left;
                    System.out.println("I'm at the fourth else if");  
                }     
    
            else 
            {  
                node temp = minNode(node.right);  
                node.data = temp.data;  
                node.right = delete(node.right, temp.data); 
                System.out.println("At final else");
            }  
        }  
        return node;  
        }

    }

    public static void main(String[] args)
    {
        int option = 1;

        BST tree = new BST();

        Scanner scan = new Scanner(System.in);
        while (option>=1 && option <=8)
        {
            System.out.println("Here are your options");
            System.out.println("1. Insert an element into the BST");
            System.out.println("2. Search for an element in the BST");
            System.out.println("3. Find the maximum element from the BST");
            System.out.println("4. Find the minimum element from the BST");
            System.out.println("5. Print the elements in the BST in preorder");
            System.out.println("6. Print the elements in the BST in postorder");
            System.out.println("7. Print the elements in the BST in inorder");
            System.out.println("8. Delete an element");
            System.out.println("Anything else to exit the program");

            option = scan.nextInt();

            switch(option)
            {
                case 1:
                    System.out.println("Inserting an element into the BST");
                    int number = scan.nextInt();
                    tree.insert(number);
                    break;
                case 2:
                    System.out.println("Searching for an element in the BST");
                    int number1 = scan.nextInt();
                    tree.search(tree.root,number1);
                    break;
                case 3:
                    System.out.println("Finding the maximum element");
                    tree.maxNode(tree.root);
                    break;
                case 4: 
                    System.out.println("Finding the minimum element");
                    tree.minNode(tree.root);
                    break;
                case 5:
                    System.out.println("Printing elements in preorder");
                    tree.preorder(tree.root);
                    System.out.println("");
                    break;
                case 6: 
                    System.out.println("Printing elements in postorder");
                    tree.postorder(tree.root);
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Printing elements in inorder");
                    tree.inorder(tree.root);
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("Deleting element");
                    int number2 = scan.nextInt();
                    tree.delete(tree.root, number2);
                    break;
                default:
                    System.out.println("Thanks for using the BST program");
            }
        }
        scan.close();
    }
    
}