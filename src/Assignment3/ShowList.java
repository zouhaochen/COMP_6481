package Assignment3;

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

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return size;
    }

    public void setHead(ShowNode head)
    {
        this.head = head;
    }

    public ShowNode getHead()
    {
        return head;
    }

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
}
