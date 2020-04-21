package softserve.sprint07;

// Using anonymous classes concept, call the execute method 4 times with different strategy

interface Strategy {
    double doOperation(int a, int b);
}

class Methods {

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        };
        execute(a, b, strategy);
    }

    public static void subtractBfromA(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        };
        execute(a, b, strategy);
    }

    public static void multiplyAbyB(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        };
        execute(a, b, strategy);
    }

    public static void divideAbyB(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a / b;
            }
        };
        execute(a, b, strategy);
    }
}

