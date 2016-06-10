package by.training.task2.parser;

import java.util.List;

import by.training.task2.entity.Dishes;
import by.training.task2.entity.Food;
import by.training.task2.service.ReadXML;

public class DOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath = "src/by/training/task2/xml/menu.xml";
		List<Dishes> listDishes = ReadXML.readXML(xmlPath);
		for(Dishes d: listDishes)
		{
			System.out.println(d.getId()+"--"+d.getNameListDishes());
			showFoodes(d.getListFood());
		}
	}
	
	private static void showFoodes(List<Food> foodes)
	{
		for(Food food:foodes)
		{
			System.out.println("     ---"+food.getId()+")"+food.getName());
			System.out.println("       ---"+food.getDescription());
			System.out.println("       ---"+food.getPortion()+"(דנאלל)");
			System.out.println("       ---"+food.getPrice()+"$");
		}
	}
}
