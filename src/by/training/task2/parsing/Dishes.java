package by.training.task2.parsing;

import java.util.List;
import by.training.task2.parsing.Food;

public class Dishes {
	private String id;
	private String nameListDishes;
	private List<Food> listFood;
	public Dishes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dishes(String id, String nameListDishes, List<Food> listFood) {
		super();
		this.id = id;
		this.nameListDishes = nameListDishes;
		this.listFood = listFood;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameListDishes() {
		return nameListDishes;
	}
	public void setNameListDishes(String nameListDishes) {
		this.nameListDishes = nameListDishes;
	}
	public List<Food> getListFood() {
		return listFood;
	}
	public void setListFood(List<Food> listFood) {
		this.listFood = listFood;
	}

}
