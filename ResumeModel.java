/**
 * 
 */
package edu.sollers.javaprog.resumerbuilder;

import java.util.ArrayList;

/**
 * @author praka
 *
 */
public class ResumeModel {
	
	// elements array list that is used to pack all elements on save
	ArrayList<ResumeElement> elements;
	
	// Fields
	private PersonalInfo personalInfo;
	private Summary summary;
	private Objective objective;
	private ArrayList<Education> education;
	private ArrayList<Experience> experience;
	private ArrayList<Publication> publication;
//	private ArrayList<membership> membership;
	
	
	/**
	 * Getter for education
	 * @return ArrayList of Education object(s) or null
	 */
	public ArrayList<Education> getEducation() {
		return education;
	}

	/**
	 * Set/add to education field. Adds to Education arraylist if arraylist is not null.
	 * @param schoolName
	 * @param schoolCity
	 * @param schoolState
	 * @param degree
	 * @param major
	 * @param gradMonth
	 * @param gradYear
	 * @param isAnticipated
	 */
	public void setEducation(String schoolName, String schoolCity, String schoolState, String degree, String major, String gradMonth, String gradYear, boolean isAnticipated) {
		
		// Initialize object with parameters
		Education edu = new Education(schoolName, schoolCity, schoolState, degree, major, gradMonth, Integer.parseInt(gradYear), isAnticipated);

		if (education == null) {
			education = new ArrayList<>();
		}
		education.add(edu);
		System.out.println(edu);
	}
	
	/**
	 * @return the objective
	 */
	public Objective getObjective() {
		return objective;
	}

	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = new Objective(objective);
		System.out.println(this.objective);
	}

	public void pack() throws Exception {
		elements = new ArrayList<ResumeElement>();
		
		if (personalInfo == null | summary == null | objective == null | education == null | experience == null) {
			throw new MissingRequiredFieldsException("Missing Required Fields");
		}
		else {
			elements.add(personalInfo);
			elements.add(summary);
			elements.add(objective);
			for (Education e: education) {
				elements.add(e);
			}
			for (Experience e: experience) {
				elements.add(e);
			}
			if (publication != null) {
				for (Publication p: publication) {
					elements.add(p);
				}
			}
//			if (memberships != null) {
//				for (Membership m: memberships) {
//					elements.add(m);
//				}
//			}
//			if (extraCurrActs != null) {
//				for (ExtraCurr e: extraCurrActs) {
//					elements.add(e);
//				}
//			}


		}
	}
	
	public void clear() {
		
	}
	
	public ResumeElement addObjective(String objective) {
		Objective obj = new Objective(objective);
		return obj;
	}

	
	public void addElement(ResumeElement element) {
		elements.add(element);
	}
	
	public void save() throws Exception {
		pack();
		for(ResumeElement re: elements) {
			re.save();
		}
		
	}
	
	class MissingRequiredFieldsException extends Exception {
		private static final long serialVersionUID = 1L;

		public MissingRequiredFieldsException(String message) {
			super(message);
		}
	}

}
