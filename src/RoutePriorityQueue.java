import java.util.ArrayList;
/**
* 
 * @author bregerka
*
* @param <T>
*/
public class RoutePriorityQueue<Object> extends ArrayList<Object>{
       private static final long serialVersionUID = 1L;
       int size;
       
       public RoutePriorityQueue(){
             this.size = 0 ;
       }
       
       public boolean add(Object value) {
             if(value == null) throw new NullPointerException();
             boolean b;
             b = super.add(value);
             if(super.size()>1){
                    percolateUp(super.size()-1);
             }
             return b;    
       }
       
       /**
       * Resorts the queue after an element is removed
       * @param spot
       */
       public void percolateDown(int spot) {
             if (spot != super.size() - 1) {
                    
                           int lspot = ((spot + 1) * 2) - 1;
                           int rspot = (spot + 1) * 2;
                           if (rspot <= super.size() - 1) {
                           Route lelement = (Route) super.get(lspot);
                           Route relement = (Route) super.get(rspot);
                           Route element = (Route) super.get(spot);

                           if (element.compareTo(lelement) == 1
                                        || element.compareTo(relement) == 1) {
                                 int check = relement.compareTo(lelement);
                                 if (relement.getCost() < lelement.getCost()) {
                                        super.set(spot, (Object) relement);
                                        super.set(rspot, (Object) element);
                                        percolateDown(rspot);
                                 } else if (relement.getCost() > lelement.getCost()) {
                                        super.set(spot, (Object) lelement);
                                        super.set(lspot, (Object) element);
                                        percolateDown(lspot);
                                 } else {
                                        return;
                                 }

                           }
                    }
             }

       }
       
       
       
       /**
       * Resorts the list after an element is added
       * @param index
       */
       public void percolateUp(int index) {

             int parentIndex = ((index / 2) + (index % 2) - 1);
             Route parent = (Route) super.get(parentIndex);
             if (parent.getCost() > ((Route) super.get(index)).getCost()) {
                    super.set(parentIndex, super.get(index));
                    super.set(index, (Object) parent);
                    if (parentIndex > 0)
                           percolateUp(parentIndex);
             }
       }
       /**
       * Changes queue to an Array
       */
       public Object[] toArray() {
             return (Object[]) super.toArray();
       }
       /**
       * Adds a value to the queue
       * @param value
       * @return boolean
       */
       public boolean offer(Object value) {
             return this.add(value);
       }
       /**
       * Looks at the first element
       * @return the first element
       */
       public Object peek() {
             if(super.size() == 0) return null;
             return super.get(0);
       }
       /**
       * Clear the entire queue
       */
       public void clear() {
             super.clear();
       }
       /**
       * Returns if the value is contained in the queue
       * @param value
       * @return true if it is in the queue, false if not
       */
       public boolean contains1(Object value) {
             int contains = super.indexOf(value);
             if(contains == -1) return false;
             return true;
       }
       /**
       * returns the size of the queue
       */
       public int size() {
             return super.size();
       }
       /**
       * Puts the queue in an Array
       * @param numbers
       * @return
       */
       public Object[] toArray1(Object[] numbers) {
             return super.toArray(numbers);
       }
       /**
       * Removes the head of the queue
       * @return head of the queue
       */
       public Object poll() {
             if(super.size() == 0) return null;
             if(super.size()>2)
             {
                    Object temp1= super.get(1);
                    super.set(1,super.get(2));
                    super.set(2,temp1);
             }
             Object temp2 = super.get(0);
             this.remove(temp2);
             return temp2;
       }
       /**
       * Removes the first element and then reorders
       * @param value
       * @return
       */
       public boolean remove1(Object value) {
             if(value == null) throw new NullPointerException();
             int savedSpot = super.indexOf(value);
             if(savedSpot == -1) return false;
             super.set(savedSpot, super.get(super.size() - 1));
             super.remove(super.size() - 1);
             if(super.size()>1){
                    percolateDown(savedSpot);
             }
             return true; 
       }
       
}
