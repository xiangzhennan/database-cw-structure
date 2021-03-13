import statements.Create;
import statements.Select;
import statements.Sql;

public class SqlFactory {

	//workingDB records which DB is in use, and it can only be changed by a use statement
	private String workingDB;

	public String parseAndRun(String incomingCommand) {
		/*
		* this is a reference of type Sql
		* since every sql class is a child of Sql
		* we can use the reference to point to any instance of subclass of Sql
		* */
		Sql sqlStatement;

		//generate real instance according  to keyword
		if ("select".equalsIgnoreCase(incomingCommand)){
			sqlStatement = new Select();
			/*sometimes you may want to pass workingDB into the constructor for statements like Select or Alter or ...
			then you do:
				sqlStatement = new Select(workingDB);
			*/
		}else if ("create".equalsIgnoreCase(incomingCommand)){
			/*
			 * now you can understand why we declared a reference of type Sql instead of Select or Create
			 * if we have a reference of type Select,
			 * then here we need to create a new reference
			 * */
			sqlStatement = new Create();
		}else{
			return "[ERROR]";
		}
		/*
		* here is the important part of the factory
		* make sure you understand the next 2 lines before you make decision to use my structure
		* otherwise you may get lost
		*
		* rough explain:
		* because of how JVM works, sqlStatement.parse() will automatically find the correct method to call
		* for example, if the real type of sqlStatement is Select, then parse() method in class Select is actually used
		* same thing for run()
		* */
		try{
			sqlStatement.parse(incomingCommand);
			sqlStatement.run();
			return "[OK]";
		}catch (Exception e){
			return "[ERROR]";
		}
	}
}
