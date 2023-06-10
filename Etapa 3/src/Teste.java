public class Teste {
	public static void main(String[] args) {
		StaticList<Integer> sl = new StaticList<>(5);
		StaticStack<Character> et3 = new StaticStack<>(5);
		
		//Testando método contaElementos
		sl.insert(1, 0);
		sl.insert(1, 1);
		sl.insert(1, 2);
		sl.insert(1, 3);
		sl.insert(3, 4);
		System.out.println(sl.contaElementos(1));
		System.out.println(sl.contaElementos(3));
		
		//Testando método checkBrackets
		et3.push('(');
		et3.push('A');
		et3.push('+');
		et3.push('B');
		et3.push(')');
		System.out.println(et3.checkBrackets(et3));
		et3.pop();
		et3.push('C');
		System.out.println(et3.checkBrackets(et3));
	}
}
