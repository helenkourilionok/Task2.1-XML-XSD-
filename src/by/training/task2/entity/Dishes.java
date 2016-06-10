package by.training.task2.entity;

import java.io.Serializable;
import java.util.List;

public class Dishes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5768807103171476732L;
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
	public void addFood(Food food)
	{
		listFood.add(food);
	}
	public void removeFood(Food food)
	{
		listFood.remove(food);
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listFood == null) ? 0 : listFood.hashCode());
		result = prime * result + ((nameListDishes == null) ? 0 : nameListDishes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dishes other = (Dishes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listFood == null) {
			if (other.listFood != null)
				return false;
		} else if (!listFood.equals(other.listFood))
			return false;
		if (nameListDishes == null) {
			if (other.nameListDishes != null)
				return false;
		} else if (!nameListDishes.equals(other.nameListDishes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dishes [id=" + id + ", nameListDishes=" + nameListDishes + ", listFood=" + listFood + "]";
	}

}
