package control;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

	public static UniversityDB univDb;
	public SearchEngine(){
		univDb = new UniversityDB();
		File file = new File(Global.database);
		Scanner fileIn = null;;
		try {
			fileIn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("do not find database file.");
		}  //for console input
		while(fileIn.hasNextLine()){
			String[] line = fileIn.nextLine().split(",");
			String name =line[0];
			int rank = Integer.parseInt(line[6].trim());
			double GPA = Double.parseDouble(line[1].trim());
			int TOEFL= Integer.parseInt(line[2].trim());
			int SAT = Integer.parseInt(line[3].trim());
			String location = line[4];
			String description = line[5];
			University U = new University(name, rank, GPA, TOEFL, SAT, location, description);
			univDb.addUniversity(U);
		}
		fileIn.close();
	}

	public String SearchSchool(String gpa, String toefl, String sat, String location){

		List <University> ideal = new ArrayList<University>();
		List <University> ideal2 = new ArrayList<University>();
		List <University> ideal3 = new ArrayList<University>();
		List <University> ideal4 = new ArrayList<University>();
		List <University> ideal5 = new ArrayList<University>();
		for (int i=0;i< univDb.getDB().size(); i++){
			ideal.add(univDb.getDB().get(i));
		}


		double idealGPA = Double.parseDouble(gpa);
		for (int i=0; i<ideal.size();i++){
			if (ideal.get(i).getGPA() <= idealGPA){
				ideal2.add(ideal.get(i));
			}
		}

		int idealTOEFL = Integer.parseInt(toefl);
		for (int i=0; i<ideal2.size();i++){
			if (ideal2.get(i).getTOEFL() <= idealTOEFL){
				ideal3.add(ideal2.get(i));
			}
		}


		int idealSAT = Integer.parseInt(sat);
		for (int i=0; i<ideal3.size();i++){
			if (ideal3.get(i).getSAT() <= idealSAT){
				ideal4.add(ideal3.get(i));
			}
		}

		String idealLocation = location;
		for (int i=0; i<ideal4.size();i++){
			if (ideal4.get(i).getLocation().equals(idealLocation)){
				ideal5.add(ideal4.get(i));
			}
		}

		String out = "";
		for (int i=0; i<ideal5.size();i++){
			out+=ideal5.get(i).getName()+"\n";
		}
		return out;
	}
	public String DreamSchool(String school, String gpa, String toefl, String sat, boolean _international){

		List <University> ideal = new ArrayList<University>();
		ideal = univDb.getDB();
		double prob = 50;
		int yourSAT = Integer.parseInt(sat);
		int yourTOEFL = Integer.parseInt(toefl);
		University U = null;
		boolean international = _international;
		double yourGPA = Double.parseDouble(gpa);
		String idealUniversity = school;

		for (int i=0; i<univDb.getDB().size(); i++){
			if(univDb.getDB().get(i).getName().equals(idealUniversity)){
				U = univDb.getDB().get(i);
			}
		}

		if (U.getGPA() <= yourGPA){
			prob += (yourGPA - U.getGPA())/ 0.01;
		}


		if (U.getSAT() <= yourSAT){
			prob += (yourSAT - U.getSAT())/20;
		}



		if(international){

			if(yourTOEFL >= U.getTOEFL())
				prob +=0;
			else
				prob = 0;
		}
		if (prob > 70){
			prob = 70;
		}


		String out = "";
		out+="The probability that you could be admitted by your dream university is:" + String.format("%.2f", prob) + "%.\n";
		if (yourTOEFL < U.getTOEFL() && international == true){
			out+="Your TOEFL is too low, you should keep taking TOEFL Test.\n";
		}
		if (U.getSAT() > yourSAT){
			out+="Your SAT is not enough, keep working on SAT Test.\n";
		}
		if (U.getGPA() > yourGPA){
			out+="Your GPA does not mathch the university's requirement, keep working on your course work.\n";
		}
		else {
			out+="You course work and test scores are pretty good! Keep working on your application "+
					"essays, and excurricular activities, and you are very likely to get in.\n";
		}

		return out;
	}
	public void ChangeUniversityInfo(String university, String rank, String gpa, String toefl, String sat, String location, String description){

		/*
		System.out.println("Please entry your username:");
		String userName = input.next();
		System.out.println("Please entry your password:");
		String passWord = input.next();
		if(userName.equals(userNameC) && passWord.equals(passWordC)){
			System.out.println("Login in successful, please choose:");
			String optionA = null;
			do{

				System.out.println("1.Change Universities' information");
				System.out.println("2.Change password");
				System.out.println("3.Quit");
				optionA = input.next();
				if(optionA.equals("1")){
					University U = null;
					System.out.println("Please entry the name of the unicersity:");
					String universityName = input.nextLine();
					universityName = input.nextLine();

					if (a.containsUniversity(universityName)){
						for (int i=0;i<a.getDB().size();i++){
							if (a.getDB().get(i).getName().equals(universityName)){
								U = a.getDB().get(i);
							}
						}
						do{
							System.out.println("Please selcet the data you want to change or enter 7 to quit:");
							System.out.println("1. Rank");
							System.out.println("2. GPA");
							System.out.println("3. TOEFL");
							System.out.println("4. SAT");
							System.out.println("5. Location");
							System.out.println("6. Description");
							option = input.next();

							if(option.equals("1")){
								System.out.println("Please enter new Rank");
								int newRank = input.nextInt();
								a.changeRank (U, newRank);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("2")){
								System.out.println("Please enter new GPA");
								Double newGPA = input.nextDouble();
								a.changeGPA (U, newGPA);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("3")){
								System.out.println("Please enter new TOEFL");
								int newTOEFL = input.nextInt();
								a.changeTOEFL(U, newTOEFL);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("4")){
								System.out.println("Please enter new SAT");
								int newSAT = input.nextInt();
								a.changeSAT(U, newSAT);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("5")){
								System.out.println("Please enter new Location");
								String newLocation = input.next();
								a.changeLocation(U, newLocation);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("6")){
								System.out.println("Please enter new Description");
								String newDescription = input.next();
								a.changeDescription(U, newDescription);
								System.out.println("The database has been updated successfully");
							}else if(option.equals("7")){

							}else{
								System.out.println("Invalid input, please enter integer 1~8");
							}

						}while(!option.equals("7"));
					}
					else {
						System.out.println("Cannot find this university!");
					}

				}else if(optionA.equals("2") ){
					System.out.println("Please entry your new password:");
					passWordC = input.next();
					System.out.println("Success! Your new password is: "+passWordC);
				}else if(optionA.equals("3")){

				}else{
					System.out.println("Input must be 1 or 2 or 3");
					System.out.println("Please entry again:");
				}
			}while(!optionA.equals("3"));

		}else{
			System.out.println("Incorrect username and password!\n");
			continue;
		}
	 */
	}
}
