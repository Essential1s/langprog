//обобщенные типфы
class NumFns<T extends Number> {
	T num;
	NumFns(T n) {
		num = n;

	}
	//get inverse value of num
	double inverse() {
		return 1/num.doubleValue();
	}
	//whole part ofnum
	int whole() {
		return num.intValue();
	}
	//double part of num
	double dr() {
		return num.doubleValue() - num.intValue();
	}

}
class pr002 {
	public static void main(String args[]) {
		NumFns<Integer> iOb = new NumFns<Integer>(5);

		System.out.println("обратная величина: " + iOb.inverse());

		System.out.println("целая часть: " + iOb.whole());

		System.out.println("Дробная часть: " + iOb.dr());

		NumFns<Double> dOb = new NumFns<Double>(10.14);
		
		System.out.println("обратная величина: " + dOb.inverse());

		System.out.println("целая часть: " + dOb.whole());

		System.out.println("Дробная часть: " + dOb.dr());

		//NumFns<String> strOb = new NumFns<String>("bl")
		//string не является классом совместимым с Number
	}
}
