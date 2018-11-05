//package tree.heap;

  import java.util.ArrayList;

  class BinaryHeap {

      ArrayList<Integer> heap;

      BinaryHeap () {
          heap = new ArrayList<Integer>();
      }

      /*
       * Continues to bubble values up the tree until we
       * find a node that is greater than it
       */
      public void bubbleUp (int index) {
          if (index == 0) {return;}

          int parent = getParent(index);

          if (heap.get(parent) < heap.get(index)) {
              Integer temp = heap.get(index);
              heap.set(index, heap.get(parent));
              heap.set(parent, temp);
              bubbleUp(parent);
          }

      }

      public void insert (Integer toInsert) {
          heap.add(toInsert);
          bubbleUp(heap.size() - 1);
      }

      // Traversal helpers
      public int getParent (int index) {
          return (index - 1) / 2;
      }

      public int getChild (int index, char child) {
          int result = (index * 2) + 1;
          if (child == 'R') {
              result++;
          }
          return result;
      }

      public void print () {
          for (int i = 0; i < heap.size(); i++) {
              System.out.println(heap.get(i));
          }
      }

      private void reheapify(int index){
          while(index >= 0 ){
              bubbleUp(index);
              index--;
          }
      }

      private BinaryHeap cloning(){
          BinaryHeap toReturn = new BinaryHeap();

          for (int i = 0; i < heap.size();i++){
              toReturn.insert(heap.get(i));
          }

          return toReturn;
      }

      public ArrayList<Integer> getSortedElements () {
          BinaryHeap holdingList = cloning();
          int index = holdingList.heap.size()-1;

          while(index >= 0){
              int temp = holdingList.heap.get(index);
              holdingList.heap.set(index,holdingList.heap.get(0));
              holdingList.heap.set(0,temp);

              holdingList.reheapify(index-1);
              index--;
          }

          return holdingList.heap;
      }

      public static void main(String[] args){
          BinaryHeap binHeap = new BinaryHeap();
          binHeap.insert(23);
          binHeap.insert(12);
          binHeap.insert(49);
          binHeap.insert(7);
          System.out.println("_____CURRENT HEAP_____");
          binHeap.print();
          binHeap.insert(54);
          binHeap.insert(78);
          System.out.println("");
          System.out.println("_____CURRENT HEAP_____");
          binHeap.print();
          System.out.println("\n______GET SORTED_____");
          System.out.println(binHeap.getSortedElements());
          System.out.println("\n_____CURRENT HEAP_____");
          binHeap.print();
      }

  }
