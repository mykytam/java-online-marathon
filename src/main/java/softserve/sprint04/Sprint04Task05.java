package softserve.sprint04;

import static java.lang.StrictMath.sqrt;

public class Sprint04Task05 {
    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int[] getXYPair() {
            int[] array= {x,y};
            return array;
        }

        public double distance(int x, int y) {
            return sqrt((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y));
        }

        public double distance(Point point) {
            return sqrt((this.x - point.x )*(this.x - point.x ) + (this.y - point.y)*(this.y - point.y));
        }

        public double distance() {
            return sqrt((this.x - 0)*(this.x - 0) + (this.y - 0)*(this.y - 0));
        }
    }
}
