package leetcode.queue;

import java.util.*;

public class OpenLock {

   public int openLock(String[] deadends, String target) {

       Set<String> visited = new HashSet<>(Arrays.asList(deadends));
       Queue<String> queue = new LinkedList<>();

       int level = 0;
       String Start = "0000";

       queue.offer(Start);

       while(!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i< size; i ++) {
               String currentLock = queue.poll();
               if(!visited.add(currentLock)) continue;
               if(currentLock.equals(target)) return level;
               for(String lock : getNextSeries(currentLock) ) {
                  if(!visited.contains(lock)) queue.offer(lock);
               }
           }
           level++;
       }
       return -1;
   }

   public List<String> getNextSeries(String lock) {
       List<String> nextSeq = new ArrayList<>();
       char[] lockArr = lock.toCharArray();

       for(int i=0; i<lockArr.length; i++) {
           char l = lockArr[i];
           lockArr[i] = l == '9' ? '0' : (char) (l + (char) 1);
           nextSeq.add(String.valueOf(lockArr));

           lockArr[i] = l == '0' ? '9' : (char) ( l - (char) 1);
           nextSeq.add(String.valueOf(lockArr));

           // why?
           lockArr[i] = l;

       }

       return nextSeq;
   }

    public static void main(String[] args) {

       String target = "0202";

       String[] deadEnds = {"0201","0101","0102","1212","2002"};

        OpenLock lock = new OpenLock();
        int shortestPath = lock.openLock(deadEnds, target);

        System.out.println("Shortest Path for the lock to open: "+ shortestPath);
    }
}
