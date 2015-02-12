package org.gfbio;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair>{
	public int compare(Pair p1, Pair p2)
    {
       return p1.getFirst().compareTo(p2.getFirst());
   }

}
