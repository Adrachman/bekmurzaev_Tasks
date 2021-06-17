package calcLogic;

public class CalculatorServiceImpl implements CalculatorService {
    private final IOService ioService;

    public CalculatorServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    public void multiply(Object d1, Object d2) {
        multiplyAndOutResult(d1,d2 );
    }

    public void addition(Object d1, Object d2) {
        additionAndOutResult(d1, d2);
    }

    public void difference(Object d1, Object d2) {
        differenceAndOutResult(d1, d2);
    }

    public void division(Object d1, Object d2) {
        divisionAndOutResult(d1, d2);
    }

    ////    public void longCalculations();
    private void multiplyAndOutResult(Object d1, Object d2) {
        ioService.out(String.format("%d * %d = %d", d1, d2, (Integer)d1 * (Integer)d2));
    }

    private void additionAndOutResult(Object d1, Object d2) {
        ioService.out(String.format("%d + %d = %d", d1, d2, (Integer)d1 + (Integer)d2));
    }

    private void differenceAndOutResult(Object d1, Object d2) {
        ioService.out(String.format("%d - %d = %d", d1, d2, (Integer)d1 - (Integer)d2));
    }

    private void divisionAndOutResult(Object d1, Object d2) {
        ioService.out(String.format("%d / %d = %d", d1, d2, (Integer)d1 / (Integer)d2));
    }

}
