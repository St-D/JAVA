package interface_experiment;

public class Tst_implement extends Tst_cls implements Tst_inter {

    @Override
    public void tst_method() {
        System.out.println("run tst_method from abstract class");

    }

    @Override
    public void t_method_return_five() {
        System.out.println("return " + 5);

    }

    @Override
    public void ret_neth() {
        super.ret_neth();
        System.out.println("  HW ещё раз");
    }
}
