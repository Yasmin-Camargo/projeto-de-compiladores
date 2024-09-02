class Interpretador{
	int geraResult (ArvoreSintatica arv)
	{
		return (geraResult2(arv));
	}
	int geraResult2 (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return (geraResult2(((Mult) arv).arg1) * 
			geraResult2(((Mult) arv).arg2));

	if (arv instanceof Soma)
		return (geraResult2(((Soma) arv).arg1) + 
			geraResult2(((Soma) arv).arg2));

	if (arv instanceof Sub)
		return (geraResult2(((Sub) arv).arg1) - 
			geraResult2(((Sub) arv).arg2));

	if (arv instanceof Div)
		return (geraResult2(((Div) arv).arg1) / 
			geraResult2(((Div) arv).arg2));

	if (arv instanceof Num)
		return (((Num) arv).num);

	return 0;
	}
}
