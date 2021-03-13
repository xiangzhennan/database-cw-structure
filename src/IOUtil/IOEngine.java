package IOUtil;

/*
* IOEngine deals with file
* the reasons to have this class are:
* 	1. io is needed in each sqlStatement.run()
* 	2. we dont want to nest fileIO logic with parsing
* 	3. we dont want a lot of IO class exposed to statement classes
* 	4. we dont want a lot of IO instance(optional, google/baidu for 'singleton' if you are interested)
* */
public class IOEngine {
	/*
	* the following are some smaller class you may want to create
	* if you want to divide IO module into smaller modules(highly recommend)
	* but we only need to expose IOEngine to the outside
	* */
	private Object directoryIOUtil;
	private Object fileIOUtil;
	private Object dataSelector;
	private Object commonIOUtil;

	public void readFile(String fileName){
		System.out.println("read info from file "+ fileName);
	}

	public void writeFile(String fileName){
		System.out.println("write something to file "+ fileName);
	}
}
