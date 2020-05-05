package softserve.sprint11;

//We have the class PrintStackTraceDemo with four methods: a, m, t, x.
//One of the methods of PrintStackTraceDemo throws IOException,
//the other one catches the exception and prints a stack trace.
//Please, fill in the gaps in the code of the PrintStackTraceDemo class so that the stack trace will remain the same.

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class PrintStackTraceDemo {
    public static void x() {
        try {
            a();
        } catch (IOException ioe) {//this way of stack trace output is workaround for moodle
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            ioe.printStackTrace(ps);
            System.out.println(byteArrayOutputStream);
        }
    }

    static void t() throws IOException {
        throw new IOException();
    }

    public static void a() throws IOException {
        m();
    }

    static void m() throws IOException {
        t();
    }
}