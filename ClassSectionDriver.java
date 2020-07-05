/**
 * Last Update: 2020-07-04
 * 
 * Purpose: To create new instances of the ClassSection class
 * This is the driver of ClassSection, which creates ClassSection objects for scheduling systems
 * 
 */
public class ClassSectionDriver {
  
  public static void main(String[] args) { 
    
    // instatiates ClassSelection as myClass
    ClassSection myClass = new ClassSection();
    
    // setting attributes for myClass
    myClass.setRegNum(12345);
    myClass.setDeptCode("SUBJ");
    myClass.setCourseNum(456);
    myClass.setInstMode("On campus");
    myClass.setMeetDays("MW");
    myClass.setMeetTimes("1545-1730");
    myClass.setClassCapacity(15);
    myClass.setClassEnrollment(14);
    myClass.setInstID(789);
    
    // does some very, very basic validation for the verifiable attributes
    validateInstMode(myClass.getInstMode());
    validateMeetDays(myClass.getMeetDays());
    validateCapacityEnrollment(myClass.getClassCapacity(), myClass.getClassEnrollment());
    validateMeetTimes(myClass.getMeetTimes());
    
    
    myClass.toString(); // displays results
 
  } // end of main()
  
  
  
  /*
   * 
   * 
   * Methods for warning messages/"validation" (though there's no input)
   * 
   * 
   * 
   * 
   * */
  
  
  // warning message if instructional mode isn't valid
  public static void validateInstMode(String instMode) {
    String[] modes = {"ONLINE", "ON CAMPUS", "HYBRID"};
    String testMode = instMode.toUpperCase();
    boolean valid = false;
    // compares this.instMode() to the values in the local modes[] array
    for (int i = 0; i < modes.length; i++) {
      if (testMode.equals(modes[i])) {
        valid = true;
      }   
    }
    // warning message if and only if this.instMode() was not found in modes[] 
    if (!valid) {
     System.out.println("\nPlease use the setInstMode() method to enter a valid instructional mode.\n" +
                        "Accepted modes are: online, on campus, hybrid.\n");
    }
  }
  
  
  
  
  
  
  // warning message if meet days are not valid
  public static void validateMeetDays(String meetDays) {
    String days = "MTWHFSU"; // this system uses H for Thursday and U for Sunday
    // iterates through meetDays to ensure that all values are valid
    for (int i = 0; i < meetDays.length(); i++) {
      String testString = Character.toString(meetDays.charAt(i));
      if (!days.contains(testString)) {
        System.out.printf("\nAt least one argument for setMeetDays was not recognized. Please use setMeetDays to enter a valid argument.\n"+
                            "Remember that the days of the week can be entered as MTWHFSU\n\n");
        break;
      } 
    } 
  }
  
  
  
  
  
  
  
  // compares capacity and enrollment AND ensures that only 0 or positive integers are accepted
  public static void validateCapacityEnrollment(int capacity, int enrollment) {
    // warning message if more enrolled than class capacity can handle
    if (enrollment > capacity) {
      System.out.printf("\nWarning! Your class enrollment is set at %d, which exceeds your class capacity (%d).\n" +
                        "If this is an error, please use setClassCapacity() or setClassEnrollment() methods to correct this.\n", 
                        enrollment, capacity);
    }
    // warning message if either number is negative
    if (enrollment < 0) {
      System.out.printf("You have entered an invalid enrollment. Please pass a positive integer as your argument for setClassEnrollment().");
    } else if (capacity < 0) {
        System.out.println("You have entered an invalid capacity. Please pass a positive integer as your argument for setClassCapacity().");
      }
  }
  
  
  
  
  
  
  
  
  // checks formatting and validity of meeting times
  public static void validateMeetTimes(String meetTimes) {
    // if formatted correctly, this should allow for the creation of a string array
    String[] timesArray = new String[2];
    try {
      timesArray = meetTimes.split("-");
    } catch (Exception e) {
      System.out.println("\nThe format of your setMeetTimes() argument was not recognized.\n"+
                         "Please use the 24-hour format hhmm-hhmm for your class times.\n");
    }
    // checks classStart and classEnd times
    try {
      for (int i = 0; i < timesArray.length; i++) {
        // checks that each time is in valid range
        int time = Integer.parseInt(timesArray[i]);
        if ((time < 0 || time > 2359) || (time % 100 > 60)) {
          System.out.println("The meetTime you entered is invalid.\n");
        } 
      }
      // checks that end time comes after start time
      if (Integer.parseInt(timesArray[0]) >= Integer.parseInt(timesArray[1])) {
        System.out.println("In setMeetTime(), please ensure that your end time precedes your start time.");
      }
    } catch (Exception e) {} // this error was already caught above, but is repeated to avoid breaking the program
  }
}
