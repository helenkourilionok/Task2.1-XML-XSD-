package by.training.task2.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.SAXException;

public class DOM {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
			DOMParser parser = new DOMParser();
			parser.parse("src/by/training/task2/xml/menu.xml");
			Document document = parser.getDocument();
			Element root = document.getDocumentElement();
			List<Dishes> listDishes = new ArrayList<Dishes>();
			NodeList disheNodes = root.getElementsByTagName("list-dishes");
			Dishes dishes = null;
			for(int i = 0;i<disheNodes.getLength();i++)
			{
				dishes = new Dishes();
				Element dishElement = (Element)disheNodes.item(i);
				dishes.setId(dishElement.getAttribute("id"));
				dishes.setNameListDishes(dishElement.getAttribute("nameListDishes"));
				dishes.setListFood(getListChild(dishElement,"food"));
				listDishes.add(dishes);
			}
			for(Dishes d: listDishes)
			{
				System.out.println(d.getId()+"--"+d.getNameListDishes());
				showFoodes(d.getListFood());
			}
	}
	
 	private static List<Food> getListChild(Element element,String childname)
	{
		NodeList childList = element.getElementsByTagName(childname);
		List<Food> foodes = new ArrayList<Food>();
		Food food = null;
		for(int i = 0;i<childList.getLength();i++)
		{
				food = new Food();
				Element foodElement = (Element)childList.item(i);
				food.setId(foodElement.getAttribute("id"));
				food.setName(getSingleElement(foodElement, "name").getTextContent());
				food.setDescription(getSingleElement(foodElement, "description").getTextContent());
				food.setPortion(getSingleElement(foodElement, "portion").getTextContent());
				food.setPrice(Integer.parseInt(getSingleElement(foodElement, "price").getTextContent()));
				foodes.add(food);
		}
		return foodes;
	}
	
	private static Element getSingleElement(Element element,String childname)
	{
		NodeList nlist = element.getElementsByTagName(childname);
		return (Element)nlist.item(0);
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
