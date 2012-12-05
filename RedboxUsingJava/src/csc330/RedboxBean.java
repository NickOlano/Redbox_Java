/*
 * RedboxBean.java
 * (c) Jeff Stern and Nick Olano, 2012
 * October 30, 2012
 */

package csc330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.faces.model.SelectItem;

/**
 * @author jeffreyStern and nicholasOlano
 *
 */
public class RedboxBean {
	private String movieShown;
	private String selectedRating = "All Ratings";
	private String selectedSort = "Release Date";
	private String selectedGenre = "All";
	private ArrayList <String> grid;
	private Movie currentMovieObject;
	
	/**
	 * Setters and Getters
	 */
	
	public String getMovieShown() {
		return movieShown;
	}
	
	public String getMovieShownTitle() {
		return currentMovieObject.getTitle();
	}
	
	public String getMovieShownRate() {
		return currentMovieObject.getRate();
	}
	
	public String getMovieShownRating() {
		return "" + currentMovieObject.getRating();
	}
	
	public String getMovieShownTime() {
		return currentMovieObject.getRunningTime();
	}
	
	public String getMovieShownDescription() {
		return currentMovieObject.getDescription();
	}
	
	public ArrayList<String> getMovieShownGenres() {
		return currentMovieObject.getGenres();
	}
	
	public ArrayList<String> getMovieShownStarring() {
		return currentMovieObject.getActors();
	}
	
	public ArrayList<String> getMovieShownDirectors() {
		return currentMovieObject.getDirectors();
	}
	
	public String getMovieShownStudio() {
		return currentMovieObject.getStudio();
	}
	
	public ArrayList<String> getMovieShownSubtitles() {
		return currentMovieObject.getSubtitles();
	}
	
	public String getMovieShownFormat() {
		return currentMovieObject.getFormat();
	}
	
	public void setMovieShown(String movieShown) {
				for (Movie movie : allMovies){
			if (movie.getImagePath() == movieShown) {
				currentMovieObject = movie;
			}
		}
				this.movieShown = movieShown;
	}
	public String getSelectedSort() {
		return selectedSort;
	}

	public void setSelectedSort(String selectedSort) {
		this.selectedSort = selectedSort;
	}

	public String getSelectedRating() {
		return selectedRating;
	}

	public void setSelectedRating(String selectedRating) {
		this.selectedRating = selectedRating;
	}
	
	public ArrayList<String> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<String> grid) {
		this.grid = grid;
	}

	public String getSelectedGenre() {
		return selectedGenre;
	}

	public void setSelectedGenre(String selectedGenre) {
		this.selectedGenre = selectedGenre;
	}
	
	public SelectItem[] getRatingsSelection() {
		return ratingsSelection;
	}

	public void setRatingsSelection(SelectItem[] ratingsSelection) {
		this.ratingsSelection = ratingsSelection;
	}

	public SelectItem[] getSortSelection() {
		return sortSelection;
	}

	public void setSortSelection(SelectItem[] sortSelection) {
		this.sortSelection = sortSelection;
	}

	
	/**
	 * Determines if the selected genre is the same as the current genre
	 * @param genre
	 * @return true or false
	 */
	public boolean isActive(String genre) {
		if (selectedGenre.equals(genre)) return true;
		else return false;
	}
	/**
	 * Selects the genre foe which movies need to be displayed
	 */
	public void action() {
		selectedGenre = "Action";
		filterCovers();
	}
	public void comedy() {
		selectedGenre = "Comedy";
		filterCovers();
	}
	public void drama() {
		selectedGenre = "Drama";
		filterCovers();
	}
	public void family() {
		selectedGenre = "Family";
		filterCovers();
	}
	public void horror() {
		selectedGenre = "Horror";
		filterCovers();
	}
	public void all() {
		selectedGenre = "All";	
		filterCovers();
	}

	
