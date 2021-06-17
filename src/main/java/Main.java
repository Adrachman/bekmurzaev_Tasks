import calcLogic.*;
//import calcLogic.ClosedConsoleIOService;

public class Main {
    public static void main(String[] args) {
        ConsoleContext consoleContext = new ConsoleContext();
        IOService openedConsoleIOService =new OpenedConsoleIOService(consoleContext);
        openedConsoleIOService.out("hello");
        CalculatorService calculatorService = new CalculatorServiceImpl(openedConsoleIOService);
        calculatorService.multiply(5,2);
        calculatorService.addition(3,3);
        calculatorService.difference(8,2);
        calculatorService.division(4,2);
    }
}
