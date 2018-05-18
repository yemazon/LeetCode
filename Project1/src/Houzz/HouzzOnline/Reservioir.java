//public void selectKitems(int[] stream, int k) {
//  int i=0;
//  int n = stream.length;
//  int[] reservoir = new int[k];
//  for(int i=0; i<k; i++) {
//    reservoir[i] = stream[i];
//  }
//  Random r = new Random();
//
//  // Iterate from the (k+1)th element to nth element
//  for(int i=k; i<n; i++) {
//
//    // Pick a random index from 0 to i.
//    int rand = r.nextInt(i+1);
//
//    // If the randomly  picked index is smaller than k, then replace
//    // the element present at the index with new element from stream
//    if(rand < k) {
//      resevior[rand] = stream[i];
//    }
//  }
//}