/**
 * Creates all our movie instances
 */
	Movie247Degrees movie1 = new Movie247Degrees();
	Movie4321 movie2 = new Movie4321();
	MovieAfterDuskTheyCame movie3 = new MovieAfterDuskTheyCame();
	MovieAirborne movie4 = new MovieAirborne();
	MovieBattleShip movie5 = new MovieBattleShip();
	MovieCleanskin movie6 = new MovieCleanskin();
	MovieDarkShadows movie7 = new MovieDarkShadows();
	MovieForTheLoveOfMoney movie8 = new MovieForTheLoveOfMoney();
	MovieFreelancers movie9 = new MovieFreelancers();
	MovieOneInTheChamber movie10 = new MovieOneInTheChamber();
	MovieOnTheInside movie11 = new MovieOnTheInside();
	MovieParanormalActivity3 movie12 = new MovieParanormalActivity3();
	MoviePeopleLikeUs movie13 = new MoviePeopleLikeUs();
	MovieSnowWhite movie14 = new MovieSnowWhite();
	MovieSuperCyclone movie15 = new MovieSuperCyclone();
	MovieTheLorax movie16 = new MovieTheLorax();
	MovieTheDictator movie17 = new MovieTheDictator();
	MovieTropicThunder movie18 = new MovieTropicThunder();
	MovieUnknown movie19 = new MovieUnknown();
	MovieCabinInTheWoods movie20 = new MovieCabinInTheWoods();
	MovieHunter movie21 = new MovieHunter();
	MovieAvengers movie22 = new MovieAvengers();
	MovieSpaceDogs movie23 = new MovieSpaceDogs();
	MovieFlicka3 movie24 = new MovieFlicka3();
	MovieCowgirlsNAngels movie25 = new MovieCowgirlsNAngels();
	
	/**
	 * Creates an Array List of all our movie objects
	 */
	ArrayList<Movie> allMovies = new ArrayList<Movie>(Arrays.asList(movie1,
			movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9,
			movie10, movie11, movie12, movie13, movie14, movie15, movie16,
			movie17, movie18, movie19, movie20, movie21, movie22, movie23,
			movie24, movie25));
	
	/**
	 * All of our ratings for the dropdown list
	 */
	private SelectItem[] ratingsSelection = {
			new SelectItem("All Ratings"),
			new SelectItem("G"),
			new SelectItem("PG"),
			new SelectItem("PG-13"),
			new SelectItem("R"),
			new SelectItem("NR")
	};

	/**
	 * Release Date and Alphabetical sort options. Our list is filled from here
	 */
	private SelectItem[] sortSelection = {
			new SelectItem("Release Date"),
			new SelectItem("Alphabetical")
	};

	/**
	 * Filters all the movies and sorts them depending on what the user 
	 * selected and then returns an Array List with all the movies images path
	 * 
	 * @return ArrayList of the movies images paths
	 */
	public ArrayList<String> filterCovers(){
	
		/* Sorts alphabetical or rating */
		if(getSelectedSort().equals("Alphabetical")){
			allMovies = bubblesrt(allMovies, "alpha");
		}
		else{
			allMovies = bubblesrt(allMovies, "release");
		}
		
		/* Filters rating and genre */
		ArrayList<String> covers = new ArrayList<String>();
		for(Movie movie :  allMovies){
			if(getSelectedRating().equals("All Ratings")){
				if(movie.getGenres().contains(selectedGenre)
						|| selectedGenre == "All"){
				covers.add(movie.getImagePath());
				}
			}
			else{
				if(movie.getRate().equals(getSelectedRating())
						&& (selectedGenre == "All" ||
								movie.getGenres().contains(selectedGenre))){
					covers.add(movie.getImagePath());
				}
			}
		}
		return covers;	
	}
	
	/**
	 * Bubble sort for sorting movies
	 * @param list
	 * @param type
	 * @return ArrayList of movies to be displayed
	 */
	 public static ArrayList<Movie> bubblesrt(ArrayList<Movie> list, String type)
	  {
	        Movie temp;
	        if(type=="release"){
	        if (list.size()>1) // check if the number of orders is larger than 1
	        {
	            for (int x=0; x<list.size() - 1; x++) // bubble sort outer loop
	            {
	                for (int i=0; i < list.size() - x -1; i++) {	                	
	                	if (list.get(i).compareTo(list.get(i+1)) > 0)
	                    {
	                        temp = list.get(i);
	                        list.set(i,list.get(i+1) );
	                        list.set(i+1, temp);
	                    }	
	                	}
	                }
	            }
	        }
	        if(type=="alpha"){
	        	if (list.size()>1) // check if the number of orders is larger than 1
		        {
		            for (int x=0; x<list.size() - 1; x++) // bubble sort outer loop
		            {
		                for (int i=0; i < list.size() - x -1; i++) {	                	
		                	if (list.get(i).compareTitleTo(list.get(i+1)) > 0)
		                    {
		                        temp = list.get(i);
		                        list.set(i,list.get(i+1) );
		                        list.set(i+1, temp);
		                    }	
		                	}
		                }
		            }

	        	
	        }    
	        return list;
	  }
		
	/**
	 * Sends the user back to the first page when clicked
	 * 
	 * @return string that facesConfig uses to send the user to the home page
	 */
	public String continueButton(){
		return "firstPage";
	}

	/**
	 * When a movie is selected it will send the user to the movie selection 
	 * page
	 * 
	 * @return String of "valid"
	 */
	public String selectMovie(){
		return "valid";
	}
}