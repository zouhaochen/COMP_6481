package Assignment3;

import java.util.NoSuchElementException;

public class ShowList
{
    //inner class show node
    class ShowNode
    {
        private TVShow tVShow;
        private ShowNode showNode;

        //default constructor
        public ShowNode ()
        {
            tVShow = null;
            showNode = null;
        }

        //parameterized constructor
        public ShowNode(TVShow tVShow, ShowNode showNode)
        {
            this.tVShow = tVShow;
            this.showNode = showNode;
        }

        //copy constructor
        public ShowNode(ShowNode showNode)
        {
            if(showNode == null)
            {
                System.out.println("Fatal Error");
                System.exit(0);
            }
            this.tVShow = showNode.getTvShow();
            this.showNode = showNode.getShowNode();
        }

        //clone method
        protected Object clone() throws CloneNotSupportedException
        {
            ShowNode showNode = (ShowNode) super.clone();
            return showNode;
        }

        //mutator of tv show
        public void setTvShow(TVShow tVShow)
        {
            this.tVShow = tVShow;
        }

        //accessor of tv show
        public TVShow getTvShow()
        {
            return tVShow;
        }

        //mutator of show node
        public void setShowNode(ShowNode showNode)
        {
            this.showNode = showNode;
        }

        //accessor of tv show
        public ShowNode getShowNode()
        {
            return showNode;
        }
    }

    private static int size;
    private ShowNode head;

    //default constructor an empty list
    public ShowList ()
    {
        size = 0;
        head = null;
    }

    //copy constructor
    public ShowList (ShowList showList)
    {
        this.size = showList.getSize();
        this.head = showList.getHead();
    }

    //mutator of size
    public void setSize(int size)
    {
        this.size = size;
    }

    //accessor of size
    public int getSize()
    {
        return size;
    }

    //mutator of head
    public void setHead(ShowNode head)
    {
        this.head = head;
    }

    //accessor of head
    public ShowNode getHead()
    {
        return head;
    }

    /*
    insert the node at the head of the list
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public void addToStart(TVShow tvShow)
    {
        ShowNode showNode = new ShowNode();
        showNode = new ShowNode(tvShow, showNode);

        if(head == null)
        {
            head = showNode;
            size = 1;
        }
        else
        {
            showNode.showNode = this.head;
            this.head = showNode;
            size ++;
        }
    }

    /*
    insert the node at the last of the list
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode
     */
    public void addToLast(TVShow tvShow)
    {
        ShowNode showNode = new ShowNode();
        showNode = new ShowNode(tvShow, showNode);

        if(head == null)
        {
            head = showNode;
            size = 1;
        }
        else
        {
            findLastNode().showNode = showNode;
            size ++;
        }
    }

    /*
    get the last node of the list
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public ShowNode findLastNode()
    {
        ShowNode current = this.head;
        while (current.showNode != null)
        {
            current = current.showNode;
        }
        return current;
    }

    /*
    insert the node at the index position
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public void insertAtIndex(TVShow tvShow, int index)
    {
        if(index < 0 || index>getSize() - 1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }

        if(index == 0)
        {
            addToStart(tvShow);
            return;
        }

        if(index == getSize() - 1)
        {
            addToLast(tvShow);
            return;
        }

        ShowNode current = moveIndex(index);
        ShowNode showNode = new ShowNode();
        showNode = new ShowNode(tvShow, showNode);

        showNode.showNode= current.showNode;
        current.showNode = showNode;
    }

    /*
    find the reference to the node at index - 1
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public ShowNode moveIndex(int index)
    {
        ShowNode current = this.head;
        int count = 0;
        while(count != index - 1)
        {
            current = current.showNode;
            count++;
        }
        return current;
    }

    /*
    delete the node pointed to the index
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode, head, and tv show
     */
    public void deleteFromIndex(int index)
    {
        if(index < 0 || index>getSize() - 1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }
        else if(this.head == null)
        {
            size = 0;
            return;
        }
        else
        {
            ShowNode temp = getNode(index);
            if(temp.showNode != null)
            {
                temp.tVShow = temp.showNode.tVShow;
                temp.showNode = temp.showNode.showNode;
            }
            else
            {
                //find the precursor node corresponding to the subscript
                ShowNode previousNode = getNode(index - 1);
                //set next for the precursor node to null
                previousNode.showNode = null;
            }
            size--;
        }
    }

    /*
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public ShowNode getNode(int index)
    {
        if(index<0||index>size-1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }

        int location = 0;
        ShowNode temp = this.head;

        while(temp.showNode != null && location != index)
        {
            temp = temp.showNode;
            location++;
        }
        return temp;
    }

    /*
    delete the first node in the list
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public void deleteFromStart()
    {
        if(head == null)
        {
            return;
        }
        else
        {
            ShowNode temp = this.head;
            head = head.showNode;
            size --;
        }
    }

    /*
    replace the object in the node at the passed index
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter tv show
     */
    public void replaceAtIndex(TVShow tvShow, int index)
    {
        if(index<0||index>size-1)
        {
            return;
        }
        ShowNode temp = moveIndex(index);
        temp.tVShow = tvShow;
    }

    /*
    find show id in the list
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public ShowNode find(String showID)
    {
        ShowNode current = this.head;
        int numberOfIteration = 0;

        while(current != null)
        {
            if(current.getTvShow().getShowID().equals(showID))
            {
                System.out.println("Number of iteration to find the show id is: " + numberOfIteration);
                return current;
            }
            else
            {
                current = current.showNode;
                numberOfIteration ++;
            }
        }

        System.out.println("Number of iteration to find the show id is: " + numberOfIteration);
        return null;
    }

    /*
    accept show id and returns true and false on where has a tv show with the id or not
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public boolean contain(String showID)
    {
        ShowNode current = this.head;

        while(current != null)
        {
            if(current.getTvShow().getShowID() == showID)
            {
                return true;
            }
            current = current.showNode;
        }
        return false;
    }

    /*
    this method may result in a privacy leak
    because the parameter of the public method access directly to
    the private parameter showNode and head
     */
    public boolean equals(ShowList showList1, ShowList showList2)
    {
        ShowNode current1 = showList1.head;
        ShowNode current2 = showList2.head;

        while (current1.showNode != null || current2.showNode != null)
        {
            if(current1.getTvShow().equals(current2.getTvShow()))
            {
                current1 = current1.showNode;
                current2 = current2.showNode;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
