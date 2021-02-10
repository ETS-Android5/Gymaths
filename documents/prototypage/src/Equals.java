public class Equals extends Exp {
	private static final Exp equals_cl = new Equals(new Operator(new Ignored(), new Ignored()), new Ignored());

	public Equals(Exp expLeft, Exp expRight) {
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Equals(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public float evaluate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	public void clRotateRight()
	{
		if(this.expLeft != null && this.expLeft instanceof Operator)
		{
			Operator p = ((Operator) this.expLeft).opposite(); // créer la méthode qui génère l'opérateur opposé
			Exp u = p.expLeft;
			Exp v = p.expRight;
			Exp w = this.expRight;

			p.setBoth(w, v);
			this.setBoth(u, p);
		}
	}

	// TODO This
	@Override
	public Exp simplify() {
		if (EquationSimplificator.matchWith(this, equals_cl))
		{
			this.clRotateRight();
			return this;
		}
		else
		{
			return new Equals(this.expLeft.simplify(), this.expRight.simplify());
		}

	}

	@Override
	public String toLatexTree() {
		return String.format("[.= %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}

}
