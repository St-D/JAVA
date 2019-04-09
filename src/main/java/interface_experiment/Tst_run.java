package interface_experiment;

import interface_experiment.Tst_cls;
import interface_experiment.Tst_implement;
import interface_experiment.Tst_inter;

public class Tst_run {
    public static void main(String[] Args){

        Tst_inter c = new Tst_implement();

        Tst_cls cc = new Tst_implement();

        ((Tst_implement) c).ret_neth();
        c.t_method_return_five();
        ((Tst_implement) c).tst_method();

        System.out.println("~~~~~~~~~~~~~~~~~");

        cc.ret_neth();
        ((Tst_implement) cc).t_method_return_five();
        cc.tst_method();


    }
}
