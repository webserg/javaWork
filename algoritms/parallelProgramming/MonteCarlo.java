package algoritms.parallelProgramming;

import java.util.Random;

/**
 * Created by webserg on 9/23/2016.
 * уществует много способов вычисления числа Пи. Самым простым и понятным является численный метод Монте-Карло, суть
 * которого сводится к простейшему перебору точек на площади. Суть расчета заключается в том, что мы берем квадрат со стороной a = 2 R,
 * вписываем в него круг радиусом R. И начинаем наугад ставить точки внутри квадрата. Геометрически, вероятность P1 того, чтот точка
 * попадет в круг, равна отношению площадей круга и квадрата:
 * P1=Sкруг / Sквадрата = πR2 / a 2 = πR2 / (2 R ) 2= πR2 / (2 R) 2 = π / 4 (1)
 * <p>
 * Вероятность попадания точки в круг можно также посчитать после численного эксперимента ещё проще: посчитать количество точек,
 * попавших в круг, и поделить их на общее количество поставленных точек:
 * P2=Nпопавших в круг / Nточек; (2)
 * Так, при большом количестве точек в численном эксперименте вероятности должны вести себя cледующим образом:
 * lim(Nточек→∞)⁡(P2-P1)=0; (3)
 * Следовательно:
 * π / 4 = Nпопавших в круг / Nточек; (4)
 * π =4 Nпопавших в круг / Nточек; (5)
 */
public class MonteCarlo {
    public static void main(String[] args) {
        MonteCarlo monteCarlo = new MonteCarlo();
        double pi = monteCarlo.monteCarlo(100000000);
        System.out.println(pi);
    }

    private double monteCarlo(long iter) {
        return 4.0 * (double) mcCount(iter) / iter;
    }

    private int mcCount(long iter) {
        int hit = 0, i = 0;
        Random randomX = new Random();
        Random randomY = new Random();
        while (i++ < iter){
            if (isInCircle(randomX.nextDouble(), randomY.nextDouble(), 1)) {
                hit++;
            }
        }
        return hit;
    }

    private boolean isInCircle(double x, double y, double r) {
        return y * y + x * x < r * r;
    }
}
