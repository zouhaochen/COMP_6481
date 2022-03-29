package Assignment3;

public class ShowList
{
    //inner class show node
    class ShowNode
    {
        private TVShow tVShow;
        private ShowNode showNode;

        //default constructor
        public ShowNode()
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


}
