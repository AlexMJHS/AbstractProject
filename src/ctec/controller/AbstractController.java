package ctec.controller;

import java.util.ArrayList;
import myAbstract.model.EpicMemes;
import myAbstract.model.BottledWater;
import myAbstract.model.GoodFood;
import myAbstract.model.VideoGames;
import myAbstract.view.Frame;

public class AbstractController
{
	private ArrayList<LifeThings> lifeThings;
	private EpicMeme meme;
	private BottledWater water;
	private GoodFood food;
	private VideoGames games;
	private Frame baseFrame;
	
	public AbstractController()
	{
		baseFrame = new Frame(this);
		LifeThings = new ArrayList<LifeThings>();
		
		meme = new EpicMeme();
		water = new BottledWater();
		food = new GoodFood();
		games = new VideoGames();
		
		lifeThings.add(meme);
		lifeThings.add(water);
		lifeThings.add(food);
		lifeThings.add(games);
	}
	
	public void start()
	{
		for(int i = 0; i < lifeThings.size(); i++)
		{
			lifeThings.get(i).badMeme(2);
			lifeThings.get(i).badWater();
			lifeThings.get(i).badGames(3);
			lifeThings.get(i).badFood();
		}
	}
	
	public String showMemes()
	{
		String memeLevels = "";
		for(LifeThings current: lifeThings)
		{
			memeLevels += current.toString();
		}
		
		return memeLevels;
	}
	
	public String showGames()
	{
		String gameLevels = "";
		for(LifeThings current: lifeThings)
		{
			gameLevels += current.toString();
		}
		
		return gameLevels;
	}
	
	private void swap(int firstLocation, int secondLocation)
	{
		LifeThings temp = lifeThings.get(firstLocation);
		lifeThings.set(firstLocation, lifeThings.get(secondLocation));
		lifeThings.set(secondLocation, temp);
	}
	
	public void insertionSort()
	{
		for(int outerLoop = 1: outerLoop < lifeThings.size(); outerLoop++)
		{
			int innerLoop = outerLoop;
			while(innerLoop > 0 && lifeThings.get(innerLoop - 1).compareTo(lifeThings.get(innerLoop)) > 0)
			{
				swap(innerLoop, innerLoop-1);
				innerLoop--;
			}
		}
	}
	
	public void quickSort(int low, int high)
	
	{
		if(low < high)
		{
			int midPoint = partition(low, high);
			quickSort(low, midPoint- 1);
			quickSort(midPoint + 1, high);
		}
	}
	
	private int partition(int low, int high)
	{
		LifeThings pivot = lifeThings.get(high);
		int position = low;
		
		for(int spot = low; spot < high - 1; spot++)
		{
			if(lifeThings.get(spot).compareTo(pivot) <= 0)
			{
				swap(postion, spot);
				position++;
			}
		}
		swap(position, high);
		
		return position;
	}
	
}
