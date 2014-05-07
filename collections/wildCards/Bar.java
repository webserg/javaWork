package collections.wildCards;

import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:43:56 PM
 */
class Bar{
	static void doInsert(List<? super CC> list){
		list.add(new EE());

	}
}
