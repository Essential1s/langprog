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
	//целое part ofnum
	int whole() {
		return num.intValue();
	}
	//double part of num
	double dr() {
		return num.doubleValue() - num.intValue();
	}
	//использование шаблонов аргументов 
	 boolean absEqual (NumFns<?> ob) {
		 if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()))
			return true;
		 	return false;
		}


}


class A <T, V extends T> {
	T first;
	V second;

	A(T a, V b) {
		first = a;
		second = b;
	}
}

class B{
	//родительский класс
}
class B_A extends B {
}
class B_B extends B {
}
class B_C extends B {
}
class BA {
	//самостоятельный класс
}
class Gen1<T> {
	T ob;

	Gen1(T o) {
		ob = o;
	}
}
class Test {
	static void test(Gen1 <? extends B> o) {	
	}
	static void test2(Gen1 <? super B_A> o) {
	}
}

class GenMeth {
	//метод определяющий совпадает ли содержимое двух массивов
	static <T extends Comparable<T>, V extends T> boolean arrayEqual(T[] x, V[] y) {
		//сравнение длины массивов
		if (x.length != y.length) 
			return false;
	       for(int i=0; i < x.length; i++)
	       		if(!x[i].equals(y[i]))
		 		return false;
		return true;	       
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

		//проверка совместимости типов при создании объектов класса A

		A<Integer, Integer> x = new A<Integer, Integer>(1, 2);
		A<Number, Integer> y = new A<Number, Integer>(1.1, 2);
		
		//демонстрация вызова метода absEqual

		NumFns<Integer> intOb = new NumFns<Integer>(6);
		NumFns<Double> doubleOb = new NumFns<Double>(6.0);
		NumFns<Long> longOb = new NumFns<Long>(5L);
		
		System.out.println();
		System.out.println("сравнение абсолютных значение int и double: ");

		if(intOb.absEqual(doubleOb))
		       	System.out.println("абсолютные величины совпадают");
		else
			System.out.println("абсолютные величины не совпадают");
		
		System.out.println();
		System.out.println("сравнение абсолютных значение int и long: ");

		if(intOb.absEqual(longOb))
		       	System.out.println("абсолютные величины совпадают");
		else
			System.out.println("абсолютные величины не совпадают");
		//демонстрация использования ограниченных шаблонов
		
		B b1 = new B();
		B_A b2 = new B_A();
		B_B b3 = new B_B();
		B_C b4 = new B_C();
		BA ba1 = new BA();
		Gen1<B> w1 = new Gen1<B>(b1);
		Gen1<B_A> v2 = new Gen1<B_A>(b2);
		Gen1<B_B> v3 = new Gen1<B_B>(b3);
		Gen1<B_C> v4 = new Gen1<B_C>(b4);
		Gen1<BA> v5 = new Gen1<BA>(ba1);

		//тип параметра при вызове статического метода test() ограничивается шаблоном
		Test.test(w1);
		Test.test(v2);
		Test.test(v3);
		Test.test(v4);

		//Test.test(v5); не скомпилируется в связи с тем что v5 имеет тип не являющийся родственным классу B:

		//демонстрация использования обобщенного метода arraysEqual() определенного в классе GenMeth

		Integer nums[] = {1, 2, 3, 4, 5};
		Integer nums2[] = {1, 2, 3, 4, 5};
		Integer nums3[] = {1,2, 7, 4, 5};
		Integer nums4[] = {1, 2, 3, 7, 5, 6};

		System.out.println();

		if(GenMeth.arrayEqual(nums, nums))
			System.out.println("массив nums совпадает сам с собой");
		
		if(GenMeth.arrayEqual(nums, nums2))
			System.out.println("массив nums совпадает с nums2");

		if(GenMeth.arrayEqual(nums, nums3))
			System.out.println("массив nums совпадает с nums3");
		
		if(GenMeth.arrayEqual(nums, nums4))
			System.out.println("массив nums совпадает с nums4");
		
	}
}
