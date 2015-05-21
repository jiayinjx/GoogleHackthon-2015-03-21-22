package control;
import java.util.*;


/**
 * The Movie class represents a single movie that keeps track of its
 * title and cast of actors.
 * 
 * @author CS 367 copyright 2014
 */
public class University {


 private String name; // the university name
 private Double GPA;
 private Integer TOEFL;
 private Integer SAT;
 private String location;
 private Integer rank;
 private String description;
 
 //private List<String> cast; // the list of actors in the movie
 
 /**
 * Constructs a university with the given title and an empty cast.
 * 
 * @param title The title of this movie.
 */
 public University(String name, int rank, double GPA, int TOEFL, int SAT, String location, String description) {
	 this.name = name;
	 this.rank = rank;
	 this.GPA = GPA;
	 this.SAT = SAT;
	 this.TOEFL = TOEFL;
	 this.location = location;
	 this.description = description;
 
 }
 
 public String getName() {
	 return name;
 }
 
 public double getGPA() {
	 return GPA;
 }
 public int getSAT() {
	 return SAT;
 }
 
 public int getTOEFL(){
	 return TOEFL;
 }
 
 public String getLocation(){
	 return location;
	 
 }
 
 public String getDescription(){
	 return description;
	 
 }
 
 public int getRank(){
	 return rank;
 }
 
 public void setName(String t) {
	 this.name = t;
 }
 
 public void setGPA(double t) {
	 this.GPA = t;
 }
 public void setSAT(int t) {
	 this.SAT = t;
 }
 
 public void setTOEFL(int t){
	 this.TOEFL = t;
 }
 
 public void setLocation(String t){
	 this.location = t;
	 
 }
 
 public void setDescription(String t){
	 this.description = t;
	 
 }
 
 public void setRank(int t){
	 this.rank = t;
 }
}
