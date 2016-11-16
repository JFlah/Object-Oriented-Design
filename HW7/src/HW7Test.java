import java.util.*;

/**
 * Created by Jack on 11/7/2016.
 */
public class HW7Test {
    static Set<Variable> varSet = new HashSet<>();

    public static Set<Variable> getVarsExternal(Polynomial p) {
        Iterator<Polynomial> iter = p.iterator();
        while (iter.hasNext()) {
            Polynomial next = iter.next();
            if (next instanceof Variable) {
                Variable nextVar = (Variable) next;
                varSet.add(nextVar);
            }
            getVarsExternal(next);
        }
        return varSet;
    }

    public static Set<Variable> getVarsInternal(Polynomial p) {
        Set<Variable> varSet = new HashSet<>();
        p.traverse(poly -> {
            if (poly instanceof Variable) {
                Variable nextVar = (Variable) poly;
                varSet.add(nextVar);
            }
        });
        return varSet;
    }

    public static void main(String[] args) {
        Polynomial zero = new Number(0);
        Polynomial one = new Number(1);
        Polynomial three = new Number(3);
        Polynomial x = new Variable("x");
        Polynomial y = new Variable("y");
        Polynomial z = new Variable("z");

        Map<String, Integer> valMap = new HashMap<>();
        valMap.put("x", 3);
        valMap.put("y", 4);
        valMap.put("z", 5);

        // Poly 1
        Polynomial xT1 = new ProductOp(x, one);
        Polynomial xT1P3 = new PlusOp(xT1, three);
        Polynomial yP0 = new PlusOp(y, zero);
        Polynomial zT0 = new ProductOp(z, zero);
        Polynomial yP0PZT0 = new PlusOp(yP0, zT0);
        Polynomial poly1 = new ProductOp(xT1P3, yP0PZT0);

        System.out.println("Polynomial 1: " + poly1.toString());
        System.out.println("Evaluate(): " + poly1.evaluate(valMap));
        System.out.println("Reduce(): " + poly1.reduce().toString());
        System.out.println("getVarsExternal(): " + getVarsExternal(poly1).toString());
        System.out.println("getVarsInternal(): " + getVarsInternal(poly1).toString());

        // Poly 2
        Polynomial xP3 = new PlusOp(x, three);
        Polynomial xP3TY = new ProductOp(xP3, y);
        Polynomial zPX = new PlusOp(z, x);
        Polynomial xPZ = new PlusOp(x, z);
        Polynomial zPXMxPZ = new MinusOp(zPX, xPZ);
        Polynomial poly2 = new PlusOp(xP3TY, zPXMxPZ);

        System.out.println("\nPolynomial 2: " + poly2.toString());
        System.out.println("Evaluate(): " + poly2.evaluate(valMap));
        System.out.println("Reduce(): " + poly2.reduce().toString());
        System.out.println("getVarsExternal(): " + getVarsExternal(poly2).toString());
        System.out.println("getVarsInternal(): " + getVarsInternal(poly2).toString());
    }
}
