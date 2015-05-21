package control;
import java.util.List;
import java.util. ArrayList;
import java.util.Iterator;

public class UniversityDB 
{
	List <University> UDB = new ArrayList<University>();	

	//constructor
	public UniversityDB(){
		UDB = new ArrayList <University>();
	}
	
	public List<University> getDB(){
		return UDB;
	}
	public List<String> SearchGPA (double t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getGPA() < t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}
	
	public List<String> SearchSAT (int t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getSAT() < t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}

	public List<String> SearchTOEFL (int t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getTOEFL() < t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}

	public List<String> SearchLocation (String t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getLocation() == t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}

	public List<String> SearchRankup (int t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getRank() < t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}
	
	public List<String> SearchRankdown (int t){
		List <String> result = new ArrayList<String>();
		for (int i=0; i<UDB.size(); i++){
			if (UDB.get(i).getRank() > t){
				result.add(UDB.get(i).getName());
			}
		}
		return result;
	}
	
	public void printUniversity (){
		for (int i=0; i<UDB.size(); i++){
			System.out.println(UDB.get(i).getName() + UDB.get(i).getGPA() + UDB.get(i).getTOEFL() + UDB.get(i).getSAT() + UDB.get(i).getLocation() + UDB.get(i).getDescription()
					+ UDB.get(i).getRank());
		}
	}
	
	public boolean containsUniversity(String u){
        int count = 0;
        Iterator <University> itr = UDB.iterator();
        
        while(itr.hasNext()){
            if(itr.next().getName().equals(u))
                count++;
        }
        
        if (count == 0)
            return false;
        else
            return true;
    }
	public void changeGPA (University U, double t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setGPA(t);
				}
			}
		}
	}
	
	public void changeSAT (University U, int t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setSAT(t);
				}
			}
		}
	}

	public void changeTOEFL (University U, int t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setTOEFL(t);
				}
			}
		}
	}

	public void changeLocation (University U, String t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setLocation(t);
				}
			}
		}
	}

	public void changeRank (University U, int t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setRank(t);
				}
			}
		}
	}

	public void changeDescription (University U, String t){
		if (UDB.contains(U) == false){
			throw new IllegalArgumentException();
		}
		else {
			for (int i=0; i< UDB.size(); i++){
				if (UDB.get(i).getName() == U.getName()){
					UDB.get(i).setDescription(t);
				}
			}
		}
	}

	// input a list of data that is related to the university 
	// add it to the list of universities
	public void addUniversity(University U){
	        if(!containsUniversity(U.getName()))
	            UDB.add(U);	
	}
		
	// remove a university with the given name from the database
	public boolean removeUniversity (String name){
		Iterator <University> itr = UDB.iterator();
        int count = 0;
        while (itr.hasNext()){
            if(itr.next().getName().equals(name)){
                count++;
                UDB.remove(itr.next());
            }    
        }
        
        if (count != 0)
        {
            return true;
        }
        else
            return false;
    }	
}