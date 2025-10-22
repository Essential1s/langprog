class Gen<T> {

	T ob;
	Gen(T o) {
		ob = o;
	}

	T getOb() {
		return ob;
	}
	void showType() {
		System.out.println("Object type: " + ob.getClass().getName());
	}
}
class TwoGen<T, V> {

	T ob1;
	V ob2;
	TwoGen(T o1, V o2) {
		ob1 = o1;
		ob2 = o2;
	}

	T getOb1() {
		return ob1;
	}
	V getOb2() {
		return ob2;
	}
	void showTypes() {
		System.out.println("Object type: " + ob1.getClass().getName());
		System.out.println("Object type: " + ob2.getClass().getName());
	}
}

class pr001 {
	public static void main(String[] args) {
		Gen<String> strOb = new Gen<String>("один обобщённый тип");
		String str = strOb.getOb();
		System.out.println("значение обобщенного типа с одним параметром" + str);
		TwoGen<Integer, String> tgOb;
		tgOb = new TwoGen<Integer, String>(67, "dior sauvage");
		tgOb.showTypes();
		int v = tgOb.getOb1();
		System.out.println("Value: " + v);

		System.out.println();

		str = tgOb.getOb2();

		System.out.println("значение в переменной str: " + str);
	}
}
