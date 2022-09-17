package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class Program {

	public static double avaragePrice(List<Product> list) {
		double tot = 0.0;
		for (Product p : list) {
			tot += p.getPrice();
		}
		return tot;
	}

	public static void main(String[] args) {

		String path = "D:\\Temp\\asdf.txt";
		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double value = Double.parseDouble(fields[1]);
				list.add(new Product(name, value));
				line = br.readLine();
			}
			//double sum = avaragePrice(list);
			double avaragePrice = list.stream().map(p -> p.getPrice())
					.reduce(0.0, (x,y) -> x + y) / list.size();

			//System.out.println("Avarage price: " + String.format("%.2f", sum / list.size()));
			System.out.println("Avarege price: " +String.format("%.2f", avaragePrice));
			
			list.forEach(System.out::println);

			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
