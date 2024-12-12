package com.MetodosNumericos.calculator.methods;

import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IExpr;

public class NewtonRaphsonMethod {

    public NewtonRaphsonMethod() {}

    public double newthonRpMethod(String function, double startPoint) {
        EvalUtilities util = new EvalUtilities(false, true);

        String evalFunction = function.replace("x", "" + startPoint);
        IExpr f_xiResult = util.evaluate(evalFunction);

        // Calculate 
        String derivative = "D(" + function + ", x)";
        IExpr derivativeExpr = util.evaluate(derivative);

        // Evaluate
        String evalDerivative = derivativeExpr.toString().replace("x", "" + startPoint);
        IExpr resultDerivative = util.evaluate(evalDerivative);

        double xiPlusOne = 0;
        double f_xi;
        double fder_xi;

        f_xi = Double.parseDouble(f_xiResult.toString());
        fder_xi = Double.parseDouble(resultDerivative.toString());

        xiPlusOne = startPoint - f_xi / fder_xi;

        for (int i = 0; i < 15; i++) {
            evalFunction = function.replace("x", "" + xiPlusOne);
            f_xiResult = util.evaluate(evalFunction);

            f_xi = Double.parseDouble(f_xiResult.toString().replace("*10^", "E"));

            evalDerivative = derivativeExpr.toString().replace("x", "" + xiPlusOne);
            resultDerivative = util.evaluate(evalDerivative);

            fder_xi = Double.parseDouble(resultDerivative.toString().replace("*10^", "E"));

            xiPlusOne = xiPlusOne - f_xi / fder_xi;
        }

        return xiPlusOne;
    }
	
}
