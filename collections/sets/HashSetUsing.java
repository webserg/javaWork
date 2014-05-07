package collections.sets;

import java.util.*;

class HashSetUsing {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Boo b1 = new Boo("1");
        Boo b2 = new Boo("2");

        Boo b3 = new Boo("3");
        Boo b4 = new Boo("4");
        Boo b5 = new Boo("5");

        LinkedHashSet<Boo> s = new LinkedHashSet<>();
        s.add(b1);
        s.add(b2);
        s.add(b3);
        s.add(b4);
        s.add(b5);
        s.add(null);
        s.add(null);

        s.add(null);

        System.out.println(s);
        //Collections.;
        try {
            for (Boo b : s) {
                if (b.name.equals("3")) s.remove(b);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("it was ConcurrentModificationException for each");
        }
        try {
            for (Iterator<Boo> it = s.iterator(); it.hasNext(); )
                if (Objects.equals(it.next(),b2))
                    it.remove();
        } catch (ConcurrentModificationException e) {
            System.out.println("it was ConcurrentModificationException iterator");
        }
        System.out.println(s);
        Set<Boo> ls = new HashSet<>();
        ls.addAll(s);
        ls.add(null);
        System.out.println(ls);

    }
}

class Sample {

    public String name;

    Sample(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boo) {
            if (this == obj) {
                return true;
            }
            return name.equals(((Boo) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }


}
