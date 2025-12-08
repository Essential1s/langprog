import java.util.List;
import java.util.ArrayList;

class F1 {
	static double totalTime(List<Double> lapTimes) {
		lapTimes.remove(0);
		double sum = 0;
		for (double x: lapTimes) {
			sum += x;
		}
		return sum;
	}
	public static void main(String[] args) {
		List <Double> lapTimes = new ArrayList <> ();
		lapTimes.add(31.0); //прогревочный круг не учиывается
		lapTimes.add(29.0);
		lapTimes.add(21.1);
		lapTimes.add(21.3);

		System.out.printf("Общее время: %.1f c\n", totalTime(lapTimes));
	}
}
