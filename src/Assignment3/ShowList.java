package Assignment3;

import java.util.NoSuchElementException;

public class ShowList
{
    /*
    inner class show node
    fix the privacy leaks
     */
    private class ShowNode
    {
        private TVShow tVShow;
        private ShowNode link;

        //default constructor
        public ShowNode ()
        {
            tVShow = null;
            link = null;
        }

        //parameterized constructor
        public ShowNode(TVShow tVShow, ShowNode link)
        {
            this.tVShow = tVShow;
            this.link = link;
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
            this.link = showNode.getLink();
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
        public void setLink(ShowNode link)
        {
            this.link = link;
        }

        //accessor of tv show
        public ShowNode getLink()
        {
            return link;
        }
    }

    private int size;
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
        if(showList == null)
        {
            System.out.println("Fatal error");
            System.exit(0);
        }

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


    public void addNode(TVShow tvShow)
    {
        ShowNode showNode = new ShowNode(tvShow, null);
        if (head == null)
        {
            head = showNode;
            size = 1;
        }
        else
        {
            ShowNode temp = head;
            while (temp.link != null)
            {
                temp = temp.link;
            }

            temp.link = showNode;
            size++;
        }
    }
    /*
    insert the node at the head of the list
     */
    public void addToStart(TVShow tvShow)
    {
        ShowNode showNode = new ShowNode(tvShow, getHead());
        setHead(showNode);
        size ++;
    }

    /*
    insert the node at the last of the list
     */
    public void addToLast(TVShow tvShow)
    {
        ShowNode showNode = new ShowNode(tvShow, null);

        if(head == null)
        {
            this.head = showNode;
            size = 1;
        }
        else
        {
            findLastNode().link = showNode;
            size ++;
        }
    }

    /*
    get the last node of the list
     */
    public ShowNode findLastNode()
    {
        ShowNode current = this.head;
        while (current.link != null)
        {
            current = current.link;
        }
        return current;
    }

    /*
    insert the node at the index position
     */
    public void insertAtIndex(TVShow tvShow, int index)
    {
        if(index < 0 || index > getSize() - 1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }

        if(index == 0)
        {
            addToStart(tvShow);
            size ++;
            return;
        }

        if(index == getSize() - 1)
        {
            addToLast(tvShow);
            size++;
            return;
        }

        ShowNode current = moveIndex(index);
        ShowNode showNode = new ShowNode();
        showNode = new ShowNode(tvShow, null);

        showNode.link = current.link;
        current.link = showNode;
        size++;
    }

    /*
    find the reference to the node at index - 1
     */
    public ShowNode moveIndex(int index)
    {
        ShowNode current = getHead();
        int count = 0;
        while(count != index - 1)
        {
            current = current.link;
            count++;
        }
        return current;
    }

    /*
    delete the node pointed to the index
     */
    public void deleteFromIndex(int index)
    {
        if(index < 0 || index > getSize() - 1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }

        if(this.head == null)
        {
            size = 0;
            return;
        }

        ShowNode temp = getNode(index);
        if(temp.link != null)
        {
            temp.tVShow = temp.link.tVShow;
            temp.link = temp.link.link;
        }
        else
        {
            //find the precursor node corresponding to the subscript
            ShowNode previousNode = getNode(index - 1);
            //set next for the precursor node to null
            previousNode.link = null;
        }
        size--;
    }

    public ShowNode getNode(int index)
    {
        if(index<0||index>size-1)
        {
            System.exit(0);
            throw new NoSuchElementException();
        }

        int location = 0;
        ShowNode temp = this.head;

        while(temp.link != null && location != index)
        {
            temp = temp.link;
            location++;
        }
        return temp;
    }

    /*
    delete the first node in the list
     */
    public void deleteFromStart()
    {
        if(head == null)
        {
            return;
        }
        else
        {
            head = head.link;
            size --;
        }
    }

    /*
    replace the object in the node at the passed index
     */
    public void replaceAtIndex(TVShow tvShow, int index)
    {
        if(index < 0 || index > getSize() - 1)
        {
            return;
        }
        ShowNode showNode = getNode(index);
        showNode.setTvShow(tvShow);
    }

    /*
    find show id in the list
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
                current = current.link;
                numberOfIteration ++;
            }
        }

        System.out.println("Not find the tv show, number of iteration is: " + numberOfIteration);
        return null;
    }

    /*
    accept show id and returns true and false on where has a tv show with the id or not
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
            current = current.link;
        }
        return false;
    }

    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        else if(getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            ShowList showList = (ShowList) object;
            if(getSize() != showList.getSize())
            {
                return false;
            }

            ShowNode position = getHead();
            ShowNode objectPosition = showList.getHead();

            while(position != null)
            {
                if(!(position.getTvShow().equals(objectPosition.getTvShow())))
                {
                    return false;
                }
                position = position.link;
                objectPosition = objectPosition.link;
            }

            return true;
        }
    }
}
