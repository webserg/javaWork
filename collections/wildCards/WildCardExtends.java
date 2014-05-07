package collections.wildCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:43:36 PM
 */
public class WildCardExtends {

    /**
     * @param ts
     */
    public static <T> void main(String... ts) {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new CatA());
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird());
        List<? super Bird> birds2 = new ArrayList<LiveBeen>();
        birds2.add(new Bird());
        birds2.add(new Tit());
        //birds2 = birds;
        //		birds2.add(new Animal());
        System.out.println(birds2.toString());

        List<? extends Bird> birds3 = new ArrayList<Tit>();
        List<Tit> birds4 = new ArrayList<Tit>();
        //		birds3.add(new Bird());
        birds4.add(new Tit());
        birds3 = birds4;
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        l.add(new ArrayList<Integer>());
        WildCardExtends.use(birds);

        List<LiveBeen> beans = new ArrayList<LiveBeen>();
        beans.add(new LiveBeen());
        WildCardExtends.<LiveBeen>copyToEnd(beans, birds);
        System.out.println(beans);
        List animals2 = new ArrayList();
        animals2.add(new CatA());
        WildCardExtends.<LiveBeen>copyToEnd(animals2, birds);
        System.out.println(animals2);

        WildCardExtends.printList(beans);
        WildCardExtends.printList(animals);
        printList(animals2);
    }

    public static void use(List<? extends LiveBeen> a) {
        System.out.println(a.toString());

    }

    public static <T> void copyToEnd(List<? super T> dist, List<? extends T> src) {
        for (T t : src) {
            dist.add(t);
        }
            System.out.println("inside" + dist.get(0));
            System.out.println("inside" + dist.get(1));


    }

//    <T> void printList(List<T> list){
//        for(T t : list){
//            System.out.println(t);
//        }
//    }

    static void printList(List<? extends LiveBeen> list){
        for(LiveBeen t : list){
            System.out.println(t);
        }
    }

}

class CatA extends Animal {
    String name = "Cat";

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Cat");
        sb.append("{name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}