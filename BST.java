import java.util.Scanner;
//node class created with methods needed to make the binary search tree work
class node {
    int data;
    int freq;
    node left,right;
// initialise the node setting the data as what the code will provide it. The left and right nodes will be set to null and the node will have a freqeuncy of 1 to begin with.
    public node(int x)
    {
        data = x;
        left = right =null;
        freq = 1;
    }
//set_data method used to set the data of the node
    public void set_data(int x)
    {
        data = x;
    }
//get_data method allows for the data stored in that node to be retrieved 
    public int get_data()
    {
        return data;
    }
//set_left method sets the data of the left node    
    public void set_left (node temp)
    {
        left = temp;
    }
//set_right method sets the data of the left node 
    public void set_right(node temp)
    {
        right = temp;
    }
//get_left method returns the data in the left node
    public node get_left()
    {
        return left;
    }
//get_right method returns the data in the left node
    public node get_right()
    {
        return right;
    }
//add_freq method used to add one to the frequency of the node if it is repeated
    public void add_freq()
    {
        freq++;
    }
//delete_freq method used to delete one from the frequency of the node when being deleted
    public void delete_freq()
    {
        freq--;
    }
//get_freq returns the frequency of the node 
    public int get_freq()
    {
        return freq;
    }
}

public class BST {
//declares a node which will be root of the BST 
    node root;
//initalises the root to be null until the user enters data for the root
    public BST()
    {
        root = null;
    }
/**
 * @param x the value that needs to be assigned to a node 
 * @return a booelan value representing whether a node has been succesfully entered
 * If the root is already assigned the insert method uses the searchAdd() method to check if the value is already in the BST. If it is it finds the node and adds one to the frequency of the node.
 * If the searchAdd() doesn't find the value in the BST it creates a new node and assigns the new value to it
 */
    public boolean insert(int x)
    {
        if (root==null)
        {
            root = new node(x);
            return true;
        }

        node temp = root;
        boolean result = searchAdd(root,x);

        if(result == false)
        {
            node newNode = new node(x);
            while(true)
            {
                if(temp.get_data() < x)
                {
                    if(temp.get_right() == null)
                    {
                        temp.set_right(newNode);
                        return true;
                    }
                    temp = temp.get_right();
                }
                else
                {
                    if(temp.get_left() == null)
                    {
                        temp.set_left(newNode);
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
/**
 * @param temp Used to get the node in which the search method needs to start at 
 * @param x Used to store the integer that needs to be found in the BST
 * The method first checks to see if the BST has no root. If so it prints "Empty Tree"
 * If there is a root it goes through the tree repeatedly and tries to find the node.
 * If the node is found it is printed along with the node's frequency 
 */
    public void search(node temp,int x)
    {
        boolean found = false;
        if(root==null)
        {
        }
        else if(temp.get_data() == x)
        {
            found = true;
            System.out.println(x+"("+temp.get_freq()+")");
        }
        else if(found == false && temp.get_left() != null)
        {
            search(temp.get_left(),x);
        }
        else if (found == false && temp.get_right()!=null)
        {
            search(temp.get_right(),x);
        } 
        else
        {
            System.out.println(x+"(0)");
        }
    }
/**
 * @param temp Used to get the node in which the search needs to start from
 * @param x Used to store the integer that needs to be found in the BST
 * @return a boolean value. If true it indicates the node is in the tree and if false it indicates the node isn't in the tree. 
 * This method is similar to the search method above except this time it returns a boolean value in order to help add one to the frequency in the insert method
 */    
    public boolean searchAdd(node temp,int x)
    {
        boolean found = false;
        boolean result1 = false;  
        boolean result2 = false;

        if(temp.get_data() == x)
        {
            found = true;
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
    
 /**
 * @param node this is the node in which the method needs to start from
 * This method prints out the tree in the preorder
 */  
    public void preorder(node node)
    {
        if(root == null)
        {
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
/**
 * @param node this is the node in which the method needs to start from 
 * This method prints out the tree in the postorder
 */
    public void postorder(node node)
    {
        if(root == null)
        {
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
/**
 * @param node this is the node in which the method needs to start from
 * This method prints out the tree inorder
 */
    public void inorder(node node)
    {
        if(root == null)
        {
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
/**
 * @param root gets the root node to start from 
 * @return Used to return the node that is the maximum 
 */
    public node maxNode(node root)
    {
        if(root == null)
        {
            System.out.println("0(0) ");
            return root;
        }
        if(root.get_right() !=null){
            return maxNode(root.get_right());
        }
        else
        {
            System.out.println(root.get_data()+""+"("+root.get_freq()+")");
            return(root);
        }
    }
/**
 * @param root the root which the method needs to start from to find the maximum 
 * @return the node which is the max
 */
    public node max(node root)
    {
        if(root == null)
        {
            return root;
        }
        if(root.get_right() !=null){
            return max(root.get_right());
        }
        else
        {
            return(root);
        }
    }
/**
 * @param root gets the root node to start from
 * @return Used to return the node that is the minimum
 */
    public node minNode(node root)
    {
        if(root == null)
        {
            System.out.println("0(0) ");
            return root;
        }
        if(root.get_left() !=null)
        {
            return minNode(root.get_left());
        }
        else
        {
            System.out.println(root.get_data()+""+"("+root.get_freq()+")");
            return(root);
        }
    }
/**
 * @param node gets the node in which the method needs to start at to find the node that needs to be deleted
 * @param x the integer that needs to be deleted
 * @return the node that is being deleted
 */
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
                    if(node.freq == 1 && node ==root)
                    {
                        root = null;
                    }
                    if(node.freq==1)
                    {
                        node = null;  
                    }
                    else
                    {
                        node.delete_freq();
                    }
                }

                else if(node.left == null) {
                    if(node.freq == 1 && node==root)
                    {
                        root = node.right; 
                        root.left = null; 
                    }
                    else if(node.freq==1)
                    {
                        node = node.right;
                    }
                    else
                    {
                        node.delete_freq();
                    }
                }  

                else if(node.right == null) { 
                    if(node.freq == 1 && node==root)
                    {
                        root = node.left;
                        root.left = null;
                    }
                    else if(node.freq == 1)
                    {
                        node = node.left;
                    }
                    else
                    {
                        node.delete_freq();
                    }
                }     

            else 
            {  
                if(node.freq == 1)
                {
                    node temp = max(node.left);   
                    node.data = temp.data;  
                    node.freq = temp.freq;
                    node.left = delete(node.left, temp.data);
                }
                    else
                    {
                        node.delete_freq();
                    }
                }  
            } 
        } 
        return node;  
    }

/**
 * This is the main method giving the users a menu to chose a option they want to execute on the tree
 * Each case calls the appropiate function `
 */
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
                    int number = scan.nextInt();
                    tree.insert(number);
                    break;
                case 2:
                    int number1 = scan.nextInt();
                    tree.search(tree.root,number1);
                    break;
                case 3:
                    tree.maxNode(tree.root);
                    break;
                case 4: 
                    tree.minNode(tree.root);
                    break;
                case 5:
                    tree.preorder(tree.root);
                    System.out.println("");
                    break;
                case 6: 
                    tree.postorder(tree.root);
                    System.out.println("");
                    break;
                case 7:
                    tree.inorder(tree.root);
                    System.out.println("");
                    break;
                case 8:
                    int number2 = scan.nextInt();
                    tree.delete(tree.root, number2);
                    break;
                default:
            }
        }
        scan.close();
    }
    
}
