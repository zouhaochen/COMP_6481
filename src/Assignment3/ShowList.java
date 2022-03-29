package Assignment3;

import java.util.NoSuchElementException;

public class ShowList<TVShow>
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
            this.tVShow = showNode.getVShow();
            this.showNode = showNode.getShowNode();
        }

        //clone method
        protected Object clone() throws CloneNotSupportedException
        {
            ShowNode showNode = (ShowNode) super.clone();
            return showNode;
        }

        //mutator of tv show
        public void settVShow(TVShow tVShow)
        {
            this.tVShow = tVShow;
        }

        //accessor of tv show
        public TVShow getVShow()
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

    //insert the node at the head of the list
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

    //insert the node at the last of the list
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

    //get the last node of the list
    public ShowNode findLastNode()
    {
        ShowNode current = this.head;
        while (current.showNode != null)
        {
            current = current.showNode;
        }
        return current;
    }

    //insert the node at the index position
    public void insertAtIndex(TVShow tvShow, int index)
    {
        if(index<0||index>getSize() - 1)
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

    //find the reference to the node at index - 1
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

}
