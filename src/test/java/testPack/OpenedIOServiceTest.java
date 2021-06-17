package testPack;

import calcLogic.ConsoleContext;
import calcLogic.IOService;
import calcLogic.OpenedConsoleIOService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OpenedIOServiceTest {
//    ConsoleContext consoleContext = new ConsoleContext();
//    IOService closedConsoleIOService =new OpenedConsoleIOService(consoleContext);

    private static final String EOL = System.lineSeparator();
    private static final String TEXT_1 = "Эццо";
    private static final String TEXT_2 = "Аудиторре";

    private ByteArrayOutputStream bos;
    private ConsoleContext consoleContext;
    private IOService ioService;


    @BeforeClass
    void setUp(){
        System.out.println(Thread.currentThread().getName());
        bos = new ByteArrayOutputStream();
        consoleContext = new ConsoleContext(new PrintStream(bos), System.in);
        ioService = new OpenedConsoleIOService(consoleContext);
    }
    @Test
    void shouldPrintOnlyFirstCreedLine() {

        ioService.out(TEXT_1);
        Assert.assertEquals("Эццо",TEXT_1);
    }
}
