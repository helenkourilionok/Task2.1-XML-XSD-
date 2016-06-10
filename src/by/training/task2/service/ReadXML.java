package by.training.task2.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.task2.entity.Dishes;
import by.training.task2.entity.Food;

public class ReadXML {
	public static  List<Dishes> readXML(String xmlPath)
	{
		DOMParser parser = new DOMParser();
		Document document = null;
		Element root = null;
		List<Dishes> listDishes = null;
		NodeList disheNodes = null;
		String tagName = "list-dishes";
		try {
			parser.parse(xmlPath);
			document = parser.getDocument();
			root = document.getDocumentElement();
			disheNodes = root.getElementsByTagName(tagName);
			listDishes = createListDishes(disheNodes);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listDishes;
	}
	
	private static List<Dishes> createListDishes(NodeList disheNodes)
	{
		String attrNameId = "id";
		String attrNameLD = "nameListDishes";
		String tagNameChildEl = "food";
		Dishes dishes = null;
		List<Dishes> listDishes = new ArrayList<Dishes>();
		for(int i = 0;i<disheNodes.getLength();i++)
		{
			dishes = new Dishes();
			Element dishElement = (Element)disheNodes.item(i);
			dishes.setId(dishElement.getAttribute(attrNameId));
			dishes.setNameListDishes(dishElement.getAttribute(attrNameLD));
			dishes.setListFood(getListChild(dishElement,tagNameChildEl));
			listDishes.add(dishes);
		}
		return listDishes;
	}
	
	private static List<Food> getListChild(Element element,String childname)
	{
		String attrIdFood = "id";
		String elFoodName = "name";
		String elFoodDescription = "description";
		String elFoodPortion = "portion";
		String elFoodPrice = "price";
		NodeList childList = element.getElementsByTagName(childname);
		List<Food> foodes = new ArrayList<Food>();
		Food food = null;
		for(int i = 0;i<childList.getLength();i++)
		{
				food = new Food();
				Element foodElement = (Element)childList.item(i);
				food.setId(foodElement.getAttribute(attrIdFood));
				food.setName(getSingleElement(foodElement,elFoodName).getTextContent());
				food.setDescription(getSingleElement(foodElement,elFoodDescription).getTextContent());
				food.setPortion(getSingleElement(foodElement,elFoodPortion).getTextContent());
				food.setPrice(Integer.parseInt(getSingleElement(foodElement,elFoodPrice).getTextContent()));
				foodes.add(food);
		}
		return foodes;
	}
	
	private static Element getSingleElement(Element element,String childname)
	{
		NodeList nlist = element.getElementsByTagName(childname);
		return (Element)nlist.item(0);
	}
	
}
