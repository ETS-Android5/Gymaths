public class Operator extends Exp {
    /*
        Il serait bien plus cohérent de rendre
        cette classe abstraite pour des raisons 
        d'implémentations, cependant, pour pouvoir
        comparer les types avec les arbres de re-
        férence, il est nécessaire que cette classe
        soit instanciable.
        - FIXME: Comme pour le cas de la classe
        Ignored, il faudrait faire une classe qui 
        est instanciable et qui correspond à tous
        les opérateurs uniquement. 
        Vincent toi qui regarde ce délice, sache
        que je ne suis pas fier.
    */

    public Operator(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

	public Operator opposite()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Exp copy() {
        throw new UnsupportedOperationException();
    }

    @Override
    public float evaluate() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Exp simplify() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toLatex() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toLatexTree() {
        throw new UnsupportedOperationException();
    }
    
}