import java.util.Random;

public abstract class EquationGenerator {

    public static final Random      RAND = new Random();        // Random static permettant d'effectuer tous les aléatoires
    public static final int         BOUND = 9;                 // Limite des nombres à générer (entre 0 et 9 (BOUND - 1))

    private static final int        NB_EXP = 3;                 // Nombre d'expressions pouvant être instancié
    private static final int        MAX = 100;
    private static int[]            chances = {20, 50, 70, 90, 100};  // Tableau contenant le % de chance d'instanciation (0 = Plus, 1 = Times, 2 = Number) il doit être de la forme [x, x + y, x + y + z]
    
    // Change le tableau de chance d'instanciation si la somme du nouveau tableau est = CHANCE_SUM
    public static void initChances(int[] c) throws Exception
    {
        if(c.length == NB_EXP)
            System.arraycopy(c, 0, chances, 0, c.length);
        else
            throw new Exception("table length is not valid");
    }

    // génère une équation (arbre de type Exp)
    public static Exp generateExpression(int hmax) 
    {
        if(hmax <= 0)
        {
            return new Number(RAND.nextInt(BOUND) + 1);
        }
        else
        {
            int rand = RAND.nextInt(MAX);

            if(rand < chances[0])
            {
                return new Plus(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[1])
            {
                return new Times(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[2])
            {
                return new Minus(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[3])
            {
                return new Divide(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else
            {
                return new Number(RAND.nextInt(BOUND) + 1);
            }
        }
    }

    public static void putVariable(Exp tree)
    {
        if(RAND.nextBoolean())
        {
            if(tree.expLeft instanceof Number)
            {
                tree.expLeft = new Variable("x");
            }
            else
            {
                putVariable(tree.expLeft);
            }
            
        }
        else
        {
            if(tree.expRight instanceof Number)
            {
                tree.expRight = new Variable("x");
            }
            else
            {
                putVariable(tree.expRight);
            }
        }
    }

    public static Exp generateEquation(int hmax)
    {
        Exp eq = generateExpression(hmax);
        //putVariable(eq);
        return eq;
    }
}
