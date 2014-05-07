package algoritms.microsoftTask;

import java.util.Comparator;
/**
 * @author Sergiy Doroshenko
 *
 */
public class ScheduleBuilder {
    private static final Comparator<CalendarNode> c = new CalendarNodeComparator();
    /**
     * 
     * @param root1
     * @param root2
     * @return CalendarNode root
     */
    public static CalendarNode merge(CalendarNode root1,CalendarNode root2){
        ChainIterator<CalendarNode> iter = new ChainIterator<CalendarNode>(null,null);
        CalendarNode tmp = null;
        while(root1 != null && root2 != null ){
            if(c.compare(root1,root2) < 0){
                tmp = root1;
                root1 = root1.getNext();
            }else if(c.compare(root1,root2) > 0){
                tmp = root2;
                root2 = root2.getNext();
            }else{
                tmp = CalendarNode.mergeNode(root1,root2);
                root1 = root1.getNext();
                root2 = root2.getNext();
            }
            iter.add(tmp);
        }
        while(root1 != null){
            tmp = root1;
            root1 = root1.getNext();
            iter.add(tmp);
       }
        
        while(root2 != null ){
            tmp = root2;
            root2 = root2.getNext();
            iter.add(tmp);        }
        
        return iter.getHead();
    }
}
